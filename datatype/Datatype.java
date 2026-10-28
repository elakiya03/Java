package datatype;

import java.util.Scanner;

public class Datatype {

    public static void main(String args[]) {

        final int age = 24; // final keyword behaves as constant in java

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a short (Range: -32768 to 32767): ");
        short s = scanner.nextShort();
        scanner.nextLine();
        System.out.println("You entered short: " + s);

        System.out.println("Enter a byte (Range: -128 to 127): ");
        byte b = scanner.nextByte();
        scanner.nextLine();
        System.out.println("You entered byte: " + b);

        System.out.println("Enter an int (Range: -2147483648 to 2147483647): ");
        int num = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.println("You entered int: " + num);

        System.out.println("Enter a float (Range: ±3.4 × 10^38): ");
        float f = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("You entered float: " + f);

        System.out.println("Enter a double (Range: ±1.7 × 10^308): ");
        double d = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("You entered double: " + d);

        System.out.println("Enter a char: ");
        char c = scanner.next().charAt(0); // No dedicated nextChar(); use first token char
        scanner.nextLine();
        System.out.println("You entered char: " + c);

        System.out.println("Enter a boolean (true/false): ");
        boolean flag = scanner.nextBoolean();
        scanner.nextLine();
        System.out.println("You entered boolean: " + flag);

        System.out.println("Enter a long (Range: -9223372036854775808 to 9223372036854775807): ");
        long l = scanner.nextLong();
        scanner.nextLine();
        System.out.println("You entered long: " + l);

        System.out.println("Enter a String: ");
        String str = scanner.nextLine();
        System.out.println("You entered String: " + str);

        scanner.close();
    }
}
