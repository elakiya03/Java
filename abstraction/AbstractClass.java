package abstraction;

abstract class Fabric {

    static int count;

    final double PI = 3.14;

    Fabric() {
        Fabric.count = 0;
    }

    abstract void getName();

    int getPrice() {
        return 500;
    }

}

public class AbstractClass extends Fabric {

    @Override
    void getName() {
        System.out.println("Elakiya");
    }

    public static void main(String[] args) {
        AbstractClass a = new AbstractClass();
        System.out.println(a.getPrice());
        a.getName();
    }

}
