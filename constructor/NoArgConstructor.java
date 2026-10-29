package constructor;

public class NoArgConstructor {
    int x;
    String y;

    public NoArgConstructor() {
        this.x = 1;
        this.y = "elaks";
    }

    public static void main(String... args) {
        NoArgConstructor n = new NoArgConstructor();
        NoArgConstructor n1 = new NoArgConstructor();
        System.out.printf("%d %s %n", n.x, n.y);
        System.out.printf("%d %s %n", n1.x, n1.y);

    }

}
