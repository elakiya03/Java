package abstraction;

interface FabricInterface {
    // 1. Every variable inside an interface is automatically 'public static final'
    // You cannot declare a blank 'static int count;' without initializing it.
    double PI = 3.14;

    // 2. Constructors are strictly banned in interfaces!
    // FabricInterface() { } // ERROR

    // 3. Placeholder methods do not require the 'abstract' keyword
    void getName();

    // 4. Fully implemented methods must be explicitly marked 'default' or 'static'
    default int getPrice() {
        return 500;
    }
}

// Child classes link using the 'implements' keyword instead of 'extends'
public class Interface implements FabricInterface {

    @Override
    public void getName() { // Rule: Overriding interface methods MUST be marked public!
        System.out.println("Elakiya via Interface");
    }

    public static void main(String[] args) {
        Interface i = new Interface();
        System.out.println(i.getPrice());
        i.getName();
    }
}
