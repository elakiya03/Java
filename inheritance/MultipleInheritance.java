package inheritance;

interface Class1 {
    void getName();

    void getSound();
}

interface Class2 {
}

public class MultipleInheritance implements Class1, Class2 {
    @Override
    public void getName() {
        System.out.println("elaks");
    }

    @Override
    public void getSound() {
        System.out.println("haha");
    }

    public static void main(String[] args) {
        MultipleInheritance h = new MultipleInheritance();
        h.getName();
        h.getSound();
    }

}
