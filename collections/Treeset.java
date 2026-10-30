package collections;

import java.util.Set;
import java.util.TreeSet;

public class Treeset {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<Integer>();

        // 1. Add
        set.add(10);
        set.add(3);
        set.add(30);
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
