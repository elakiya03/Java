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

public class Upcasting {
    public static void main(String[] args) {
        Parent p = new Child(); // Creating a Parent class object but referencing it to a Child class. 
        p.display();

    }
}
