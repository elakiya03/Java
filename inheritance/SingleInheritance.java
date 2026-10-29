package inheritance;

class Inheritance {
    static void display() {
        System.out.println("Inside Parents class - static");
    }

    void displayin() {
        System.out.println("Inside Parents class - normal methods");
    }
}

public class SingleInheritance extends Inheritance {

    // 1. METHOD HIDING: Same signature, but marked static.
    // You CANNOT use @Override here. It hides the parent's version.
    static void display() {
        System.out.println("Child - static");
    }

    // 2. METHOD OVERRIDING: Standard dynamic binding.
    @Override
    void displayin() {
        System.out.println("Inside Child class - normal methods");
    }

    public static void main(String[] args) {
        SingleInheritance s = new SingleInheritance();

        // A. Static method call (Method Hiding)
        // Resolves at compile time based on the REFERENCE TYPE (Inheritance)
        Inheritance.display();

        display();

        // B. Normal method call (Method Overriding)
        // Resolves at runtime based on the ACTUAL OBJECT (SingleInheritance)
        s.displayin();
    }

}
