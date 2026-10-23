class EagerInitializationLogger {

    // created as soon as the class is loaded, before any thread
    // could possibly call getInstance
    private static final EagerInitializationLogger instance = new EagerInitializationLogger();

    // Private constructor prevents creating objects from outside the class
    private EagerInitializationLogger() {}

    public static EagerInitializationLogger getInstance() {
        return instance; // just a read, always safe, always ready
    }
}

public class EagerInitialization {
    public static void main(String[] args) {
        EagerInitializationLogger first = EagerInitializationLogger.getInstance();
        EagerInitializationLogger second = EagerInitializationLogger.getInstance();
        System.out.println("Same instance both times: " + (first == second));
    }
}