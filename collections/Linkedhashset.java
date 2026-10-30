package collections;

import java.util.LinkedHashSet;
import java.util.Set;

public class Linkedhashset {
    public static void main(String[] args) {
        Set<Integer> set = new LinkedHashSet<Integer>();

        // 1. Add
        set.add(10);
        set.add(3);
        set.add(3); // Duplicate automatically removed
        set.add(15);
        set.add(9);

        // 2. Print
        System.out.println(set);

        for (int i = 0; i < set.size(); i++) { // 3. Size
            if (set.contains(9)) {
                System.out.println("Found");
                set.remove(9); // 4. Remove
            }
        }

        System.out.println(set);
    }

}
