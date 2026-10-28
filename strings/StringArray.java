package strings;

import java.util.Arrays;

public class StringArray {
    public static void main(String[] args) {
        String[] cricket = new String[5];

        String[] cric;
        // cric[0] = "virat"; ---> cause err

        cric = new String[] { "virat", "bumrah", "gill" };

        System.out.println(cric.length);

        System.out.println(Arrays.toString(cric));
    }

}
