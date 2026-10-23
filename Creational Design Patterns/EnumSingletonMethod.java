enum EnumSingleton {
    INSTANCE;

    // Add any singleton logic here
    public void doSomething() {
        System.out.println("Singleton doing something.");
    }
}

public class EnumSingletonMethod {
    public static void main(String[] args) {
        EnumSingleton.INSTANCE.doSomething();

        System.out.println("Same instance? " + (EnumSingleton.INSTANCE == EnumSingleton.INSTANCE));
    }
}