package singleton;
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

        EnumSingleton first = EnumSingleton.INSTANCE;
        EnumSingleton second = EnumSingleton.INSTANCE;

        first.doSomething();

        System.out.println("Same instance? " + (first == second));
    }
}

/*
PS C:\Users\ADITYA AGRAWAL\Desktop\SystemDesign> git checkout -b "Enum Singleton"
fatal: 'Enum Singleton' is not a valid branch name
hint: See 'git help check-ref-format'
hint: Disable this message with "git config set advice.refSyntax false"
*/