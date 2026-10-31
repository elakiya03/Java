package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Grouping {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Virat", "elaks", "jimin", "Taylor", "Gill", "xiao", "Ani", "aish");

        Map<Integer, List<String>> map = names.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(map);
    }
}
