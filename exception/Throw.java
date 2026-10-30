package exception;

public class Throw {

    static void checkAge(int age) {
        if (age < 18) {
            throw new ArithmeticException("Access Denied. Should be 18 yrs old");
        } else {
            System.out.println("Access Granted");
        }
    }

    public static void main(String[] args) {
        checkAge(50);

    }

}
