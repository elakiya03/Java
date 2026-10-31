package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Limit {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(15, 10, 2, 23, 31, 9, 10, 1);

        Set<Integer> set = new HashSet<Integer>();

        list.stream()
                .filter(n -> set.add(n))
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .forEach(System.out::println);
        ;
    }

}
// Given a list of numbers with duplicates, remove all duplicate entries, sort
// the unique numbers in descending order, and return only the top 3 highest
// values.