package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap {
    public static void main(String[] args) {
        List<List<String>> list = Arrays.asList(Arrays.asList("viru", "ani"), Arrays.asList("kani", "honey"),
                Arrays.asList("elaks"));

        List<String> l = list.stream()
                .flatMap(name -> name.stream())
                .collect(Collectors.toList());

        System.out.println(l);
    }
}

//
// Problem 6: Flattening a Nested List (flatMap)

// Imagine you have a class representing a school classroom, and each classroom
// has a list of student names. Given a list of these classrooms, extract all
// the individual student names into a single, unified flat List<String>.
// • Input: [["Rohan", "Priya"], ["Amit", "Sneha"], ["John"]]
// • Expected Output: ["Rohan", "Priya", "Amit", "Sneha", "John"]
