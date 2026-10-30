package exception;

public class Throws {

    static void validateUser(String username) throws Exception {
        if (username.equals("admin")) {
            // 2. Action: Actually throwing the exception!
            throw new Exception("Username already taken.");
        }
    }

    public static void main(String[] args) throws Exception {
        validateUser("elaks");
        validateUser("admin");
    }

}
