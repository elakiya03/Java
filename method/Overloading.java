package method;

public class Overloading {

    static int add(int a, int b) {
        return a + b;
    }

    static int add(int a, int b, int c) {
        return a + b + c;
    }

    static String add(String fname, String lname) {
        return fname + " " + lname;
    }

    public static void main(String[] args) {
        int a = add(1, 2);
        int b = add(1, 2, 3);
        String s = add("Elakiya", "Tamizh");

        System.out.println(a);
        System.out.println(b);
        System.out.println(s);
    }

}
