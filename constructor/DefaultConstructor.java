package constructor;

public class DefaultConstructor {

    int x;
    String y;

    public static void main(String... args) {
        DefaultConstructor c = new DefaultConstructor();
        System.out.printf("%d %s %n", c.x, c.y);
    }

}

// If you do not write any constructor inside your class, the Java compiler
// automatically inserts a hidden, no-argument constructor for you behind the
// scenes. It sets all your variables to their default values (0 for numbers,
// null for objects) [•].