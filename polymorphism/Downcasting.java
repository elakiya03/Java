package polymorphism;

class Parent {
    void display() {
        System.out.println("Parent Method");
    }
}

class Child extends Parent {
    @Override
    void display() {
        System.out.println("Child Method");
    }

    void print() {
        System.out.println("Child'd own method");
    }
}

public class Downcasting {
    public static void main(String[] args) {
        Parent p = new Child(); // Creating a Parent class object but referencing it to a Child class.
        p.display();
        // p.print(); --> Throw an err

        // to access print() (specific to subclass) in child class. we need to perform
        // downcast.
        // rememmber we can only
        // downcast an obj which is already been upcasted

        if (p instanceof Child) { // checking to avoid ClassCastException
            Child c = (Child) p;
            c.display();
            c.print();
        }
    }
}