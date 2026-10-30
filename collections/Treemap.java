package collections;

import java.util.Map;
import java.util.TreeMap;

public class Treemap {
    public static void main(String[] args) {
        Map<Integer, String> map = new TreeMap<Integer, String>();

         // 1.Add
        map.put(18, "Virat");
        map.put(77, "Gill");
        map.put(1, "Rahul");

        // 2. Print
        System.out.println(map);

        // 3. Get Keys
        for (Integer i : map.keySet()) {
            System.out.println(i);
        }

        // 4. Get Values
        for (String s : map.values()) {
            System.out.println(s);
        }

        // 5. Key - Get value
        for (Integer i : map.keySet()) {
            System.out.println(i + " - " + map.get(i));
        }
        
    }
}
