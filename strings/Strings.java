package strings;

public class Strings {

    public static void main(String args[]) {

        String s = "elakiyasssssss Hero";

        // 1. Length
        System.out.println(s.length());

        // 2. Lowercase
        System.out.println(s.toLowerCase());

        // 3. Uppercase
        System.out.println(s.toUpperCase());

        // 4. indexOf char - position of first occurence
        System.out.println(s.indexOf('y'));

        // 5. charAt - to access a character at a specific position
        System.out.println(s.charAt(3));

        // 6. Comparing strings
        System.out.println(s.equals("elakiya"));

        // 7. Concatenation
        System.out.println(s.concat(s));
        System.out.println("Cancatenation" + " Using plus(+) operator");
    }
}
