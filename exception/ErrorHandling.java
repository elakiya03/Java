package exception;

import java.util.Scanner;
import java.util.InputMismatchException;

public class ErrorHandling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter an integer: ");
            int n = sc.nextInt(); // Automatically throws InputMismatchException if input is not an int
            System.out.println("You entered: " + n);
        } catch (InputMismatchException e) {
            System.out.println("You should enter integer!");
        } finally {
            sc.close();
            System.out.println("I will be executed anyways.");
        }
    }
}
