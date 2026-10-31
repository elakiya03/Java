package collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Arraydeque {
    public static void main(String[] args) {
        Deque<Integer> q = new ArrayDeque<>();

        // 1.Insert
        q.add(1);
        q.add(2);
        q.add(3);

        // 2. print
        System.out.println(q);

        // 3. Insert at Front
        q.push(4);
        q.addFirst(5);

        // 4. Insert at Last
        q.addLast(6);
        System.out.println(q);

        // 5. Get first and last element
        System.out.println(q.getFirst());
        System.out.println(q.getLast());

        // Length
        System.out.println(q.size());

        // 7. Remove first and last
        System.out.println(q.removeFirst());
        System.out.println(q.removeLast());
        System.out.println(q);

        // 8. empty?
        System.out.println(q.isEmpty());

        // iterate
        for (Iterator it = q.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }
    }
}
