package strings;

public class Stringbuilder {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        str.append("elakspandiyan");
        System.out.println(str);

        StringBuilder str2 = str;

        if (str == str2)
            System.out.println("Same");
        else
            System.out.println("Not Same");

        if (str.equals(str2))
            System.out.println("Same");
        else
            System.out.println("Not Same");

        // 1. Length
        System.out.println(str.length());

        // 2. ChatAt
        System.out.println(str.charAt(6));

        // 3. Set char At
        str.setCharAt(6, 'A');
        System.out.println(str);

        // 4. LowerCase
        System.out.println(str.toString().toLowerCase());

        // 5. Uppercase
        System.out.println(str.toString().toUpperCase());

        // 6. Reverse
        System.out.println(str.reverse());

        // 7. Capacity
        System.out.println("Default capacity: " + str.capacity());

        // 8. Insert char/String
        System.out.println(str.insert(2, 'A'));
        System.out.println(str.insert(0, "viru"));

        // 9. Delete char sequence from start to end
        System.out.println(str.delete(str.length() - 2, str.length() - 1)); // second letter

        // 10. Delete char at index
        System.out.println(str.deleteCharAt(7));

        // 11. Substring from index
        System.out.println(str.substring(5));

    }

}
