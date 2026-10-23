class BillPughSingleton {
    private BillPughSingleton() { }

    // Inner class is not loaded until getInstance() is called
    private static class Holder {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return Holder.INSTANCE;
    }
}

public class BillPughSingletonMethod {
    public static void main(String[] args) {
        BillPughSingleton a = BillPughSingleton.getInstance();
        BillPughSingleton b = BillPughSingleton.getInstance();

        System.out.println("Same instance? " + (a == b));
    }
}

/*
Holder is not loaded when BillPughSingleton is loaded. 
It is only loaded when getInstance() is called for the first time triggering the initialization of INSTANCE. 
Class initialization in Java is guaranteed thread-safe by the JLS with no explicit synchronization needed.

The Bill Pugh approach delivers a perfect balance of lazy initialization, thread safety, 
and performance without the complexity of double-checked locking.
*/