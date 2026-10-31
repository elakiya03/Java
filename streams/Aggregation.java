package streams;

import java.util.Arrays;
import java.util.List;

public class Aggregation {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        double avg = list.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue) // Shorthand for unboxing
                .average() // Returns OptionalDouble
                .orElse(0.0);

        System.out.println(avg);
    }
}

// Given a list of integers, filter out the even numbers and calculate their
// average value. Return 0.0 if no even numbers exist.