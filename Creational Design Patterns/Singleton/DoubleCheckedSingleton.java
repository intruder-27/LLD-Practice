class DoubleCheckedSingletonLogger {
    // volatile prevents reordering of instructions in: instance = new Singleton()
    // since it involves three steps: allocate memory, call constructor, assign reference
    private static volatile DoubleCheckedSingletonLogger instance;

    // Private constructor prevents external instantiation
    private DoubleCheckedSingletonLogger() {}

    // Global access point to get the Singleton instance
    public static DoubleCheckedSingletonLogger getInstance() {

        // Fast path: first check without locking
        if (instance == null) {
            // Lock only when the instance might need to be created
            synchronized (DoubleCheckedSingletonLogger.class) {
                // Second check inside the lock (prevents double creation)
                if (instance == null) {
                    instance = new DoubleCheckedSingletonLogger();
                }
            }
        }

        // Return the shared instance (existing or newly created)
        return instance;
    }
}

public class DoubleCheckedSingleton {
    public static void main(String[] args) {
        DoubleCheckedSingletonLogger a = DoubleCheckedSingletonLogger.getInstance();
        DoubleCheckedSingletonLogger b = DoubleCheckedSingletonLogger.getInstance();

        System.out.println("Same instance? " + (a == b));
    }
}