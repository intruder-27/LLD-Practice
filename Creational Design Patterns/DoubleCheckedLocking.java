class Logger {

    private static volatile Logger instance;

    private Logger() {}

    public static Logger getInstance() {
        if (instance == null) {                 // first check, no locking
            synchronized (Logger.class) {
                if (instance == null) {         // second check, inside the lock
                    instance = new Logger();
                }
            }
        }
        return instance;
    }
}

// After the first successful creation, every later call sees a
// non null instance on the first check and returns immediately,
// no lock ever acquired.

public class DoubleCheckedLocking {
    public static void main(String[] args) throws InterruptedException {
        int threadCount = 8;
        Logger[] results = new Logger[threadCount];
        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            final int idx = i;
            threads[i] = new Thread(() -> results[idx] = Logger.getInstance());
        }
        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();

        boolean allSame = java.util.Arrays.stream(results).distinct().count() == 1;
        System.out.println("All threads received the same instance: " + allSame);
    }
}