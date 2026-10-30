package polymorphism;

class Tree {

    // 1. Variable
    protected String seed = "Banyan Tree";

    // 2. Constructor
    Tree() {
        System.out.println("Big Tree Constructor");
    }

    // 3. Method
    public void display() {
        System.out.println("Hello from Big Tree");
    }

}

class Sapling extends Tree {
    protected String seed = "Banyan sapling";

    Sapling() {
        super();
        System.out.println("Inside child constructor");
    }

    @Override
    public void display() {
        System.out.println("Hello back from Sapling");
    }

    void method() {
        System.out.println(super.seed);
        super.display();
        System.out.println("========================");
        System.out.println(this.seed);
        this.display();

    }

}

public class Super {
    public static void main(String[] args) {
        Sapling s = new Sapling();

        s.method();
    }
}
