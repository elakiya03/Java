package streams;

import java.util.Arrays;
import java.util.List;

public class MapStream {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        list.stream()
                .filter(n -> n % 2 != 0)
                .map(n -> n * n)
                .forEach(System.out::println);
    }
}

// Given a list of integers, find all the odd numbers, square them (multiply by
// themselves), and print each squared value directly from the stream.
// • Input List: [1, 2, 3, 4, 5, 6]
// • Expected Output: Prints 1, 9, 25 (each on a new line).