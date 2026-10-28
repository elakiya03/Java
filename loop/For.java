package loop;

import java.util.List;

public class For {

    public static void main(String args[]) {

        // 1. Counter Based
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }

        // 2. For Enhanced Loop
        String[] s = { "Pen", "Pencil", "Eraser" };

        for (String ss : s) {
            System.out.println(ss);
        }

        // 3. Lambda
        List<String> items = List.of(s);
        items.forEach(item -> System.out.println(item));
    }

}
