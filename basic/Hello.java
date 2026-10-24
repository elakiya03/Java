package basic;

public class Hello {

    public static void main(String args[]) {
        System.out.println("Elakiya you can be a coder. One day");

        // Using print function
        // To Display numbers
        System.out.print(2 + "\n");

        // Mix text and numbers
        System.out.println("Its been " + 6 + " years since lockdown");

        // char
        System.out.print('இ');

    }
}

/*
 * # Java Hello World Program
 * 
 * This project contains a simple "Hello World" program in Java, demonstrating
 * the basic structure of a Java application.
 * 
 * ## Basic Java Concepts
 * 
 * ### Class Structure
 * 
 * `Every line of code that runs in Java must be inside a class.` A class is a
 * blueprint for creating objects and contains the code that defines the
 * behavior of the program.
 * 
 * In our example, we have defined a class named `Hello`:
 * 
 * ```java
 * public class Hello {
 * public static void main(String args[]){
 * System.out.println("Elakiya you can be a coder one day");
 * }
 * }
 * ```
 * 
 * ### Naming Conventions
 * 
 * - The class name should always start with an uppercase first letter. This is
 * a standard Java convention known as PascalCase.
 * - In our example, the class is named `Hello`, which starts with an uppercase
 * 'H'.
 * - Note: Java is case-sensitive. `MyClass` and `myclass` would be treated as
 * two completely different names.
 * 
 * ### File Naming Requirements
 * 
 * The name of the Java file must match the class name exactly. So if your class
 * is called `Hello`, the file must be saved as `Hello.java`. This is because
 * Java uses the class name to find and run your code. If the names don't match,
 * Java will give a compilation error and the program will not run.
 * 
 * ### The main Method
 * 
 * The `main` method is the entry point of any Java application. It is where the
 * program starts executing. The signature `public static void main(String
 * args[])` is standard and required for standalone Java programs. When you run
 * a Java program, the Java Virtual Machine (JVM) looks for the `main` method to
 * begin executing the code. Without a `main` method, the JVM wouldn't know
 * where to start.
 * 
 * ### System.out.println() Explanation
 * 
 * `System.out.println()` is used to print text to the console (screen). While
 * it may look long, you can think of it as a single command that means:
 * "Send this text to the screen."
 * 
 * Here's what each part means (you will learn the details later):
 * 
 * - `System` is a built-in Java class that provides access to system resources.
 * - `out` is a member of the `System` class, short for "output". It represents
 * the standard output stream.
 * - `println()` is a method, short for "print line". It prints the specified
 * text followed by a newline character.
 * 
 * ### Multiple Print Statements
 * 
 * You can add as many `println()` methods as you want in your program. Each
 * call will print on a new line:
 * 
 * ```java
 * public class Hello {
 * public static void main(String args[]){
 * System.out.println("Elakiya you can be a coder one day");
 * System.out.println("Keep practicing!");
 * System.out.println("Java programming is fun!");
 * }
 * }
 * ```
 * 
 * This would output:
 * 
 * ```
 * Elakiya you can be a coder one day
 * Keep practicing!
 * Java programming is fun!
 * ```
 * 
 * ## How to Run the Program
 * 
 * 1. Make sure you have Java installed on your system.
 * 2. Open a terminal and navigate to the directory containing `Hello.java`.
 * 3. Compile the program: `javac Hello.java`
 * 4. Run the program: `java Hello`
 * 
 * ## Learning Resources
 * 
 * - [Oracle Java Tutorials](https://docs.oracle.com/javase/tutorial/)
 * - [Java Documentation](https://docs.oracle.com/en/java/)
 * 
 * ## The print() Method
 * 
 * There is also a `print()` method, which is similar to `println()`. The only
 * difference is that it does not insert a new line at the end of the output.
 * 
 * For example:
 * 
 * ```java
 * public class Hello {
 * public static void main(String args[]){
 * System.out.print("Hello ");
 * System.out.print("World!");
 * }
 * }
 * ```
 * 
 * This would output:
 * 
 * ```
 * Hello World!
 * ```
 * 
 * Notice that both words appear on the same line, without a newline between
 * them. If you used `println()` for both, they would appear on separate lines.
 * 
 * ## Data types
 * 
 * Data types are divided into two groups:
 * 
 * ### Primitive Data types
 * 
 * Primitive data types - includes byte, short, int, long, float, double,
 * boolean and char
 * 
 * ### Non-Primitive Data types
 * 
 * Non-primitive data types - such as String, Arrays and Classes
 * 
 * Non-primitive data types are called reference types because they refer to
 * objects.
 * 
 * The main differences between primitive and non-primitive data types are:
 * 
 * Primitive types in Java are predefined and built into the language, while
 * non-primitive types are created by the programmer (except for String).
 * 
 * Non-primitive types can be used to call methods to perform certain
 * operations, whereas primitive types cannot.
 * 
 * Primitive types start with a lowercase letter (like int), while non-primitive
 * types typically starts with an uppercase letter (like String).
 * 
 * Primitive types always hold a value, whereas non-primitive types can be null.
 * 
 * Examples of non-primitive types are Strings, Arrays, Classes etc.
 * 
 * The var Keyword
 * The var keyword was introduced in Java 10 (released in 2018).
 * 
 * The var keyword lets the compiler automatically detect the type of a variable
 * based on the value you assign to it.
 * 
 * This helps you write cleaner code and avoid repeating types, especially for
 * long or complex types.
 * 
 * ## Java Arrays — A Refresher
 * 
 * Arrays store a fixed number of values of the same type. In Java, an array is
 * an object: its length is fixed when it is created, its elements receive
 * default values, and its indexes start at `0`.
 * 
 * ### One-dimensional arrays
 * 
 * ```java
 * int[] arr = new int[5]; // Five ints, each initially 0
 * int[] a = {1, 2, 3, 4, 5}; // Declare and initialize
 * int[] b = new int[]{1, 2, 3}; // Explicit array creation
 * int arr2[] = new int[5]; // Valid, but int[] arr2 is preferred
 * ```
 * 
 * The array length is available through the `length` field:
 * 
 * ```java
 * System.out.println(a.length); // 5
 * System.out.println(a[0]); // 1 (first element)
 * ```
 * 
 * ### Arrays of different types and default values
 * 
 * ```java
 * int[] numbers = new int[5];
 * float[] prices = new float[5];
 * double[] values = new double[5];
 * char[] letters = new char[5];
 * boolean[] flags = new boolean[5];
 * String[] names = new String[5];
 * ```
 * 
 * | Element type | Default value |
 * | --- | --- |
 * | `byte`, `short`, `int`, `long` | `0` |
 * | `float` | `0.0f` |
 * | `double` | `0.0` |
 * | `char` | `'\u0000'` (the null character) |
 * | `boolean` | `false` |
 * | Reference types, such as `String` | `null` |
 * 
 * ### Initializing and updating arrays
 * 
 * ```java
 * int[] initialized = {10, 20, 30};
 * int[] explicit = new int[]{10, 20, 30};
 * 
 * int[] values2 = new int[5];
 * values2[0] = 10;
 * values2[1] = 20;
 * ```
 * 
 * An array initializer in braces can be used directly in a declaration, but not
 * by itself in a later assignment:
 * 
 * ```java
 * int[] values3 = {1, 2, 3};
 * // values3 = {4, 5, 6}; // Does not compile
 * values3 = new int[]{4, 5, 6}; // Correct reassignment
 * 
 * printArray(new int[]{7, 8, 9}); // Anonymous array passed to a method
 * ```
 * 
 * ### Two-dimensional and jagged arrays
 * 
 * A two-dimensional array is an array of arrays. It is often used for tables
 * and grids:
 * 
 * ```java
 * int[][] matrix = new int[3][4]; // 3 rows, 4 columns
 * matrix[1][2] = 7; // Row 1, column 2
 * 
 * int[][] initializedMatrix = {
 * {1, 2, 3},
 * {4, 5, 6}
 * };
 * 
 * int[][] explicitMatrix = new int[][]{
 * {1, 2},
 * {3, 4}
 * };
 * ```
 * 
 * Rows can have different lengths; this is called a jagged array:
 * 
 * ```java
 * int[][] jagged = new int[3][];
 * jagged[0] = new int[2];
 * jagged[1] = new int[4];
 * jagged[2] = new int[3];
 * ```
 * 
 * ### Three-dimensional and higher-dimensional arrays
 * 
 * Java arrays can have more than three dimensions. Each dimension is another
 * level of nested arrays:
 * 
 * ```java
 * int[][][] threeD = new int[2][3][4];
 * int[][][][] fourD = new int[2][3][4][5];
 * 
 * int[][][] initialized3D = {
 * {
 * {1, 2},
 * {3, 4}
 * },
 * {
 * {5, 6},
 * {7, 8}
 * }
 * };
 * ```
 * 
 * ### Character arrays and strings
 * 
 * ```java
 * char[] letters2 = {'h', 'e', 'l', 'l', 'o'};
 * char[] emptyLetters = new char[5];
 * 
 * String word = "hello";
 * String[] words = {"hello", "world"};
 * char firstCharacter = word.charAt(0);
 * ```
 * 
 * A `String` is an object, not a `char[]`. Use `charAt(index)` to read one of
 * its characters.
 * 
 * ### Arrays sized from input
 * 
 * The size can be determined at runtime. It must be non-negative, and the array
 * must fit within the JVM's implementation limits and available memory.
 * 
 * ```java
 * import java.util.Scanner;
 * 
 * public class Main {
 * public static void main(String[] args) {
 * Scanner sc = new Scanner(System.in);
 * 
 * int n = sc.nextInt();
 * int[] numbers2 = new int[n];
 * 
 * for (int i = 0; i < numbers2.length; i++) {
 * numbers2[i] = sc.nextInt();
 * }
 * 
 * sc.close();
 * }
 * }
 * ```
 * 
 * The same applies to multidimensional arrays:
 * 
 * ```java
 * int rows = 3;
 * int columns = 4;
 * int[][] runtimeMatrix = new int[rows][columns];
 * 
 * int x = 2, y = 3, z = 4;
 * int[][][] runtime3D = new int[x][y][z];
 * ```
 * 
 * ### When the size needs to change: `ArrayList`
 * 
 * An array cannot grow or shrink after creation. Use `ArrayList` when the
 * number of elements changes:
 * 
 * ```java
 * import java.util.ArrayList;
 * 
 * ArrayList<Integer> numbers3 = new ArrayList<>();
 * numbers3.add(10);
 * numbers3.add(20);
 * numbers3.add(30);
 * numbers3.remove(1); // Removes the element at index 1
 * ```
 * 
 * `ArrayList<Integer>` stores `Integer` objects (with automatic
 * boxing/unboxing), not primitive `int` values.
 * 
 * ### Quick revision
 * 
 * | Need | Example |
 * | --- | --- |
 * | Create a fixed-size array | `int[] a = new int[10];` |
 * | Start with known values | `int[] a = {1, 2, 3};` |
 * | Create an array for reassignment or a method argument | `new int[]{1, 2,
 * 3}` |
 * | Store a grid or matrix | `int[][] a = new int[3][4];` |
 * | Give rows different lengths | `int[][] a = new int[3][];` |
 * | Store higher-dimensional data | `int[][][] a = new int[2][3][4];` |
 * | Set the size using input | `int[] a = new int[n];` |
 * | Add and remove elements dynamically | `ArrayList<Integer> a = new
 * ArrayList<>();` |
 * 
 * For DSA practice, get comfortable with `int[]`, `int[][]`, `int[][][]`, and
 * `ArrayList`. Remember: array sizes can be chosen at runtime, but an array's
 * length cannot change after it is created.
 * 
 * ## Type Casting
 * 
 * In Java, there are two main types of casting:
 * 
 * `Widening Casting `(automatic) - converting a smaller type to a larger type
 * size
 * byte -> short -> char -> int -> long -> float -> double
 * 
 * `Narrowing Casting` (manual) - converting a larger type to a smaller type
 * size
 * double -> float -> long -> int -> char -> short -> byte
 * 
 * ## Operators
 * 
 * A String in Java is actually an `object`, which means it contains `methods`
 * that can perform certain operations on strings.
 * 
 * ## String
 * Strings are used for storing texts.
 * use doble quotes for string values. String literals in Java require double
 * quotes. Single quotes are reserved for single character values.
 * String in java is object which have methods that can perform operations on
 * strings.
 * 
 * # Java Mastery Roadmap — Study Tracker
 * 
 * ---
 * 
 * ## Phase 1: Core Fundamentals
 * 
 * - [ ] Variables, data types, operators, type casting
 * - [ ] Control flow (if/else, switch, switch expressions, loops, labeled
 * break/continue)
 * - [ ] Arrays (1D, 2D, jagged)
 * - [ ] Methods (overloading, varargs, pass-by-value semantics)
 * - [ ] Classes, objects, constructors, `this`
 * - [ ] Inheritance & polymorphism (`extends`, `super`, overriding, dynamic
 * dispatch)
 * - [ ] Abstract classes vs interfaces (default/static methods)
 * - [ ] Access modifiers
 * - [ ] `static` vs instance, static blocks, static nested classes
 * - [ ] String pool, immutability, StringBuilder vs StringBuffer
 * 
 * ## Phase 2: Intermediate Concepts
 * 
 * - [ ] Checked vs unchecked exceptions, try-with-resources, custom exceptions
 * - [ ] Generics (bounded types, wildcards, type erasure)
 * - [ ] Enums with fields/methods/constructors
 * - [ ] Inner classes (member, static nested, local, anonymous)
 * - [ ] `equals()`, `hashCode()` contract, `toString()`, `clone()`
 * - [ ] Designing immutable classes
 * - [ ] I/O basics (File, Streams, Reader/Writer, NIO intro)
 * 
 * ## Phase 3: Collections Framework
 * 
 * - [ ] Collection hierarchy overview
 * - [ ] ArrayList vs LinkedList (internals + when to use)
 * - [ ] HashSet, LinkedHashSet, TreeSet
 * - [ ] HashMap internals (hashing, buckets, treeification, load factor)
 * - [ ] LinkedHashMap, TreeMap (NavigableMap methods)
 * - [ ] ConcurrentHashMap internals
 * - [ ] PriorityQueue, ArrayDeque
 * - [ ] Iterator vs ListIterator, fail-fast vs fail-safe
 * - [ ] Comparable vs Comparator, chaining comparators
 * - [ ] Collections utility class methods
 * 
 * ## Phase 4: Data Structures (implement from scratch)
 * 
 * - [ ] Dynamic array (understand ArrayList growth)
 * - [ ] Singly / doubly / circular linked lists
 * - [ ] Stack & Queue (array-based and linked-list-based)
 * - [ ] Binary Tree, BST
 * - [ ] AVL / Red-Black trees (conceptual)
 * - [ ] Trie
 * - [ ] Min-heap (then compare to PriorityQueue)
 * - [ ] Graph (adjacency list/matrix) + BFS, DFS
 * - [ ] Dijkstra's algorithm
 * - [ ] Topological sort
 * - [ ] Hash table from scratch (chaining vs open addressing)
 * 
 * ## Phase 5: Functional Programming & Streams
 * 
 * - [ ] Lambda expressions, functional interfaces
 * - [ ] Function, BiFunction, Predicate, Supplier, Consumer
 * - [ ] Method references
 * - [ ] Stream creation
 * - [ ] Intermediate ops (map, filter, sorted, distinct, flatMap, peek)
 * - [ ] Terminal ops (collect, reduce, forEach, count, anyMatch/allMatch)
 * - [ ] Collectors (groupingBy, partitioningBy, joining, toMap)
 * - [ ] Parallel streams (when to use / avoid)
 * - [ ] Optional best practices
 * 
 * ## Phase 6: Concurrency & Multithreading
 * 
 * - [ ] Thread vs Runnable vs Callable, thread lifecycle
 * - [ ] `synchronized`, intrinsic locks, wait/notify/notifyAll
 * - [ ] Race conditions, deadlock, livelock, starvation
 * - [ ] ExecutorService & thread pools
 * - [ ] Future & CompletableFuture chaining
 * - [ ] ReentrantLock, ReadWriteLock, Condition
 * - [ ] Atomic classes & CAS
 * - [ ] ConcurrentHashMap, CopyOnWriteArrayList, BlockingQueue
 * - [ ] `volatile` & happens-before
 * - [ ] CountDownLatch, CyclicBarrier, Semaphore
 * - [ ] Virtual threads (Java 21+)
 * 
 * ## Phase 7: JVM & Memory Management
 * 
 * - [ ] JVM architecture (class loader, heap, stack, method area)
 * - [ ] GC algorithms overview (Serial, Parallel, G1, ZGC)
 * - [ ] Object lifecycle & garbage collection
 * - [ ] Common memory leak causes in Java
 * 
 * ## Phase 8: Advanced Language Features
 * 
 * - [ ] Records
 * - [ ] Sealed classes
 * - [ ] Pattern matching (instanceof, switch)
 * - [ ] Text blocks
 * - [ ] Reflection API
 * - [ ] Custom annotations
 * - [ ] Java Module System
 * 
 * ## Phase 9: Design Patterns & Best Practices
 * 
 * - [ ] Singleton, Factory, Builder
 * - [ ] Adapter, Decorator, Proxy
 * - [ ] Observer, Strategy, Command
 * - [ ] SOLID principles
 * - [ ] Effective Java practices
 * 
 * ## Phase 10: Ecosystem
 * 
 * - [ ] Maven or Gradle
 * - [ ] JDBC
 * - [ ] Spring Boot basics
 * - [ ] JUnit & Mockito
 * 
 * ---
 */
