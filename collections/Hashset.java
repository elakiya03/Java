package collections;

import java.util.HashSet;
import java.util.Set;

public class Hashset {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();

        // 1. Add
        set.add(1);
        set.add(3);
        set.add(5);
        set.add(9);

        for (int i = 0; i < set.size(); i++) { // 2. Size
            if (set.contains(9)) {
                System.out.println("Found");
                set.remove(9); // 3. Remove
            }
        }

        // 4. Print
        System.out.println(set);

    }
}
