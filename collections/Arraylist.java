package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Arraylist {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>(); // List methods only

        ArrayList list2 = new ArrayList(); // ArrayList specific methods

        // 1. Add
        list1.add(1);
        list1.add(4);
        list1.add(3);

        // 2. Print
        System.out.println(list1);

        // 3. Loop
        for (int i = 0; i < list1.size(); i++) { // 4. Size
            System.out.println(list1.get(i)); // 5. Access an element
        }

        // 6. Update at specific index
        list1.set(0, 9);
        System.out.println(list1);

        // 7. Remove elemenet at index
        list1.remove(1);
        System.out.println(list1);

        // 8. sort
        list1.add(2);
        list1.add(6);
        list1.add(4);
        Collections.sort(list1);
        System.out.println(list1);

        // 9. sort in reverse order
        Collections.sort(list1, Collections.reverseOrder());
        System.out.println(list1);
    }
}
