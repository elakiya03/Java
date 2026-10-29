package accessspecifier;

public class Dummyclass {
    public static void main(String[] args) {
        AccessSpecifier a = new AccessSpecifier();
        // a.id(); --> private variable: is not accessible outside declared class
        a.z = 1; // ---> Default vairable: visible within same package/folder

        a.x = 1; // ---> Protected vairable: visible within same package/folder

        a.y = 1; // ---> Visible anywhere in the project
    }

}
