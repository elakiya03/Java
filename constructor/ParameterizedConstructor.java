package constructor;

public class ParameterizedConstructor {

    int x;
    String y;

    ParameterizedConstructor(String y, int x) { // parameterized constructor
        this.x = x;
        this.y = y;
    }

    ParameterizedConstructor() { // No arguments constructor
        this.x = 140;
        this.y = "elaks";
    }

    public static void main(String[] args) {
        ParameterizedConstructor p = new ParameterizedConstructor("Virat", 112);
        System.out.printf("%d %s %n", p.x, p.y);

        ParameterizedConstructor p1 = new ParameterizedConstructor();
        System.out.printf("%d %s %n", p1.x, p1.y);

    }
}
