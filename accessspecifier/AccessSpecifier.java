package accessspecifier;

public class AccessSpecifier {
    private int id;
    protected int x;
    public int y;
    int z; // No specifier - default

    public static void main(String[] args) {
        AccessSpecifier a = new AccessSpecifier();
        a.id = 1; // Private vairable accesible within same class

        a.x = 1;
        a.y = 1;
        a.z = 1;

    }

}
