package enumeration;

interface Inter {
    void print();
}

enum Level implements Inter { // can implement interfaces
    // Constants
    EASY,
    MEDIUM,
    DIFFICULT;

    // Variables
    int value = 7;

    // Constructor
    Level() {
        System.out.println("Its Difficult");
    }

    // Methods
    void display() {
        System.out.println("Enum can have Methods like class");
    }

    public void print() {
        System.out.println("Enum can implement Interfaces");
    }
}

public class Enumeration {
    public static void main(String[] args) {
        Level l = Level.MEDIUM;
        System.out.println(l);

        // Loop through enum
        for (Level i : Level.values()) {
            System.out.println(i);
        }

        l.display();
        l.print();
    }

}
