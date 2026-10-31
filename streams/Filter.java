package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {

    public static void main(String[] args) {
        String[] words = { "java", "c", "cpp", "js", "python" };

        List<String> list = new ArrayList<String>(Arrays.asList(words));

        // 1. Process and collect into a brand new List
        List<String> upperCaseWords = list.stream()
                .filter(word -> word.length() < 4)
                .map(word -> word.toUpperCase())
                .collect(Collectors.toList());

        // 2. Print the final collection directly
        System.out.println(upperCaseWords); // Prints: [C, CPP, JS]

        // Another way to do
        list.stream().filter(word -> word.length() < 4).map(String::toUpperCase).forEach(System.out::println);

    }

}

// Given a list of words, filter out all words that have a length of less than 4
// characters, convert the remaining words to UPPERCASE, and save them into a
// new list.
// • Input List: ["java", "cpp", "python", "go", "rust"]
// • Expected Output: ["JAVA", "PYTHON", "RUST"]
