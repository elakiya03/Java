# Java Programming Guide: From Basics to Advanced

## Table of Contents

1. [Java Learning Handbook Basics to Advanced](#java-learning-handbook-basics-to-advanced)
2. [Java versions and setup](#java-versions-and-setup)
3. [Compiling and Running a Java Program](#compiling-and-running-a-java-program)
4. [Syntax, identifiers, packages, and imports](#syntax-identifiers-packages-and-imports)
5. [Variables, scope, and types](#variables-scope-and-types)
6. [Operators and expressions](#operators-and-expressions)
7. [Input, output, and formatting](#input-output-and-formatting)
8. [Decision making and loops](#decision-making-and-loops)
9. [Methods and parameter passing](#methods-and-parameter-passing)
10. [Arrays and strings](#arrays-and-strings)
11. [Classes, objects, and constructors](#classes-objects-and-constructors)
12. [Encapsulation and access control](#encapsulation-and-access-control)
13. [Inheritance, overriding, and polymorphism](#inheritance-overriding-and-polymorphism)
14. [Abstract classes, interfaces, and composition](#abstract-classes-interfaces-and-composition)
15. [Enums, records, and sealed types](#enums-records-and-sealed-types)
16. [Object contracts and immutability](#object-contracts-and-immutability)
17. [Generics](#generics)
18. [Collections and data structures](#collections-and-data-structures)
19. [Exceptions and resource management](#exceptions-and-resource-management)
20. [Lambdas and functional interfaces](#lambdas-and-functional-interfaces)
21. [Streams and Optional](#streams-and-optional)
22. [Files, I/O, and serialization](#files-io-and-serialization)
23. [Concurrency and virtual threads](#concurrency-and-virtual-threads)
24. [JVM, memory, and performance](#jvm-memory-and-performance)
25. [Reflection, annotations, and modules](#reflection-annotations-and-modules)
26. [Networking and databases](#networking-and-databases)
27. [Testing, debugging, and build tools](#testing-debugging-and-build-tools)
28. [Design, security, and maintainability](#design-security-and-maintainability)
29. [A practical Java program template](#a-practical-java-program-template)
30. [Practice path and self-check](#practice-path-and-self-check)
31. [Existing beginner notes](#basic-java-concepts)
32. [Existing arrays refresher](#java-arrays-refresher)
33. [Existing study roadmap](#java-mastery-roadmap-study-tracker)
34. [Existing expanded reference notes](#expanded-java-notes-reference-index)
35. [Existing Collections Framework reference](#java-collections-framework)

---

## Introduction to Java

Java is a high-level, `class-based`, `object-oriented` programming language with garbage collection, exception handling, and built-in concurrency support. Java source code is compiled to **bytecode**. Bytecode is not the same thing as native machine code. A Java Virtual Machine (JVM) for a particular platform loads and verifies that bytecode, then interprets it and/or compiles frequently used code to native machine code. This is the basis of Java's portability: the same bytecode can run on compatible JVM implementations for different platform.

First released by Sun Microsystems (led by James Gosling) in 1995, it is now owned and maintained by Oracle Corporation.

Java’s core motto is `"Write Once, Run Anywhere"` (WORA). This means that once you write and compile your Java code, the compiled bytecode can execute flawlessly on any operating system (Windows, Mac, Linux) that supports the Java platform without needing to be recompiled.

### Key Features:

- **Object-Oriented**: Supports classes, inheritance, polymorphism
- **Platform-independence**: compile to Bytecode
- **Robust and Secure**: No direct memory manipulation
- **Automatic memory management**
- **Multithreading**:

---

## Java versions and setup

Java is often called a **compiled and interpreted** language: compilation produces bytecode, and a JVM executes it using interpretation and, commonly, runtime compilation. The phrase _write once, run anywhere_ describes the goal, provided a compatible Java runtime and required platform dependencies are available.

The traditional Java editions include Java SE (the core platform), Java EE (now Jakarta EE, for enterprise application specifications), and Java ME (for constrained devices). JavaFX is a UI framework/platform, not a JDK edition. "Core Java" is an informal term rather than a separate language subset.

Java is used for server-side and enterprise applications, Android development (with Android-specific tooling and runtime), distributed systems, embedded software, games, and data-processing platforms. A common application structure separates responsibilities into controller, service, and data-access (DAO/repository) layers; frameworks and project needs determine the exact architecture.

JDK directory layouts vary by vendor and version. In a typical installation, `bin` contains executable tools and `lib` contains runtime and tool libraries. Do not rely on a fixed list of directories across all JDKs.

Java evolves through language and library releases. A feature being part of Java today does not mean it exists in every older JDK. An **LTS** (Long-Term Support) release receives extended support from vendors; Java 17, 21, and 25 are examples of LTS releases.` Java 21` is the baseline used in this guide, and release-specific features are called out.

Install a JDK, not only a runtime, when developing. Check the installed tools with:

```text
java -version
javac -version
```

### How to Run the Program

1. Make sure you have Java installed on your system.
2. Open a terminal and navigate to the directory containing `Hello.java`.
3. Compile the program: `javac Hello.java`
4. Run the program: `java Hello`

Java also supports source-file launch mode for simple experiments (`java Hello.java` on modern JDKs). For real projects, use a build tool such as Maven or Gradle and configure the language release explicitly so local and CI builds agree.

**Remember when coding**

- Check the project's required JDK before using a recent feature.
- A JDK provides the compiler and developer tools; `java` launches code and `javac` compiles it.
- Keep source files, package names, and build configuration aligned.

---

## Compiling and Running a Java Program

The compiler translates `.java` source into `.class` bytecode. The JVM loads classes, verifies bytecode, and executes it.
The **JIT (Just-In-Time) compiler** is part of many JVM implementations. It can compile frequently executed bytecode to native machine code at runtime to improve performance; it does not normally produce a `.obj` file as a required stage. A JVM may interpret code and JIT-compile frequently used code into native machine code. Bytecode plus compatible platform APIs allow the same program to run on different operating systems; native libraries, file paths, encodings, and external services can still make an application platform-dependent.

```text
source (.java) -> javac -> bytecode (.class) -> JVM -> program execution
```

The JDK includes development tools and runtime components. The JVM is the virtual machine; a JRE is a runtime distribution/concept containing the JVM and supporting libraries. Since Java 9, vendors commonly distribute runtimes differently, so do not assume every installation has a separately named `jre` directory.

| Term      | Meaning                                                                                                                                                                                                                   |
| --------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| JVM       | The virtual machine that loads and executes Java bytecode. The implementation is platform-specific.                                                                                                                       |
| JRE       | The runtime components needed to run Java applications, including a JVM and libraries. Historically distributed separately; modern Java distributions commonly package runtime use through a JDK or custom runtime image. |
| JDK       | Development kit containing tools such as `javac`, `java`, `javadoc`, and `jar`, plus runtime components.                                                                                                                  |
| `javac`   | Compiles Java source files into class files.                                                                                                                                                                              |
| `java`    | Launches a Java application on a JVM.                                                                                                                                                                                     |
| `javadoc` | Generates API documentation from source and documentation comments.                                                                                                                                                       |
| `jar`     | Creates and manages Java archive files.                                                                                                                                                                                   |

**Remember when coding**

- Compilation catches syntax and type errors; runtime behavior can still fail.
- A JVM implementation is platform-specific even though Java bytecode is portable.

---

## Naming Conventions

- The class name should always start with an uppercase first letter. This is a standard Java convention known as PascalCase.
- In our example, the class is named `Hello`, which starts with an uppercase 'H'.
- Note: Java is case-sensitive. `MyClass` and `myclass` would be treated as two completely different names.

### File Naming Requirements

The name of the Java file must match the class name exactly. So if your class is called `Hello`, the file must be saved as `Hello.java`. This is because Java uses the class name to find and run your code. If the names don't match, Java will give a compilation error and the program will not run.

Identifiers name classes, methods, variables, packages, and other declarations. By convention, use `UpperCamelCase` for classes and records, `lowerCamelCase` for methods and variables, and `UPPER_SNAKE_CASE` for constants. Names cannot be Java keywords, cannot contain spaces, and must follow identifier rules.

A **package** is Java's namespace mechanism: it groups types, helps prevent naming collisions, and participates in access control. It is not the same construct as a C++ namespace. The package declaration, when present, is the first non-comment statement in a source file. Conventionally, package names are lowercase and correspond to directory paths:

```java
package com.example.inventory;

import java.util.ArrayList;
import java.util.List;

public class StockService {
    private final List<String> itemCodes = new ArrayList<>();
}
```

---

## Java I/O and formatting

The `java.io` package provides stream-based I/O. A stream is a flow of data between a source and a destination:

Common examples include

- `FileInputStream` / `FileOutputStream` for bytes;
- `FileReader` / `FileWriter` for text; `BufferedInputStream`,
- `BufferedOutputStream`, `BufferedReader`, and `BufferedWriter` for buffering;
- `DataInputStream` / `DataOutputStream` for primitive data formats; and
- `ObjectInputStream` / `ObjectOutputStream` for Java object serialization.
- `InputStreamReader` and `OutputStreamWriter` bridge byte and character streams.
- `PrintStream` and `PrintWriter` provide convenient formatted and line-oriented output.

`File` represents a path and provides operations such as `exists()`, `isFile()`, `isDirectory()`, `getAbsolutePath()`, `list()`, `mkdir()`, and `createNewFile()`. `File` does not itself read or write file contents. Check operation results and handle `IOException` where applicable. For new code, `java.nio.file.Path` and `Files` often provide a more modern API.

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

Path path = Path.of("notes.txt");
try (BufferedReader reader = Files.newBufferedReader(path)) {
    String line;
    while ((line = reader.readLine()) != null) {
        System.out.println(line);
    }
} catch (IOException e) {
    System.err.println("Could not read " + path + ": " + e.getMessage());
}
```

`BufferedReader` wraps a `Reader`; `BufferedWriter` wraps a `Writer`. `PrintWriter` supports methods such as `print`, `println`, `printf`, and `format`. Always close I/O resources, preferably with try-with-resources. `BufferedReader` can read text efficiently, including one line at a time. `Scanner` can tokenize and parse text into primitive values, which is convenient but often slower for large input. Select the API appropriate to the input format and performance needs.

Java I/O commonly has two use cases: **console I/O**, for interacting with a user in a terminal, and **file I/O**, for reading and writing stored data. For files, Java provides byte streams for binary data and character streams for text.

### Console input and output

`System.in` is standard input, `System.out` writes normal output, and `System.err` writes diagnostic output. `print` does not add a line separator, `println` does, and `printf` formats values.

`Scanner` is a convenient choice when reading typed tokens from the console:

```java
import java.util.Scanner;

public class ConsoleExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        System.out.printf("Hello, %s! Next year you will be %d.%n", name, age + 1);
    }
}
```

When mixing `nextInt()` (or another token-reading method) with `nextLine()`, remember that the token method leaves the rest of the line—including its line separator—to be read. Consume the remainder of that line before requesting the next full line. Avoid closing a `Scanner` that wraps `System.in` if the rest of the application still needs standard input.

Use `printf` when output needs formatting. Common conversions include `%s` for strings, `%d` for integers, and `%.2f` for a decimal rounded to two places:

```java
double pi = 3.14159265;
int itemCount = 5;
System.out.printf("Count: %d, Pi: %.2f%n", itemCount, pi);
```

For line-oriented input where token parsing is not needed, `BufferedReader` reads complete lines. Its methods can throw `IOException`:

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class FastConsole {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));
        System.out.print("Enter a line: ");
        String text = reader.readLine();
        System.out.println("Captured: " + text);
    }
}
```

### File I/O: text and binary data

**Character streams** (`Reader` and `Writer`) and their subclasses handle text characters with character encoding. Choose an explicit charset when reading or writing files so the text encoding is predictable. `Files.newBufferedReader` and `Files.newBufferedWriter` are convenient buffered APIs:

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextFileIO {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("output.txt");

        try (BufferedWriter writer =
                     Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            writer.write("Line 1: Writing text.");
            writer.newLine();
            writer.write("Line 2: UTF-8 text.");
        }

        try (BufferedReader reader =
                     Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
```

The try-with-resources statements close the readers and writers automatically, including when an exception occurs. Handle `IOException` at the appropriate application boundary rather than silently ignoring file errors.

**Byte streams** (`InputStream` and `OutputStream`) are for raw bytes, such as images or binary files. `DataInputStream` and `DataOutputStream` add methods for writing and reading Java primitive values in binary form:

```java
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BinaryDataIO {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("data.bin");

        try (DataOutputStream out =
                     new DataOutputStream(Files.newOutputStream(path))) {
            out.writeInt(505);
            out.writeDouble(99.95);
            out.writeBoolean(false);
        }

        try (DataInputStream in =
                     new DataInputStream(Files.newInputStream(path))) {
            int score = in.readInt();
            double price = in.readDouble();
            boolean active = in.readBoolean();
            System.out.printf("Score: %d, price: %.2f, active: %b%n",
                    score, price, active);
        }
    }
}
```

Read values in the same order and with the same types in which they were written. These streams are not a general-purpose format for exchanging data between unrelated systems; document or define the binary format when interoperability matters.

Java also supports **object serialization** through `ObjectOutputStream` and `ObjectInputStream`. A class must implement `Serializable` to be serialized:

```java
import java.io.Serializable;

class GameSave implements Serializable {
    private static final long serialVersionUID = 1L;

    int currentLevel = 4;
    String profileName = "PlayerOne";
}
```

Serialization writes an object graph to a binary stream. Deserialization can fail with `IOException` or `ClassNotFoundException`, and the resulting object requires a type cast. Do not deserialize data from untrusted sources; use a well-defined data format such as JSON for many application interchange and persistence needs.

| Stream type    | Main abstractions                          | Typical use                                                       |
| -------------- | ------------------------------------------ | ----------------------------------------------------------------- |
| Character      | `Reader` / `Writer`                        | Encoded text files, logs, and other human-readable data           |
| Byte           | `InputStream` / `OutputStream`             | Images and other raw binary data                                  |
| Primitive data | `DataInputStream` / `DataOutputStream`     | Binary values such as integers and doubles, in a defined sequence |
| Object data    | `ObjectInputStream` / `ObjectOutputStream` | Java object serialization; avoid untrusted input                  |

**Remember when coding**

- Validate input before using it as an array size, index, or domain value.
- Close file resources with try-with-resources; be careful closing a `Scanner` or reader that wraps `System.in`, because that closes standard input.
- Use `%n` in `printf` for a platform-appropriate line separator.
- Choose character streams for text and byte streams for binary data; specify a charset when working with text files.

---

## Syntax, identifiers, packages, and imports

### Basic syntax

The conventional launch method is `public static void main(String[] args)` (the parameter may also be written as `String... args`). The JVM launcher calls the recognized entry-point form; overloading `main` is allowed, but other overloads are not automatically selected as the entry point. A static method is hidden rather than overridden, so a subclass cannot override `main` in the polymorphic instance-method sense.

**The main Method**

The `main` method is the entry point of any Java application. It is where the program starts executing. The signature `public static void main(String args[])` is standard and required for standalone Java programs. When you run a Java program, the Java Virtual Machine (JVM) looks for the `main` method to begin executing the code. Without a `main` method, the JVM wouldn't know where to start.

**System.out.println() Explanation**

`System.out.println()` is used to print text to the console (screen). While it may look long, you can think of it as a single command that means: "Send this text to the screen."

Here's what each part means (you will learn the details later):

- `System` is a built-in Java class that provides access to system resources.
- `out` is a member of the `System` class, short for "output". It represents the standard output stream.
- `println()` is a method, short for "print line". It prints the specified text followed by a newline character.
- `print()` is a method, short for "print line". It prints the specified text. The only difference is that it does not insert a new line at the end of the output.

```java
public class Hello {
    public static void main(String[] args) {
        System.out.print("Hello ");   // Does not append a newline
        System.out.println("Java");   // Appends a newline
    }
}
```

#### Command-line argument parameter

The conventional declaration uses `String[] args`, but Java permits several equivalent parameter spellings for the launch method. The parameter name is an ordinary identifier, not a keyword, so you can choose a descriptive name:

```java
public static void main(String[] args) { }
public static void main(String args[]) { }
public static void main(String... args) { }
public static void main(String[] myInputs) { }
public static void main(String... parameters) { }
```

The brackets-after-name form is valid Java, though `String[] args` is the usual style. Varargs (`String...`) is treated as a `String[]` parameter, so these spellings describe the same parameter type and cannot be used to overload `main` against one another. Keep the `public static void main` entry-point shape; other `main` overloads are not selected as the application's entry point.

`public` makes the method accessible to the launcher, `static` lets it be called without constructing the class, and `void` means it returns no value. The argument array contains command-line arguments. A static initializer is not a substitute for a valid launch method on modern Java launchers.

For a public top-level class, the source file name must match the class name (for example, `Hello` in `Hello.java`).

Java is `case-sensitive`. Statements commonly end with `;`, and braces `{}` delimit classes, methods, and control-flow blocks. Whitespace and indentation improve readability but do not determine block structure.

`import` lets source code use a type's simple name rather than its fully qualified name. Imports do not copy code, do not import subpackages recursively, and do not make inaccessible types accessible. `java.lang` is implicitly imported.

#### Packages and APIs

A **package** is a namespace that groups related types, helps avoid naming conflicts, and participates in access control. It is not literally a folder, although standard Java project layouts place source files in directories that match their package names. A package declaration must be the first non-comment declaration in a source file.

Common Java platform packages include:

- `java.lang`: fundamental types and utilities such as `String`, `Math`, and `System`; this package is implicitly imported.
- `java.util`: collections and utilities such as `ArrayList`, `HashMap`, and `Scanner`.
- `java.io` and `java.nio`: input/output, files, and paths.
- `java.net`: networking types such as URIs, URLs, and sockets.

An **API** (Application Programming Interface) is the documented set of types and operations that other code is intended to use, including their behavior and constraints. The Java platform API is provided across many packages; a package organizes types, while an API describes how callers use them. Third-party libraries and your own classes can also expose APIs.

For example, `List` and `ArrayList` are in `java.util`, while methods such as `add` and `size` are part of the collection API:

```java
import java.util.ArrayList;
import java.util.List;

List<String> names = new ArrayList<>();
names.add("Ava");
System.out.println(names.size()); // 1
```

**Remember when coding**

- Use one clear public top-level type per file in ordinary projects; its name must match the file name.
- Avoid wildcard imports when explicit imports make dependencies clearer.
- A module (introduced in Java 9) is a higher-level unit that can declare which packages it exports and which modules it requires. Packages and modules are related but not interchangeable.

---

## Variables

A variable is a named storage location with a declared type. Its scope and lifetime depend on where it is declared. The type determines the operations that are valid. Java is statically typed: the compiler checks types before the program runs.

- **Local variable:** declared in a method, constructor, or block. It must be assigned before use and has no automatic default value.
- **Instance field:** belongs to an object. Each object has its own instance fields; fields receive default values when the object is created.
- **Static field (class variable):** belongs to the class and is shared by its instances; it is initialized as part of class initialization.
- **Parameters** receive values when a method is called.
- **Array elements** receive default values when the array is created.

---

## Data types

The main differences between `primitive` and `non-primitive` data types are:

- Primitive types in Java are `predefined` and built into the language, while non-primitive types are created by the programmer (except for String).
- Non-primitive types can be used to call methods to perform certain operations, whereas primitive types cannot.
- Primitive types start with a lowercase letter (like int), while non-primitive types typically starts with an uppercase letter (like String).
- Primitive types always hold a value, whereas non-primitive types can be null.

### Primitive Data types

Java has eight primitive types: `byte`, `short`, `int`, `long`, `float`, `double`, `char`, and `boolean`.

Default field and array values include `0` for integer types, `0.0` for `double`, `0.0f` for `float`, `false` for `boolean`, `'\u0000'` for `char` , and `null` for `references`. Local variables do not receive these defaults.

| Primitive | Typical width                                                                                                  |
| --------- | -------------------------------------------------------------------------------------------------------------- |
| `byte`    | 8-bit signed integer                                                                                           |
| `short`   | 16-bit signed integer                                                                                          |
| `int`     | 32-bit signed integer                                                                                          |
| `long`    | 64-bit signed integer                                                                                          |
| `float`   | 32-bit IEEE 754 floating-point                                                                                 |
| `double`  | 64-bit IEEE 754 floating-point                                                                                 |
| `char`    | 16-bit UTF-16 code unit; not necessarily a whole Unicode code point                                            |
| `boolean` | Represents `true` or `false`; its storage size is not specified as a fixed number of bits by the Java language |

| Type family    | Types                          |                                                                                                                            |
| -------------- | ------------------------------ | -------------------------------------------------------------------------------------------------------------------------- |
| Integral       | `byte`, `short`, `int`, `long` | `int` is the usual whole-number type; use `long` for a wider range, with `L` on large literals if needed.                  |
| Floating point | `float`, `double`              | `double` is the usual choice; decimal floating-point is approximate. Use `BigDecimal` for many decimal money calculations. |
| Character      | `char`                         | A 16-bit UTF-16 code unit; a visible Unicode character may require more than one `char`.                                   |
| Boolean        | `boolean`                      | Only `true` or `false`; Java does not treat numbers as booleans.                                                           |

`final` means a variable can be assigned only once. For a reference, `final` prevents assigning a different reference; it does not make the referenced object immutable.

```java
final int maxAttempts = 5;      // cannot be reassigned.
```

### Non-Primitive Data types

**Non-primitive** data types - such as `String`, `Arrays` , `Enum`, `Record` and `Classes`. Non-primitive data types are called reference types because they refer to objects.

### The var Keyword

The `var` (Java 10+) asks the compiler automatically infer a local variable's static type from its initializer. it is not dynamic typing and cannot be used for fields, method parameters, or uninitialized locals.

```java
String userName = "Elakiya";    // reference to a String object
var message = "Ready";          // inferred local type: String
```

---

## Type Casting

In Java, there are two main types of casting:

1. **Widening Casting**(automatic and implicit) - converting a smaller type to a larger type size

- **Numeric Widening Path**: `byte -> short -> int -> long -> float -> double`
- **Character Widening Path**: `char -> int -> long -> float -> double`

- `char` can widen to `int`, but `short` does not widen to `char` (because a char cannot store negative values)

2. **Narrowing Casting**(manual and explicit) - converting a larger type to a smaller type size and may lose information
   `double -> float -> long -> int -> char/short -> byte`

- **Floating-Point Truncation**: Narrowing a double or float to an integer type does not round the number; it completely truncates all decimal places toward zero.

```java
int count = 12;
long largerCount = count;       // Widening

double price = 9.99;
int wholePrice = (int) price;   // Narrowing: fractional part is discarded
```

---

## Operators and expressions

### Arithmetic Operators

**Operators:** `+` `-` `*` `/` `%`

- Integer division truncates toward zero: `5 / 2` is `2`, while `5.0 / 2` is `2.5`.
- `%` gives the remainder and works with both integral and floating-point numeric types.
- Integer arithmetic can overflow without throwing an exception.

```java
int a = 10;
int b = 3;
System.out.println(a + b); // 13
System.out.println(a - b); // 7
System.out.println(a * b); // 30
System.out.println(a / b); // 3: integer division
System.out.println(a % b); // 1: remainder
```

### Increment/Decrement

`++` adds one and `--` subtracts one. Prefix form changes the value before the expression is evaluated; postfix form evaluates to the old value before changing it.

```java
int x = 5;
int oldValue = x++; // oldValue is 5; x is now 6
int newValue = ++x; // x is now 7; newValue is 7
x--;                // x is now 6
--x;                // x is now 5
```

### Assignment Operators

**Operators:** `=` `+=` `-=` `*=` `/=` `%=` `&=` `|=` `^=` `<<=` `>>=` `>>>=`

- Compound assignments combine an operation with assignment, such as `x += 3`.
- Assignment operators associate right to left: `a = b = c` assigns `c` to `b`, then to `a`.
- Use `==` to compare values; `=` assigns a value.

```java
int x = 5;
x += 3; // x is now 8
x *= 2; // x is now 16
```

### Relational Operators

**Operators:** `==` `!=` `<` `>` `<=` `>=`

- These comparisons produce a `boolean`.
- `==` compares primitive values, but for object references it checks whether both refer to the same object.
- Floating-point calculations can have rounding error; use a suitable tolerance when approximate numeric comparison is intended.

```java
System.out.println(5 == 5); // true
System.out.println(5 != 3); // true
System.out.println(5 < 3);  // false
System.out.println(5 > 3);  // true
System.out.println(5 <= 5); // true
System.out.println(5 >= 6); // false
```

### Logical Operators

**Operators:** `&&` `||` `!`

- `&&` (AND) and `||` (OR) short-circuit: the right operand is evaluated only when needed.
- `!` (NOT) negates a boolean expression.

```java
boolean a = true;
boolean b = false;
System.out.println(a && b); // false
System.out.println(a || b); // true
System.out.println(!a);     // false
```

### Bitwise operators

**Bitwise:** `&`, `|`, `^`, `~`

### Shift operators

**Shift:** `<<`, `>>` (sign-extending right shift), `>>>` (zero-filling right shift)

### Unaray operators

**Unary:** `+`, `-`, `++`, `--`, `!`, `~`

### Operator Precedence (High to Low)

1. Postfix: `expression++` `expression--` `()` `[]` `.`
2. Unary: `++` `--` `+` `-` `!` `~` and casts
3. Multiplicative: `*` `/` `%`
4. Additive: `+` `-`
5. Shift: `<<` `>>` `>>>`
6. Relational: `<` `>` `<=` `>=` `instanceof`
7. Equality: `==` `!=`
8. Bitwise AND: `&`
9. Bitwise XOR: `^`
10. Bitwise OR: `|`
11. Conditional AND: `&&`
12. Conditional OR: `||`
13. Ternary conditional: `?:`
14. Assignment: `=` and compound assignment operators

```java
int total = 17;
int groupSize = 5;
int fullGroups = total / groupSize;  // 3: integer division truncates
int remainder = total % groupSize;   // 2

boolean eligible = total >= 18 && remainder == 0;
String label = eligible ? "eligible" : "not eligible";
```

Integer arithmetic can overflow. Integer division by zero throws `ArithmeticException`; floating-point division by zero follows IEEE 754 rules. `&&` and `||` short-circuit: the right side is evaluated only if needed. Parentheses make precedence explicit when an expression is not obvious.

For objects, `==` checks whether two references identify the same object; use `equals` to check logical equality when the type implements it. For primitives, `==` compares values.

**Remember when coding**

- Check integer overflow and division behavior in boundary-sensitive code.
- Do not use `==` to compare string contents.
- Prefer readable expressions over clever operator-heavy statements.

---

## Control flow

- **Branching:** `if` / `else`, `switch` (including newer switch expressions in supported Java versions)
- **Loops:** `for`, enhanced `for` (for-each), `while`, `do` / `while`
- **Loop control:** `break`, `continue`, and `return`

### Conditional Statements

#### if else

Use `if` / `else` for conditional branches.

#### Switch

`switch` selects among multiple alternatives and can make that logic clearer than a long `if` / `else if` chain. Switch selectors may be `byte`, `short`, `char`, `int`, their wrapper types, `String`, or an enum. They cannot be `long`, `float`, `double`, or `boolean`.

A traditional switch **statement** uses `case` labels followed by colons. Execution continues into later cases unless it exits with `break`, `return`, or another control transfer. This is called fall-through, and it can be intentional, but forgetting a `break` often causes bugs:

```java
String role = "ADMIN";

switch (role) {
    case "USER":
        System.out.println("Standard access granted.");
        break;
    case "ADMIN":
        System.out.println("Full administrative access granted.");
        break;
    case "GUEST":
        System.out.println("Limited access granted.");
        break;
    default:
        System.out.println("Access denied: unknown role.");
        break;
}
```

Switch expressions, finalized in Java 14, produce a value. Arrow-style cases do not fall through, and multiple labels can share one result:

```java
String day = "SATURDAY";
String typeOfDay = switch (day) {
    case "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY" -> "Weekday";
    case "SATURDAY", "SUNDAY" -> "Weekend";
    default -> "Unknown day";
};
System.out.println(day + " is a " + typeOfDay);
```

For a multi-statement arm in a switch expression, use a block and `yield` to provide its value:

```java
int input = 2;
int result = switch (input) {
    case 1 -> 10;
    case 2 -> {
        int calculation = input * 5;
        yield calculation;
    }
    default -> 0;
};
```

Switch expressions must produce a value for every possible case. A `default` arm is commonly used; when switching over an enum, the compiler can also verify that all enum constants are covered. Pattern matching for switch is available in Java 21 and later.

**Remember when coding**

- Use `break` in colon-style switch statements when you do not intend fall-through.
- Prefer arrow-style cases when fall-through is not needed.
- Include a suitable `default` or cover all enum constants in a switch expression.

### Loops

#### For loop

Java provides a traditional counter-based `for` loop, an enhanced `for` loop for arrays and `Iterable` values, and the `forEach` method for collections.

The traditional `for` loop runs its initializer once, checks its condition before each iteration, and runs its update expression after each iteration:

```java
for (int i = 1; i <= 3; i++) {
    System.out.print(i + " ");
}

for (int i = 5; i > 0; i -= 2) {
    System.out.print(i + " ");
}
```

The counter does not have to be an `int`; for example, a `long` or `char` can be used when appropriate. `int` is the usual choice for counting iterations and indexing arrays: Java array indexes and array lengths use `int`, so a `long` index must be converted before it can index an array. Prefer an integer counter over `float` or `double` for a fixed number of iterations, because many decimal fractions cannot be represented exactly in binary:

```java
for (double value = 0.0; value < 1.0; value += 0.1) {
    System.out.println(value); // Rounding can make the iteration count surprising.
}
```

For a fixed number of steps, count with integers instead. If a loop represents a range of decimal values, use a bounded comparison and account for floating-point rounding.

You can declare multiple variables of the same type in the initializer and update them in the same loop:

```java
for (int i = 0, j = 10; i < j; i++, j--) {
    System.out.println("i: " + i + ", j: " + j);
}
```

An enhanced `for` loop can iterate over **any array** or any object that implements `Iterable`. The loop variable's type must be compatible with each element's type. Arrays can contain primitive values or object references; collections such as `ArrayList` and `HashSet` contain objects (primitive values are represented by wrapper classes such as `Double`):

```java
String[] fruits = {"Apple", "Banana", "Cherry"};
for (String fruit : fruits) {
    System.out.println(fruit);
}

double[] prices = {19.99, 5.50, 45.00};
for (double price : prices) {
    System.out.println("Price: " + price);
}
```

The loop variable receives the current element's value. Assigning a different value to that variable does not replace the element in its array or collection. To replace array elements by index, use a traditional loop; for collections, use an appropriate collection operation or iterator. A `Map` is not `Iterable`; iterate over its `entrySet()`, `keySet()`, or `values()` instead.

| Loop style        | What it iterates over                                                                                       | Common use                                            |
| ----------------- | ----------------------------------------------------------------------------------------------------------- | ----------------------------------------------------- |
| Traditional `for` | Repeats while its boolean condition is true; initializer and update are regular Java expressions/statements | Indexes, counters, and custom step sizes              |
| Enhanced `for`    | Arrays and objects implementing `Iterable`                                                                  | Visiting each element without managing an index       |
| `forEach`         | A collection or other type that provides a `forEach` method                                                 | Applying a lambda or method reference to each element |

Collections provide `forEach` for lambda-based iteration (Java 8 and later). A method reference is a concise alternative when the action is a direct method call:

```java
import java.util.List;

List<String> fruits = List.of("Apple", "Banana", "Cherry");
fruits.forEach(fruit -> System.out.println("Fruit: " + fruit));
fruits.forEach(System.out::println);
```

`forEach` is a method on collections; it does not require streams. Stream pipelines also have a `forEach` terminal operation, but avoid relying on side effects in streams, especially parallel streams.

An infinite `for` loop omits all three sections. Use one only when there is a clear exit path, such as a `break` or `return`:

```java
for (;;) {
    System.out.println("Running once, then exiting.");
    break;
}
```

Use `for` when an index, iteration count, or custom step matters; enhanced `for` for straightforward traversal; and `while` or `do-while` when repetition is primarily condition-based.

**Remember when coding**

- Make loop progress explicit; a condition that never changes can create an infinite loop.
- For array indexes, use `i < array.length`, not `i <= array.length`.
- Prefer enhanced `for` when you do not need an index.
- Avoid changing a collection's structure while iterating unless using an iteration-safe approach.

### Jump statements

`break` and `continue` alter the normal flow of loops. In Java, labels can target enclosing statements, which is especially useful with nested loops.

An **unlabeled `break`** exits the innermost enclosing loop or `switch`. Execution resumes after that loop or switch:

```java
for (int i = 1; i <= 10; i++) {
    if (i == 5) {
        break;
    }
    System.out.print(i + " ");
}
// Prints: 1 2 3 4
```

An **unlabeled `continue`** skips the rest of the current loop iteration. In a traditional `for` loop, the update expression runs before the condition is checked again. In a `while` loop, control returns directly to the condition, so ensure that any counter update is not skipped:

```java
for (int i = 1; i <= 5; i++) {
    if (i == 3) {
        continue;
    }
    System.out.print(i + " ");
}
// Prints: 1 2 4 5
```

A **labeled statement** is written with an identifier followed by a colon before a statement. A labeled `break` exits the labeled statement, allowing it to leave multiple nested loops:

```java
search:
for (int row = 0; row < 3; row++) {
    for (int column = 0; column < 3; column++) {
        if (row == 1 && column == 1) {
            break search;
        }
        System.out.println(row + ", " + column);
    }
}
// The labeled break exits both loops.
```

A **labeled `continue`** skips to the next iteration of the labeled loop. In a nested loop, it can continue the outer loop rather than just advancing the inner loop:

```java
rows:
for (int row = 0; row < 3; row++) {
    for (int column = 0; column < 3; column++) {
        if (column == 1) {
            continue rows;
        }
        System.out.println(row + ", " + column);
    }
}
// For each row, prints column 0, then continues with the next row.
```

An unlabeled `continue` applies to the innermost loop and cannot target a `switch`. A labeled `continue` must target a labeled loop. A labeled `break` may target a labeled loop, `switch`, or block. Use labels sparingly and give them clear names.

**Remember when coding**

- Use `break` when the current loop or switch should end early.
- Use `continue` when only the current loop iteration should be skipped.
- Prefer unlabeled statements for simple cases; use labels when they make nested-loop behavior clearer.

---

## Methods

### Method basics

A method is a named block of behavior. A declaration can include access modifiers, other modifiers such as `static`, a return type, a name, parameters, and a body. In this example, `a` and `b` are parameters; the values supplied when calling the method are arguments:

```java
public static int addNumbers(int a, int b) {
    return a + b;
}

int total = addNumbers(3, 4); // 3 and 4 are arguments; total is 7
```

When calling a method with multiple parameters, provide the same number of arguments in the same order as the parameters. Each argument must be assignment-compatible with the corresponding parameter type (unless the method uses varargs):

```java
static void describe(String name, int age) {
    System.out.println(name + " is " + age);
}

describe("Mina", 20); // name receives "Mina"; age receives 20
```

The return type specifies the kind of value returned. A method that returns no value uses `void`. A non-`void` method must return a compatible value on every path that completes normally. The method signature consists of its name and parameter types; the return type alone cannot distinguish overloads.

### Types: Instance, static, and library methods

An **instance method** is called on an object and can use that object's instance fields. A **static method** belongs to the class and can be called with the class name; it has no `this` reference and cannot directly access instance members. Java library methods, such as `Math.max` and `List.of`, are predefined APIs; methods written as part of an application are user-defined.

```java
class Counter {
    private int value;

    void increment() {             // Instance method
        value++;
    }

    static int larger(int a, int b) { // Static method
        return Math.max(a, b);
    }
}
```

### Method overloading and overriding

**Overloading** defines multiple methods with the same name but different parameter lists. The compiler selects an overload using the argument types at the call site. Changing only the return type is not enough to overload a method.

```java
static int formatValue(int value) {
    return value;
}

static String formatValue(String value) {
    return value.trim();
}
```

**Overriding** is different: a subclass provides a compatible implementation of an `inherited instance method`. The runtime object determines which overridden implementation runs. Static methods are hidden, not overridden.

### Passing parameters

Java is always **pass-by-value**: each parameter receives a copy of the argument's value. For a primitive, that value is the primitive itself. For an object, array, or collection, the copied value is a reference to the same object. A method can mutate that object through the reference, but reassigning its parameter does not reassign the caller's variable. `String` is immutable, so its contents cannot be changed through a method.

```java
import java.util.List;

static void demonstratePassing(int score, int[] numbers, List<String> names) {
    score = 0;                    // Does not change the caller's primitive
    if (numbers.length > 0) {
        numbers[0] = 99;          // Mutates the caller's array
    }
    names.add("New name");        // Mutates the caller's collection
    numbers = new int[]{1, 2};    // Reassigns only this local parameter
}
```

Custom objects follow the same reference rule: changing the object's mutable state is visible through other references to that object. Passing an object does not give the method a special ability to change the caller's variable to refer to another object.

### Returning values

Use `return expression;` to provide a result whose type is compatible with the method's declared return type. Methods can return primitives, strings, arrays, collections, or custom objects. The returned reference identifies the same object; returning an array or collection does not make a copy automatically.

```java
import java.util.ArrayList;
import java.util.List;

static int[] createNumbers() {
    return new int[]{1, 2, 3};
}

static List<String> createNames() {
    List<String> names = new ArrayList<>();
    names.add("Ari");
    return names;
}

static String greeting(String name) {
    return "Hello, " + name;
}
```

A `void` method may use `return;` to exit early, but does not return a value. If a method returns a mutable object, consider whether callers should be allowed to modify that object; use an immutable result or defensive copy when that better protects the API.

### Varargs and recursion

Varargs (`Type... name`) let a method accept zero or more arguments of one type. They are treated as an array inside the method and must be the final parameter:

```java
static int sum(int... values) { // Treated as an array
    int total = 0;
    for (int value : values) {
        total += value;
    }
    return total;
}
```

Recursion is a method calling itself. It needs a base case and progress toward that base case; deep recursion can exhaust the thread stack. For large input, an iterative solution may be safer.

**Remember when coding**

- Keep methods focused and give them meaningful names.
- Validate arguments and document important preconditions.
- Use `static` for behavior that does not depend on an instance; use instance methods for object behavior.
- Do not confuse overloading with overriding, or assume Java passes objects by reference.
- Avoid hidden mutation when callers expect a method to return a result.
- Avoid overloads that make calls ambiguous or surprising.

---

## Arrays

Arrays store a fixed number of values of the same type. In Java, an array is an object: its length is fixed when it is created, its elements receive default values, and its indexes start at `0`.

Declaring an array variable does not by itself create an array. Create one with an initializer or `new` before accessing its elements; otherwise, the reference may be `null` (or an uninitialized local variable may fail to compile). Accessing an element through `null` or using an index outside the array's bounds throws an exception.

### One-dimensional arrays

```java
int[] arr = new int[5];              // Five ints, each initially 0
int[] a = {1, 2, 3, 4, 5};           // Declare and initialize
int[] b = new int[]{1, 2, 3};        // Explicit array creation
int arr2[] = new int[5];             // Valid, but int[] arr2 is preferred
```

The array length is available through the `length` field:

```java
System.out.println(a.length);        // 5
System.out.println(a[0]);            // 1 (first element)
```

### Array indexing and traversal

Java arrays use **zero-based indexing**: the first element is at index `0`, and the last element is at index `length - 1`. For an array of length `5`, valid indexes are `0` through `4`. An index outside that range throws `ArrayIndexOutOfBoundsException`.

```java
int[] scores = {84, 91, 76};

System.out.println(scores[0]);       // 84: first element
System.out.println(scores[2]);       // 76: last element
System.out.println(scores[scores.length - 1]); // Last element without hard-coding its index

for (int i = 0; i < scores.length; i++) {
    System.out.println("index " + i + " contains " + scores[i]);
}

for (int score : scores) {
    System.out.println(score);       // Use when the index itself is not needed
}
```

Use `i < array.length`, not `i <= array.length`, in an index-based loop: `array[array.length]` is already one position past the end. An empty array has length `0` and has no valid indexes.

For a two-dimensional array, each index selects an array (row) first, then an element within that row. Both indexes are zero-based, and each row has its own length:

```java
int[][] grid = {
    {10, 20, 30},
    {40, 50, 60}
};

System.out.println(grid[0][0]);      // 10: first row, first column
System.out.println(grid[1][2]);      // 60: second row, third column

for (int row = 0; row < grid.length; row++) {
    for (int column = 0; column < grid[row].length; column++) {
        System.out.println(grid[row][column]);
    }
}
```

In a jagged array, use `array[row].length` for the selected row; rows do not necessarily have the same number of columns.

### Arrays of different types and default values

```java
int[] numbers = new int[5];
float[] prices = new float[5];
double[] values = new double[5];
char[] letters = new char[5];
boolean[] flags = new boolean[5];
String[] names = new String[5];
```

Each array holds elements of one type. These examples show common ways to declare and initialize arrays of integers, characters, and strings:

```java
int[] scores = {84, 91, 76};                  // Declare and initialize
int[] moreScores = new int[3];                // Allocate with default values
char[] letters = {'J', 'a', 'v', 'a'};
String[] words = {"learn", "Java"};
String[] moreWords = new String[2];           // Initially contains nulls
```

Use the array's `length` field (not a `length()` method) to get its number of elements. When an array is passed to `System.out.println`, the matching overload prints its object representation; arrays do not override `Object.toString()` to format their elements. The default representation resembles `className@hexHashCode` (for example, `[I@...` for an `int[]`). The hash code is not a memory address, and its exact value is not predictable.

Use `Arrays.toString` for a readable one-dimensional representation, or loop through the elements. `println` has a special overload for `char[]` that prints its characters as text; `Arrays.toString(charArray)` instead prints the characters separated and enclosed in brackets:

```java
import java.util.Arrays;

int[] values = {10, 20, 30};
char[] letters = {'J', 'a', 'v', 'a'};

System.out.println(values);                  // Object representation, not the elements
System.out.println(Arrays.toString(values));  // [10, 20, 30]
System.out.println(letters);                 // Java
System.out.println(Arrays.toString(letters));// [J, a, v, a]

System.out.println(scores.length);             // 3
System.out.println(Arrays.toString(scores));   // [84, 91, 76]
System.out.println(Arrays.toString(words));    // [learn, Java]

for (int score : scores) {
    System.out.println(score);
}
for (char letter : letters) {
    System.out.println(letter);
}
for (String word : words) {
    System.out.println(word);
}
```

| Element type                      | Default value                   |
| --------------------------------- | ------------------------------- |
| `byte`, `short`, `int`, `long`    | `0`                             |
| `float`                           | `0.0f`                          |
| `double`                          | `0.0`                           |
| `char`                            | `'\u0000'` (the null character) |
| `boolean`                         | `false`                         |
| Reference types, such as `String` | `null`                          |

### Initializing and updating arrays

```java
int[] initialized = {10, 20, 30};
int[] explicit = new int[]{10, 20, 30};

int[] values2 = new int[5];
values2[0] = 10;
values2[1] = 20;
```

An array initializer in braces can be used directly in a declaration, but not by itself in a later assignment:

```java
int[] values3 = {1, 2, 3};
// values3 = {4, 5, 6};              // Does not compile
values3 = new int[]{4, 5, 6};        // Correct reassignment

printArray(new int[]{7, 8, 9});      // Anonymous array passed to a method
```

### Two-dimensional and jagged arrays

A two-dimensional array is an array of arrays. It is often used for tables and grids:

```java
int[][] matrix = new int[3][4];      // 3 rows, 4 columns
matrix[1][2] = 7;                    // Row 1, column 2

int[][] initializedMatrix = {
    {1, 2, 3},
    {4, 5, 6}
};

int[][] explicitMatrix = new int[][]{
    {1, 2},
    {3, 4}
};
```

Rows can have different lengths; this is called a jagged array:

```java
int[][] jagged = new int[3][];
jagged[0] = new int[2];
jagged[1] = new int[4];
jagged[2] = new int[3];
```

### Character arrays and strings

```java
char[] letters2 = {'h', 'e', 'l', 'l', 'o'};
char[] emptyLetters = new char[5];

String word = "hello";
String[] words = {"hello", "world"};
char firstCharacter = word.charAt(0);
```

A `String` is an object, not a `char[]`. Use `charAt(index)` to read one of its characters.

### Arrays sized from input

The size can be determined at runtime. It must be non-negative, and the array must fit within the JVM's implementation limits and available memory.

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] numbers2 = new int[n];

        for (int i = 0; i < numbers2.length; i++) {
            numbers2[i] = sc.nextInt();
        }

        sc.close();
    }
}
```

The same applies to multidimensional arrays:

```java
int rows = 3;
int columns = 4;
int[][] runtimeMatrix = new int[rows][columns];

int x = 2, y = 3, z = 4;
int[][][] runtime3D = new int[x][y][z];
```

### When the size needs to change: `ArrayList`

An array cannot grow or shrink after creation. Use `ArrayList` when the number of elements changes:

```java
import java.util.ArrayList;

ArrayList<Integer> numbers3 = new ArrayList<>();
numbers3.add(10);
numbers3.add(20);
numbers3.add(30);
numbers3.remove(1);                   // Removes the element at index 1
```

`ArrayList<Integer>` stores `Integer` objects (with automatic boxing/unboxing), not primitive `int` values.

### Quick revision

| Need                                                  | Example                                     |
| ----------------------------------------------------- | ------------------------------------------- |
| Create a fixed-size array                             | `int[] a = new int[10];`                    |
| Start with known values                               | `int[] a = {1, 2, 3};`                      |
| Create an array for reassignment or a method argument | `new int[]{1, 2, 3}`                        |
| Store a grid or matrix                                | `int[][] a = new int[3][4];`                |
| Give rows different lengths                           | `int[][] a = new int[3][];`                 |
| Store higher-dimensional data                         | `int[][][] a = new int[2][3][4];`           |
| Set the size using input                              | `int[] a = new int[n];`                     |
| Add and remove elements dynamically                   | `ArrayList<Integer> a = new ArrayList<>();` |

For DSA practice, get comfortable with `int[]`, `int[][]`, `int[][][]`, and `ArrayList`. Remember: array sizes can be chosen at runtime, but an array's length cannot change after it is created.

---

## Strings

`String` is an immutable reference type. Operations that appear to modify a string return a new string. Use `equals` for content equality and `charAt(index)` for a UTF-16 code unit; Unicode code points may span more than one `char`. Use `StringBuilder` when assembling many pieces in a loop.

A String in Java is actually an `object`, which means it contains `methods` that can perform certain operations on strings.

- Strings are used for storing texts.
- String literals in Java require double quotes.
- Single quotes are reserved for single character values.
- String literals are interned in the string pool
- `String` provides methods such as `charAt`, `equals`, and `compareTo`.
- `==` compares primitive values, or reference identity when used with references.
- `equals()` compares logical equality when a class implements it appropriately.
- If `equals()` is overridden, `hashCode()` must be implemented consistently.
- `compareTo()` (from `Comparable`) orders values and conventionally returns a negative number, zero, or a positive number.

```java
String first = "Java";
String second = first + " SE";        // first remains "Java"

StringBuilder builder = new StringBuilder();
builder.append("Java").append(" SE");
String result = builder.toString();
```

- Check empty arrays and collections before accessing the first or last element.
- Prefer `array.length` and `list.size()` over hard-coded bounds.
- Use `equals`, not `==`, for string content.
- For user-visible text, consider Unicode and locale requirements rather than assuming one character equals one `char`.

### String Builder and String Buffer

Unlike Strings class, both String builder and String Buffer class content can be changed without creating a new object.

- StringBuffer is `thread-safe` and `synchronized`, whereas StringBuilder is not synchronized and not thread-safe.
- StringBuffer is slower in performance, whereas StringBuilder is `faster and more efficien`t for single-threaded applications.

#### StringBuffer Class

StringBuffer is a mutable sequence of characters that is thread-safe. It is designed for multi-threaded environments where multiple threads may modify the same string object.

- StringBuffer is thread-safe because its methods are synchronized.
- Used when multiple threads access the same object.
- Safer for concurrent operations.

#### StringBuilder Class

StringBuilder is a mutable sequence of characters similar to StringBuffer , but it is not thread-safe. It is optimized for single-threaded environments where performance is critical.

- Suitable for single-threaded applications.
- Does not use synchronized methods.
- append() updates the existing StringBuilder instance
- No new object is created after modification
- Faster execution due to lack of synchronization

---

## Oops

Java supports classes, objects, encapsulation, inheritance, and polymorphism, but it is not considered a _pure_ object-oriented language because it has primitive types and operations that are not performed through objects. Java does not support multiple inheritance of classes; a class can implement multiple interfaces.

### Classes and Objects

A `class` define sits fields represent state, constructors establish valid initial state, and methods represent behavior; an `object` is a runtime instance of a class, with identity, state (fields), and behavior (methods). A reference variable refers to an object; it is not the object itself.

Common class descriptions include concrete, abstract, final, nested, POJO, and singleton. These are not six mutually exclusive language-level class types: for example, a class can be both final and a POJO.

All ordinary classes ultimately inherit from `Object` unless they extend another class. Common `Object` methods include `toString()`, `equals(Object)`, `hashCode()`, `getClass()`, `clone()`, `wait()`, `notify()`, and `notifyAll()`. `compareTo()` is not an `Object` method; it is commonly supplied by `Comparable`. `finalize()` is deprecated for removal and should not be used for resource cleanup.

#### Class

`Every line of code that runs in Java must be inside a class.` A class is a blueprint for creating objects and contains the code that defines the behavior of the program.

```java
public class Hello {
    public static void main(String args[]){
        System.out.println("Elakiya you can be a coder one day");
    }
}
```

##### Class Initialization

Class Initialization (Runs ONCE per Class)

Before you can create an object, Java needs to load the class itself into memory. This happens generally once when the class loader first reads the class.
• What runs: Static variables (static fields) and Static Initializer Blocks (static { ... }).
• The Order: They run in the exact source order (top to bottom) they are written in the file.
• Rule: This happens before any object is created and before the main method or constructor runs.

##### Types of Classes

A **concrete class** is a class that can be instantiated. It must provide implementations for inherited abstract methods. A **non-abstract class** may still declare ordinary methods that subclasses can override.

An **abstract class** is declared with `abstract` and cannot be instantiated directly. It can contain both implemented and abstract methods; a concrete subclass must implement its inherited abstract methods. Abstract classes are useful when related subclasses share state or implementation.

```java
abstract class Vehicle {
    abstract void startEngine();

    void stop() {
        System.out.println("Stopped");
    }
}

class Car extends Vehicle {
    @Override
    void startEngine() {
        System.out.println("Engine started");
    }
}
```

A **final class** cannot be extended. For example, `String` is final. `final` prevents subclassing; it does not by itself make every object immutable.

```java
final class SecureLock {}
// class ChildLock extends SecureLock {} // Does not compile
```

```java
class BankAccount {
    private final String owner;
    private long balanceInCents;

    BankAccount(String owner, long openingBalanceInCents) {
        this.owner = java.util.Objects.requireNonNull(owner);
        if (openingBalanceInCents < 0) {
            throw new IllegalArgumentException("Opening balance cannot be negative");
        }
        this.balanceInCents = openingBalanceInCents;
    }

    long balanceInCents() {
        return balanceInCents;
    }
}
```

**POJO** (Plain Old Java Object) is an informal term, not a special Java language construct. It generally describes an ordinary Java object that is not required to extend a framework-specific base class or implement a framework-specific interface.

Class descriptions can overlap: a class may be concrete, final, and a POJO at the same time; a nested class may also be abstract or final. Records are a distinct Java class form for data carriers and are covered under [enums, records, and sealed types](#enums-records-and-sealed-types).

##### Java supports nested Class types:

- A **static nested class** is declared inside another class with `static`. It has no implicit enclosing-instance reference and cannot directly access the outer class's instance members.

- A non-static **inner class** is a member class associated with an enclosing instance. It can access that instance's members, including private members.

- A **local class** is declared within a block, such as a method, and is in scope only within that block.

- An **anonymous class** is an unnamed class expression that declares and creates an instance, commonly to implement an interface or extend a class for one-off behavior. A lambda is often simpler for a functional interface.

```java
class Outer {
    private int value = 10;

    static class Nested {
        void show() {
            System.out.println("No enclosing Outer instance required");
        }
    }

    class Inner {
        void show() {
            System.out.println(value); // Uses the enclosing Outer instance
        }
    }

    void createLocalClass() {
        class LocalHelper {
            void show() {
                System.out.println(value);
            }
        }
        new LocalHelper().show();
    }
}

Outer.Nested nested = new Outer.Nested();
Outer outer = new Outer();
Outer.Inner inner = outer.new Inner();
```

`static` members belong to the class rather than an individual instance. A static method can be called using the class name and can directly access static members, but it has no `this` or `super` reference and cannot directly access instance members without an object. Static fields are shared class state, not a mechanism that guarantees one copy across all class loaders.

Only a **nested** class can be declared `static`; a top-level class cannot. A static nested class has no implicit reference to an enclosing instance, but it can access enclosing class members subject to access rules.

A **class loader** loads class definitions into the JVM when needed. The built-in loader hierarchy commonly includes the bootstrap, platform, and application class loaders; exact implementation details vary. Classes are not all loaded into memory at program start.

Static methods are not overridden. If a subclass declares a compatible static method with the same signature, it hides the superclass method; method selection is based on the compile-time type. Static methods can still be overloaded with different parameter lists.

#### Object

Common ways to obtain or create an object include:

1. The `new` operator and a constructor.
2. Reflection, such as `Constructor.newInstance()` (the older `Class.newInstance()` API is deprecated).
3. Cloning, when the class supports it.
4. Deserialization of a serialized object.
5. A factory method that returns a new or reused object.

Object Initialization (Runs EVERY TIME you use new)

Every single time you create a new object instance (new MyClass()), Java executes a strict 3-step sequence.

1. Superclass First: The parent class (super) initializes completely before the child class (subclass) starts.
2. Fields & Initializer Blocks (Source Order): Inside the class, Instance Field Initializers (e.g., int age = 20;) and Instance Initializer Blocks ({ ... }) run in the exact source order (top to bottom) they appear in the file.
3. Constructor Body: The actual constructor method (e.g., public MyClass() { ... }) runs last.

A factory method is a design approach that controls object creation, not a separate JVM allocation mechanism. A class can implement `Cloneable` and expose a suitable `clone()` method, but `Object.clone()` is a shallow-copy mechanism and cloning requires careful design. A `hashCode()` value is not a unique object ID.

`Serializable` and `Cloneable` are marker interfaces: they declare no methods and communicate a capability or signal to Java APIs. Implementing `Cloneable` permits the protected `Object.clone()` mechanism to make a shallow copy; it does not automatically provide a public clone method.

**Serialization** converts an object's serializable state into a byte representation; **deserialization** reconstructs an object from that representation. With Java object serialization, classes commonly implement `Serializable`, and object streams provide methods such as `writeObject()` and `readObject()`. Deserializing untrusted data is unsafe; prefer safer, explicitly defined data formats for external input.

The `transient` modifier excludes an instance field from default Java serialization. After deserialization, such a field has its default value unless restored separately. Static fields are class state rather than per-object serialized state, and `final` fields have additional serialization constraints; applying `transient` to these does not make them useful serialized state.

A `singleton` is a design pattern intended to provide one shared instance within a defined scope. A private constructor plus a static accessor is one approach, but thread safety, serialization, class loaders, and testing also matter. An enum singleton is a robust option in many cases. `getInstance()` is a convention, not a required Java mechanism.

An inner class is a non-static nested class and has an enclosing instance. A static nested class does not have an implicit enclosing instance:

```java
class Outer {
    class Inner { }
    static class Nested { }
}

Outer outer = new Outer();
Outer.Inner inner = outer.new Inner();
Outer.Nested nested = new Outer.Nested();
```

Relationships between objects

- **Association:** a general relationship in which objects know about or use one another. It may be one-to-one, one-to-many, many-to-one, or many-to-many.
- **Aggregation:** a weaker whole-part relationship in which the parts can exist independently of the whole.
- **Composition:** a stronger ownership relationship in which a part's lifecycle is closely tied to its owning whole.

### Constructors

A `constructor` in Java is a special method that is used to initialize new objects. `new` creates an object and invokes a constructor to initialize it. A constructor has the same name as its class and no return type—not even `void`. It is not responsible for allocating the object's memory. A constructor is not a method that returns an object reference.

#### Types of Constructors

The three commonly constructor types are the compiler-provided default constructor, an explicitly written no-argument constructor, and a parameterized constructor.

**1. Default constructor:** If a class declares no constructors, the compiler supplies a no-argument constructor. This is called the _default constructor_:

```java
class Scoreboard {
    private int score;
}

Scoreboard board = new Scoreboard();
```

The compiler-supplied constructor takes no arguments and calls the superclass's no-argument constructor. The `score` field starts at `0`, its default value. If you declare any constructor yourself, the compiler no longer supplies this default constructor.

**2. No-argument constructor:** This constructor has no parameters. You can write one explicitly when you want to choose initial values or perform setup:

```java
class Scoreboard {
    private int score;

    Scoreboard() {
        score = 100;
    }
}
```

Because this class declares a constructor, Java does not also add a default constructor. The explicit `Scoreboard()` is a no-argument constructor, but it is not the compiler-provided default constructor.

**3. Parameterized constructor:** This constructor accepts values so each new object can begin with caller-provided data:

```java
class Scoreboard {
    private final int score;

    Scoreboard(int score) {
        this.score = score;
    }
}

Scoreboard board = new Scoreboard(100);
```

**4. Copy Constructor**
**5. Private Constructor**

- A **copy constructor** is a user-defined convention that initializes an object from another object of the same class.
- A **private constructor** restricts construction from outside the class and is used in patterns such as utility classes or singletons.

#### Constructor overloading and constructor chaining

**Constructor overloading** means defining multiple constructors in one class with different parameter lists. The lists may differ by the `number of parameters`, `their types`, or the `order of different types`. Changing only access modifiers does not create an overload; two constructors with the same parameter types are duplicates and will not compile. Java selects the applicable constructor at compile time from the arguments in the `new` expression and their types.

**Constructor chaining** uses `this(...)` to call another constructor in the same class or `super(...)` to call a superclass constructor; such a call must be the first constructor statement in Java versions before Java 25. Constructors cannot be `static`, `final`, `abstract`, or `synchronized`.

In this example, the no-argument and name-only constructors delegate to the three-argument constructor, so the field assignments are written only once:

```java
class CricketPlayer {
    private final String name;
    private final int score;
    private final String team;

    CricketPlayer(String name, int score, String team) {
        this.name = name;
        this.score = score;
        this.team = team;
    }

    CricketPlayer() {
        this("Virat", 0, "India");
    }

    CricketPlayer(String name) {
        this(name, 0, "India");
    }

    void display() {
        System.out.println("Player: " + name + " | Score: " + score + " | Team: " + team);
    }
}

public class ConstructorDemo {
    public static void main(String[] args) {
        CricketPlayer defaultPlayer = new CricketPlayer();
        CricketPlayer namedPlayer = new CricketPlayer("Rohit");
        CricketPlayer customPlayer = new CricketPlayer("Rahul", 45, "LSG");

        defaultPlayer.display(); // Player: Virat | Score: 0 | Team: India
        namedPlayer.display();   // Player: Rohit | Score: 0 | Team: India
        customPlayer.display();  // Player: Rahul | Score: 45 | Team: LSG
    }
}
```

The three parameter lists are `()`, `(String)`, and `(String, int, String)`, so these constructors are overloads. `CricketPlayer()` is explicitly written; it is not a compiler-provided default constructor. In Java 21, the guide's baseline, a `this(...)` or `super(...)` call must be the first statement in a constructor. If neither call is written, Java inserts `super()` when the superclass has an accessible no-argument constructor. Constructors can be chained during object creation, but cannot be called on an object that already exists.

Field initializers and instance initializer blocks run as part of object initialization. The superclass is initialized first; then each class's field initializers and instance initializer blocks run in source order before that class's constructor body. Static field initializers and static initializer blocks run as part of class initialization, generally once per class loader. For ordinary initialization, field initializers and constructors are usually clearer; use a static initializer when class-level setup needs multiple statements.

### Object lifecycle and resource cleanup

Java has `no destructor` syntax and does not let application code explicitly free an object's memory. The garbage collector may reclaim an object when it is no longer reachable, but when collection occurs is unspecified, and the JVM is not required to return reclaimed memory immediately to the operating system. Setting a reference to `null` does not destroy an object; other references may still exist.

Garbage collection manages memory, not external resources such as files, sockets, and database connections. For resources that need deterministic cleanup, use `AutoCloseable` with try-with-resources:

```java
class NetworkConnection implements AutoCloseable {
    void transmitData() {
        System.out.println("Sending data...");
    }

    @Override
    public void close() {
        System.out.println("Connection closed.");
    }
}

public class ResourceDemo {
    public static void main(String[] args) {
        try (NetworkConnection connection = new NetworkConnection()) {
            connection.transmitData();
        } // close() runs automatically when the block exits
    }
}
```

Try-with-resources calls `close()` when control leaves the block, including when an exception occurs. It is the standard approach for resource cleanup, not a destructor: it does not destroy the object or directly control memory reclamation.

Do not use `finalize()` for cleanup. Finalization was deprecated for removal in Java 9 and its deprecation was reaffirmed in Java 18; it was not removed in Java 18. Its execution is nondeterministic and it may never run. Prefer try-with-resources for resources you own.

An instance field belongs to each object; a static field belongs to the class. Instance initialization follows superclass initialization, then field/initializer-block order, then constructor body. Static initialization runs when a class is initialized.

### The `this` keyword

Inside an instance method or constructor, `this` refers to the current object. It is often used when a parameter has the same name as a field: the parameter name would otherwise refer to the parameter, so `this.fieldName` explicitly selects the field.

```java
class Player {
    private String name;

    Player(String name) {
        this.name = name;
    }

    void setName(String name) {
        this.name = name;
    }

    void display() {
        System.out.println(this.name);
    }
}
```

In `this.name = name`, `this.name` is the current object's field and `name` is the parameter. If there is no name conflict, writing `this` is optional when accessing an instance field or method. `this` cannot be used in a static context because a static method does not run for one particular object.

In a constructor, `this(...)` calls another constructor in the same class. It must be the first statement in that constructor for this guide's Java 21 baseline; see [constructor chaining](#constructor-overloading-and-constructor-chaining). By contrast, `super(...)` calls a constructor in the superclass, and `super.methodName()` invokes a superclass implementation. `super` is not another spelling of `this`.

### Access and non-access modifiers

| Access level                  | Visibility                                                                                    |
| ----------------------------- | --------------------------------------------------------------------------------------------- |
| `private`                     | Within the declaring top-level class (including its nested members under Java's access rules) |
| No modifier (package-private) | Within the same package                                                                       |
| `protected`                   | Same package, and subclasses in other packages under protected-access rules                   |
| `public`                      | Wherever the declaring type/member is accessible                                              |

Top-level classes can generally be `public` or package-private. `private` and `protected` are available to members and nested types, not ordinary top-level classes.

Access modifiers determine who can use a declaration. **Non-access modifiers** add other rules or behavior. They are valid only on particular kinds of declarations and cannot be combined arbitrarily.

#### `final`

`final` means `a variable can be assigned only once, a method cannot be overridden, or a class cannot be subclassed`, depending on where it is used. A final field may be assigned where it is declared or in a constructor. A final reference cannot point to a different object after assignment, but the object it refers to may still be mutable.

```java
class Limits {
    static final double PI = 3.14159;
    private final int maximum;

    Limits(int maximum) {
        this.maximum = maximum;
    }
}
```

After construction, `maximum` cannot be reassigned. `static final` is commonly used for constants. A `final` class cannot be extended, and a `final` instance method cannot be overridden.

#### `static`

`static` makes a field or method belong to the class rather than to each individual object. A static field is shared by instances of that class; a static method can be called with the class name without creating an object. Since a static method has no current instance, it cannot use `this` or directly access instance fields and methods.

```java
class Counter {
    private static int total;

    Counter() {
        total++;
    }

    static int totalCreated() {
        return total;
    }
}

Counter first = new Counter();
Counter second = new Counter();
System.out.println(Counter.totalCreated()); // 2
```

Only a nested class can be declared `static`; a top-level class cannot.

#### `abstract`

An `abstract` class cannot be instantiated directly. It may contain implemented methods, fields, and constructors, as well as abstract methods with no body. A concrete subclass must implement its inherited all abstract methods.

```java
abstract class Course {
    abstract void study();
}

class JavaCourse extends Course {
    @Override
    void study() {
        System.out.println("Studying Java");
    }
}
```

Create an instance of `JavaCourse`, not `Course`. See [abstract classes and interfaces](#abstract-classes-interfaces-and-composition) for more detail.

#### Other non-access modifiers

- `synchronized`: a method or block acquires a monitor lock while it runs. An instance synchronized method locks that instance; a static synchronized method locks the class. This coordinates code using the same lock but does not automatically make all class behavior thread-safe.
- `transient`: marks an instance field to be skipped by default Java object serialization. It does not apply to methods.
- `volatile`: applies to a field and provides visibility and ordering guarantees between threads. It does not make compound operations such as `count++` atomic.
- `native`: marks a method whose implementation is provided outside Java, typically through the Java Native Interface.

---

## 4 pillars of oops

Object-oriented programming is often explained through four related ideas:encapsulation, abstraction, inheritance, and polymorphism.

1. **Abstraction:** Hide complexity, show essentials
2. **Encapsulation:** Bundle data and methods, control access
3. **Inheritance:** Derive new classes from existing ones
4. **Polymorphism:** Objects behave differently based on context

### Encapsulation

**Encapsulation** groups state and behavior and controls access to state. Private fields with carefully designed methods are common, but getters and setters are not mandatory for every field; validation and invariants should remain part of the design.

Encapsulation groups an object's data and the behavior that works with that data in one class, while controlling how code outside the class can access or change its state. This lets the object protect its own rules, called **invariants**. For example, a player's score should not become negative.

Encapsulation helps keep state valid, lets the implementation change behind a stable public API, and allows a class to expose only the operations callers need. A class can offer read-only access by providing a getter without a setter; a setter is not required for every field. `Getters and setters` are useful tools, but encapsulation is about controlling access and preserving invariants, not mechanically generating one of each for every field.

A common approach is to:

1. Make fields `private` so other classes cannot change them directly.
2. Provide public methods only for the access and changes that make sense.
3. Validate updates in those methods and reject invalid values without changing the object's state.

```java
public class EncapsulationDemo {
    static class CricketPlayer {
        private final String name;
        private int score;

        CricketPlayer(String name, int initialScore) {
            this.name = java.util.Objects.requireNonNull(name);
            setScore(initialScore);
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            if (score < 0) {
                throw new IllegalArgumentException("Score cannot be negative");
            }
            this.score = score;
        }
    }

    public static void main(String[] args) {
        CricketPlayer player = new CricketPlayer("Virat", 0);
        player.setScore(85);
        System.out.println(player.getName() + " current score: " + player.getScore());

        try {
            player.setScore(-50);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        System.out.println("Score remains: " + player.getScore()); // 85
    }
}
```

The fields cannot be changed directly from outside `CricketPlayer`. The setter rejects a negative score by throwing an exception, leaving the previous score unchanged. The constructor uses the same validation, so an invalid initial score cannot create an invalid player.

This example shows the four member access levels in a class declared in the `sports` package:

```java
package sports;

public class Player {
    private int accountPin = 4321;
    int jerseyNumber = 18; // Package-private: no access modifier
    protected String teamName = "Team India";
    public String playerName = "Virat";

    public void verifyAccess(int inputPin) {
        if (accountPin == inputPin) {
            System.out.println("Access granted to " + playerName);
        } else {
            System.out.println("Access denied.");
        }
    }
}
```

`accountPin` can be accessed directly only inside `Player`; callers can request a check through the public method without reading the field. `jerseyNumber` is accessible to other classes in the same Java package. `teamName` is accessible in the same package and to subclasses in other packages, subject to Java's protected-access rules. `playerName` and `verifyAccess` are public, subject to the class and module being accessible.

This is a teaching example, not a production credential design: do not hard-code real PINs or secrets, and consider making state private and exposing only methods that preserve the class's invariants.

### Abstraction

Abstraction exposes the important behavior of a type while hiding implementation details. Java primarily uses **abstract classes** and **interfaces** to express abstractions, but they solve different design problems.

Neither interfaces nor abstract classes are universally "fully" or "partially" abstract; choose based on whether you need a shared class implementation/state or a contract that multiple classes can implement.

| Feature              | Abstract class                                                                                                     | Interface                                                                                    |
| -------------------- | ------------------------------------------------------------------------------------------------------------------ | -------------------------------------------------------------------------------------------- |
| State                | Can have instance fields, including mutable state, and static fields.                                              | Fields are implicitly `public static final` constants; there is no per-instance state.       |
| Methods with bodies  | Can declare ordinary concrete methods.                                                                             | Can declare `default` and `static` methods (Java 8+), and private helper methods (Java 9+).  |
| Abstract methods     | Can declare abstract methods with the `abstract` keyword, as well as concrete methods.                             | Ordinary instance methods are implicitly `public abstract`; no `abstract` keyword is needed. |
| Constructors         | Can declare constructors to initialize the class's state.                                                          | Cannot declare constructors.                                                                 |
| Inheritance          | A class can extend only one class, abstract or concrete; an abstract class can also implement multiple interfaces. | A class can implement multiple interfaces; an interface can extend multiple interfaces.      |
| Direct instantiation | Cannot be instantiated directly; a concrete subclass can be created.                                               | Cannot be instantiated directly; create an implementing class.                               |
| Typical purpose      | Share state or implementation among closely related classes.                                                       | Define a capability or contract that different classes can provide.                          |

#### Abstract Class

An abstract class may have no abstract methods and still cannot be instantiated directly. A concrete subclass must implement inherited abstract methods unless it is itself abstract or inherits an implementation. When a subclass is constructed, its superclass constructor runs through `super(...)` (explicitly or implicitly), initializing the superclass portion of the object.

An abstract class cannot be instantiated directly and may contain fields, constructors, abstract methods, and implemented methods. A concrete subclass must implement inherited abstract methods unless it is itself abstract.

Accessor methods commonly read state (often named `get...`); mutator methods commonly update it (often named `set...`). Abstract methods declare behavior without a body in an abstract class or interface.

#### Interface

An interface's abstract methods are public, so their implementations in a class must be `public`. A class does not need to implement an inherited `default` method unless it wants to replace it. Interfaces can extend other interfaces with `extends`, including multiple interfaces; they do not use `implements` and cannot extend classes.

An **interface** defines a contract that classes can implement. A class can implement multiple interfaces, and an interface can extend multiple interfaces. Interfaces can contain constants, abstract methods, and (in modern Java) default, static, and private methods. Interface fields are implicitly `public static final`; ordinary abstract interface methods are implicitly `public abstract`. Interfaces do not have constructors or per-instance fields.

This example combines the two: `Animal` provides shared state and implementation, while `Companion` combines two interfaces. `Pet` also provides a `default` method:

```java
abstract class Animal {
    private final String name;

    Animal(String name) {
        this.name = name;
    }

    String name() {
        return name;
    }

    abstract void makeSound();

    void sleep() {
        System.out.println(name + " is sleeping");
    }
}

interface Pet {
    void play();

    default void rest() {
        System.out.println("Resting");
    }
}

interface Trainable {
    void train();
}

interface Companion extends Pet, Trainable {}

class Dog extends Animal implements Companion {
    Dog(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println("Woof");
    }

    @Override
    public void play() {
        System.out.println(name() + " is playing");
    }

    @Override
    public void train() {
        System.out.println(name() + " is training");
    }
}

Dog dog = new Dog("Rex");
Animal animal = dog;
animal.makeSound();
animal.sleep();

Companion companion = dog;
companion.play();
companion.train();
companion.rest();
```

Choose an abstract class when related implementations need shared state or base behavior. Choose an interface when you want to describe a capability that unrelated classes can share. Composition is another option: one object can use another object to do its work, without inheriting from it.

### Inheritance

Inheritance expresses an **is-a** relationship. A Java class extends at most one class, but it can implement multiple interfaces. A subclass inherits eligible members and may add behavior or override inherited instance methods.

• The "IS-A" Relationship: Inheritance represents a real-world taxonomy. For example, a Car IS-A Vehicle, a Dog IS-A Animal, and a CricketPlayer IS-A Player.
• The extends Keyword: Java uses the keyword extends to establish an inheritance bridge between a child and a parent.
• The Single-Inheritance Rule: In Java, a class can only extend exactly ONE parent class directly. Multiple inheritance (e.g., class Child extends Parent1, Parent2) is strictly banned to prevent architectural conflicts like the Diamond Problem.

#### Types of Inheritance

1. **Single Inheritance** - A single child class extends exactly one single parent class. This is the simplest form of inheritance.

```java
class Animal {
    void speak() { System.out.println("sound"); }
}

class Dog extends Animal {
    @Override
    void speak() { System.out.println("bark"); }
}

Animal pet = new Dog();
pet.speak();                         // "bark": runtime dispatch
```

2. **Multilevel Inheritance** -
3. **Hierarchical Inheritance**
4. **Multiple Inheritance**
5. **Hybrid Inheritance**

Java does not allow a class to extend multiple classes, avoiding ambiguities such as the diamond problem; multiple interfaces can be implemented.

### Polymorphism

#### Compile Time Polymorphism (Method Overloading)

- Static binding

**Overloading** uses the same method name with different parameter lists. The compiler selects an overload using compile-time types. Changing only the return type does not create a valid overload.

#### Run Time Polymorphism (Method Overriding)

- Dynamic binding

**Overriding** replaces an inherited instance-method implementation while respecting the method contract. The runtime object determines which overridden implementation runs. Use `@Override` so the compiler detects signature mistakes. A child method that overrides a parent method must follow Java's return-type, access, and exception compatibility rules.

Java has no `virtual` keyword. Overridable instance methods use runtime dispatch by default: when a subclass overrides a method, the implementation on the actual object's class is called. This is sometimes described as Java methods being "virtual by default," but it does not apply to `static` methods (which are hidden, not overridden), `private` methods (which are not inherited for overriding), `final` methods (which cannot be overridden) or a final class (cannot be subclassed).

```java
class Animal {
    String speak() {
        return "sound";
    }
}

class Dog extends Animal {
    @Override
    String speak() {
        return "bark";
    }
}

Animal pet = new Dog();
System.out.println(pet.speak()); // "bark": runtime dispatch
```

The reference's declared type controls which members are available at compile time. For an overridden instance method, the actual object's class selects the implementation at runtime. This is runtime polymorphism.

Upcasting from subclass to superclass is safe and implicit. Downcasting needs an explicit cast and succeeds only when the object really is an instance of the target type; otherwise it throws `ClassCastException`. Pattern matching with `instanceof` (standard in modern Java) can combine a type check and binding.

**Notes**

- Model genuine "is-a" relationships; prefer composition for "has-a" relationships.
- Follow the Liskov substitution principle: a subtype should honor the expectations of its parent type.
- Use `@Override`, and do not attempt to override static methods.

#### Super Keyword

super keyword is a special reference variable used to refer directly to an object's immediate parent (super) class. It acts as a bridge that allows a child class to access variables, methods, and constructors hidden by its own local modifications.

#### Class Type Casting

1. **Upcasting**

Upcasting is casting a subtype to a super type in an upward direction to the inheritance tree. It is an automatic procedure for which there are no efforts poured in to do so where a sub-class object is referred by a superclass reference variable. One can relate it with dynamic polymorphism.

2. **Downcasting**

Downcasting (superclass reference to a subclass type) requires an explicit cast and is only valid when the object really has that subtype; otherwise it throws `ClassCastException`. Use `instanceof` (including pattern matching where supported) when a runtime type check is needed.

Downcasting refers to the procedure when subclass type refers to the object of the parent class is known as downcasting. If it is performed directly compiler gives an error as ClassCastException is thrown at runtime. It is only achievable with the use of instanceof operator The object which is already upcast, that object only can be performed downcast.

Without perform upcast if we try to downcast , ClassCastException will be thrown.

- It is a runtime exception or unchecked exception.
- It is class, present in java.lang package.
- It can be avoided by using a operator known as 'instanceof'.

---

## Enums

An `enum` defines a fixed set of named instances. Unlike a set of integer constants, a Java enum is a reference type: it can have fields, constructors, and methods. Its constructors are implicitly `private`, and an enum cannot extend another class because it already extends `java.lang.Enum`.

`Enumeration` is a legacy interface for traversing elements of some older collection APIs. It is distinct from the `enum` language feature, which defines a fixed set of named constants.

The only difference is that enum constants are `public`, `static` and `final` (unchangeable - cannot be overridden).

An enum cannot be used to create objects, and it cannot extend other classes (but it can implement interfaces).

```java
enum Status {
    LOW(1), MEDIUM(5), HIGH(10);

    private final int value;

    Status(int value) {
        this.value = value;
    }

    int value() {
        return value;
    }
}

Status current = Status.HIGH;
System.out.println(current);         // HIGH
System.out.println(current.value()); // 10

for (Status status : Status.values()) {
    System.out.println(status);
}
```

## Wrapper Class

Eight wrapper classes correspond to the primitive types: `Byte`, `Short`, `Integer`, `Long`, `Float`, `Double`, `Character`, and `Boolean`. Wrappers let primitive values participate in APIs that work with objects, such as generics. Autoboxing and unboxing convert between primitives and their wrappers:

```java
Integer boxed = 7;          // Autoboxing
int primitive = boxed;      // Unboxing
```

Unboxing a `null` wrapper throws `NullPointerException`. Prefer `valueOf(...)` or autoboxing rather than wrapper constructors, which are deprecated in modern Java.

## Collections Framework

The Java Collections Framework is a set of interfaces, implementations, and algorithms for storing and working with groups of objects. Most core collection types and utilities are in `java.util`; concurrent implementations and interfaces are also available in `java.util.concurrent`.

### Framework overview and hierarchy

`Iterable` is the root of the collection iteration model. Its `iterator()` method returns an `Iterator`, which provides `hasNext()`, `next()`, and (optionally) `remove()`.

`Collection` extends `Iterable`; common subinterfaces are `List`, `Set`, and `Queue`. `Deque` extends `Queue`.

`Map` is part of the Collections Framework, but **does not extend `Collection`**. It stores key-value mappings rather than a sequence of elements.

```text
Iterable
└── Collection
    ├── List
    ├── Set
    │   └── SortedSet / NavigableSet
    └── Queue
        └── Deque

Map (separate from Collection)
├── SortedMap / NavigableMap
└── ConcurrentMap (in java.util.concurrent)
```

The `Collection` interface specifies common operations such as `add`, `remove`, `contains`, `size`, `isEmpty`, `iterator`, and `clear`. Not every implementation supports every optional modifying operation; an unsupported operation can throw `UnsupportedOperationException`.

`Collections` (plural) is a utility class containing static methods such as `sort`, `reverse`, `shuffle`, `min`, `max`, `frequency`, `unmodifiableList`, and `synchronizedList`. It is different from the `Collection` interface (singular).

`Arrays` provides utility methods for arrays, including `sort`, `binarySearch`, and `asList`.

Collections store reference types, not primitive values. Use wrapper types such as `Integer` in generic collections; Java automatically boxes and unboxes primitive values when appropriate:

```java
List<Integer> numbers = new ArrayList<>();
numbers.add(42);                      // int is boxed to Integer
int answer = numbers.get(0);          // Integer is unboxed to int
```

Legacy classes include `Vector`, `Stack`, `Hashtable`, `Dictionary`, and `Properties`. Some provide synchronized methods, but legacy status does not mean every operation is thread-safe as a whole. `Dictionary` is an older abstract class; prefer the `Map` API for new code. For concurrent maps, consider classes from `java.util.concurrent`, such as `ConcurrentHashMap`.

Calling a collection's `remove` method directly while iterating may cause `ConcurrentModificationException` for fail-fast iterators. Fail-fast behavior is best-effort bug detection, not a thread-safety guarantee. Use the iterator's `remove` when supported, or an appropriate concurrent collection for concurrent access.

`Enumeration` is an older, read-only traversal API used by legacy classes. It has `hasMoreElements()` and `nextElement()`; it does not have `remove()`. `Iterator` instead has `hasNext()`, `next()`, and an optional `remove()`.

`List.of(...)` (Java 9+) creates an unmodifiable list and rejects `null`. When the source is a primitive array, such as `int[]`, `Arrays.asList(array)` produces a list containing that array as one element rather than a list of boxed integers. Use a loop or stream to convert primitive array elements.

Import the types used in these examples from `java.util` (and `java.util.stream.Collectors` for the stream examples).

The `Java Collections Framework` provides a set of interfaces (like List, Set, and Map) and a set of classes (ArrayList, HashSet, HashMap, etc.) that implement those interfaces.

All of these are part of the `java.util` package.

They are used to store, search, sort, and organize data more easily - all using standardized methods and patterns.

### iterable iterface

#### Iteration, ordering, and utilities

Use the enhanced `for` loop when you only need each element. Use an index loop when you need list indexes, or an `Iterator` when you need iterator-supported removal while traversing:

```java
List<String> languages = new ArrayList<>(List.of("Java", "Kotlin", "Scala"));

for (String language : languages) {
    System.out.println(language);
}

for (int i = 0; i < languages.size(); i++) {
    System.out.println(i + ": " + languages.get(i));
}

Iterator<String> iterator = languages.iterator();
while (iterator.hasNext()) {
    if (iterator.next().equals("Kotlin")) {
        iterator.remove();            // Safe removal through this iterator
    }
}
```

### Collection interface

The Collection interface in Java is the root interface for representing a group of individual objects as a single unit. It is part of the Java Collections Framework and defines common operations for working with collections of objects.

It provides methods for operations such as adding, removing, checking, and iterating over elements.
Interfaces such as List, Set, and Queue extend the Collection interface.

1. The Core Interfaces (The Parent Blueprints)

Every collection you've used belongs to a strict hierarchy. Knowing the top-level interfaces helps you understand what a collection can do before looking at its implementation.
• Iterable: The grandfather of all collections. It has only one job: providing the ability to iterate using a for-each loop.
• Collection: The direct child of Iterable. It contains core methods like .add(), .remove(), .size(), and .isEmpty(). (List, Set, and Queue all inherit from this).
• Map: Important Note: Map is part of the Collections Framework, but it does not extend the Collection or Iterable interfaces. It is a completely separate tree branch because it handles key-value pairs rather than single elements.

### Big types of collection

1. List - ArrayList, LinkedList
2. Set - HashSet, TreeSet, LinkedHashSet
3. Map - HashMap, TreeMap, LinkedHashMap
4. queue -

The Java Collections Framework provides a set of interfaces (like List, Set, and Map) and a set of classes (ArrayList, HashSet, HashMap, etc.) that implement those interfaces.

### List Interface

A `List` is an ordered sequence with index-based access. Lists allow duplicates; some implementations also permit `null`.

```java
List<String> names = new ArrayList<>();
names.add("Ava");
names.add("Noah");
names.add("Ava");                     // Duplicates are allowed
System.out.println(names.get(0));     // Index 0
```

| Implementation | Main characteristics                                                                                                                                        |
| -------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `ArrayList`    | Resizable array; fast indexed access and usually efficient append; inserting/removing in the middle shifts later elements. Not synchronized by default.     |
| `LinkedList`   | Doubly linked list; implements both `List` and `Deque`. Indexed access requires traversal, so it is usually not the best choice for frequent random access. |
| `Vector`       | Legacy resizable array with synchronized individual methods. Synchronization does not make multi-step operations automatically atomic.                      |
| `Stack`        | Legacy LIFO stack that extends `Vector`; prefer `Deque` (often `ArrayDeque`) for stack operations in new code.                                              |

- add() Adds an element to the end of the list
- get() Returns the element at the specified position
- set() Replaces the element at the specified position
- remove() Removes the element at the specified position
- size() Returns the number of elements in the list

#### ArrayList

`ArrayList` grows as needed, but its exact capacity and growth policy are implementation details, not guarantees to rely on. `ArrayList<Integer>` contains `Integer` references, not primitive `int` storage.

`addAll` adds every element from another collection. `Arrays.asList` creates a fixed-size list backed by the given reference-type array; changing an element through either view updates the other, but adding or removing elements is unsupported. Wrap it in an `ArrayList` when a resizable list is needed:

```java
List<Integer> fixedSize = Arrays.asList(1, 2, 3);
List<Integer> resizable = new ArrayList<>(fixedSize);
resizable.add(4);

List<Integer> alsoResizable = new ArrayList<>();
alsoResizable.addAll(fixedSize);
```

#### LinkedList

The LinkedList class is a collection which can contain many objects of the same type, just like the ArrayList.

The LinkedList class has the same methods as ArrayList because both follow the List interface. This means you can add, change, remove, or clear elements in a LinkedList just like you would with an ArrayList.

However, while the ArrayList class and the LinkedList class can be used in the same way, they are built very differently.

How the ArrayList works
The ArrayList class has a regular array inside it. When an element is added, it is placed into the array. If the array is not big enough, a new, larger array is created to replace the old one and the old one is removed.

How the LinkedList works
The LinkedList stores its elements in "containers." The list has a link to the first container and each container has a link to the next container in the list. To add an element to the list, the element is placed into a new container and that container is linked to one of the other containers in the list.
Another useful class in the java.util package is the Collections class, which include the sort() method for sorting lists alphabetically or numerically.

Use an ArrayList for storing and accessing data, and LinkedList to manipulate data.

- addFirst() Adds an element to the beginning of the list
- addLast() Add an element to the end of the list
- removeFirst() Remove an element from the beginning of the list
- removeLast() Remove an element from the end of the list
- getFirst() Get the element at the beginning of the list
- getLast() Get the element at the end of the list

### Set Interface

The Set interface is part of the Java Collections Framework and is used to store a collection of unique elements.

Unlike a List, a Set does not allow duplicates, and it does not preserve the order of elements (unless you're using TreeSet or LinkedHashSet).

Common classes that implement Set:

HashSet - fast and unordered
TreeSet - sorted set
LinkedHashSet - ordered by insertion

- add() Adds an element if it's not already in the set
- remove() Removes the element from the set
- contains() Checks if the set contains the element
- size() Returns the number of elements
- clear() Removes all elements

#### Set and sorted set implementations

A `Set` does not contain duplicate elements, where duplicates are determined using equality for hash-based sets or ordering comparisons for sorted sets. Do not assume a general `Set` has a particular iteration order.

| Implementation  | Main characteristics                                                                                                                                               |
| --------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| `HashSet`       | Hash-table-based; expected fast basic operations; iteration order is unspecified; permits one `null`.                                                              |
| `LinkedHashSet` | Hash-based set that preserves insertion order; permits one `null`.                                                                                                 |
| `TreeSet`       | Tree-based `NavigableSet`; iterates in natural or comparator order and provides range/navigation operations. Usually does not permit `null` with natural ordering. |

`SortedSet` maintains elements in sorted order; `NavigableSet` adds methods for finding nearest lower/higher elements and descending views. A `TreeSet` treats elements as duplicates when its comparison returns zero, so its comparator should be consistent with `equals` when possible.

#### HashSet

A HashSet is a collection of elements where every element is unique.

It is part of the java.util package and implements the Set interface.

#### TreeSet

A TreeSet is a collection that stores unique elements in sorted order.

It is part of the java.util package and implements the Set interface.

Tip: Unlike HashSet, which has no order, TreeSet keeps its elements sorted automatically.

#### LinkedHashSet

A LinkedHashSet is a collection that stores unique elements and remembers the order they were added.

### Map interface

The Map interface is a part of the Java Collections Framework and is used to store key-value pairs. Each key must be unique, but values can be duplicated.

A Map is useful when you want to associate a key (like a name or ID) with a value (like an age or description).

Common classes that implement Map:

HashMap - fast and unordered
TreeMap - sorted by key
LinkedHashMap - ordered by insertion
Tip: Use a Map when you want to associate values with unique keys, like storing user IDs with names.

- put() Adds or updates a key-value pair
- get() Returns the value for a given key
- remove() Removes the key and its value
- containsKey() Checks if the map contains the key
- keySet() Returns a set of all keys

#### Map implementations

A `Map<K, V>` maps unique keys to values. Values may repeat. A map can expose its keys with `keySet()`, its values with `values()`, and key-value pairs with `entrySet()`.

| Implementation  | Main characteristics                                                                                |
| --------------- | --------------------------------------------------------------------------------------------------- |
| `HashMap`       | Hash-table-based map; iteration order is unspecified; permits one `null` key and `null` values.     |
| `LinkedHashMap` | Preserves insertion order by default; can also be configured for access order.                      |
| `TreeMap`       | Sorts keys using natural ordering or a `Comparator`; implements `NavigableMap`.                     |
| `Hashtable`     | Legacy synchronized map; disallows `null` keys and values.                                          |
| `Properties`    | Legacy configuration class, usually used for string property names and values; extends `Hashtable`. |

`HashMap` uses hashing to locate entries. Correct hash-based behavior relies on the `equals`/`hashCode` contract: equal objects must have equal hash codes, and key fields used by `equals`/`hashCode` should not be changed while the object is being used as a map key or set element.

`Map.Entry<K, V>` is a nested interface representing a key-value pair. Use `entrySet()` to process keys and values together:

```java
Map<String, Integer> ages = new HashMap<>();
ages.put("Ava", 28);
ages.put("Noah", 31);

for (Map.Entry<String, Integer> entry : ages.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
```

Avoid converting map keys and values into separate lists if the key-value association must be retained. Convert entries instead (the resulting entries remain map-entry objects, not independent key/value arrays):

```java
List<Map.Entry<String, Integer>> entries =
        new ArrayList<>(ages.entrySet());
```

For a map, `keySet()` and `values()` give collection views, which can be copied into lists:

```java
Map<String, Integer> scores = new HashMap<>();
scores.put("Ava", 95);
scores.put("Noah", 88);

List<String> keys = new ArrayList<>(scores.keySet());
List<Integer> values = new ArrayList<>(scores.values());
List<Map.Entry<String, Integer>> pairs =
        new ArrayList<>(scores.entrySet());
```

#### HashMap

A HashMap stores items in key/value pairs, where each key maps to a specific value.

It is part of the java.util package and implements the Map interface.

Instead of accessing elements by an index (like with ArrayList), you use a key to retrieve its associated value.

A HashMap can store many different combinations, such as:

String keys and Integer values
String keys and String values

Understanding how a HashMap works under the hood is a classic interview favorite and the absolute key to writing high-performance Java applications.
At its core, a HashMap is an array of buckets (nodes) that stores data in key-value pairs (Map.Entry<K, V>). Let’s pull back the curtain and look at the internal mechanics step-by-step.

1. The Core Infrastructure: Buckets and Hashing

When you create a HashMap, Java sets up an internal array. Each slot in this array is called a Bucket.
When you run map.put(key, value), Java performs three distinct operations to find where to store your data:

1. Calculate the Hash Code: Java runs the key's hashCode() method to generate a large integer.
2. Apply the Hash Function (Defensive Shifting): To prevent poorly written hash codes from clogging up the map, HashMap runs a secondary bitwise shifting operation to distribute the numbers evenly:java
   static final int hash(Object key) {
   int h;
   return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
   }
   Use code with caution.
   (Note: null keys always get sent straight to bucket 0.)
3. Calculate the Bucket Index: Java compresses that hash value down to fit the actual size of the current array using a bitwise AND operator (which acts like a faster modulo % operation):java
   index = (n - 1) & hash; // Where 'n' is the current array length
   Use code with caution.

4. Hash Collisions and Linked Lists

What happens if two completely different keys calculate to the exact same bucket index? This is called a Hash Collision.
HashMap handles this using a technique called Separate Chaining:
• Initially, every bucket contains a single pointer to a linked list node (Node<K,V>).
• When a collision occurs, the new key-value pair is simply appended to the end of the linked list inside that specific bucket.
When you call map.get(key), Java goes to the calculated bucket index and loops through the linked list, checking if (key.equals(searchedKey)) until it finds the matching node.

3. Treeification (The Java 8 Performance Booster)

In older versions of Java, if a bucket suffered from terrible hash collisions, its linked list could grow infinitely long. This ruined performance, turning a fast O(1) lookup into a slow O(n) search.
To fix this, Java 8 introduced Treeification:
• The Threshold: If the number of items inside a single bucket crosses a threshold of TREEIFY_THRESHOLD = 8, Java automatically converts that slow linked list into a balanced Red-Black Tree (TreeNode).
• The Performance Win: This changes the worst-case lookup time from a slow O(n) linear scan to an ultra-fast \(O(\log n)\) logarithmic search.
• Untreeify: If you remove items from that bucket later and the count drops down to UNTREEIFY_THRESHOLD = 6, Java converts the tree back into a normal linked list to save memory overhead.

4. Resizing and the Load Factor

An array cannot grow automatically. If you keep adding items to a HashMap, it will eventually run out of space, collisions will skyrocket, and performance will tank. To prevent this, the map must resize itself.
This is governed by two variables:
• Initial Capacity: The starting size of the internal bucket array. The default value is 16 (it must always be a power of 2).
• Load Factor: The measure of how full the map is allowed to get before it expands. The default value is 0.75 (75% full).

📈 The Threshold Calculation

Threshold = Capacity × Load Factor
16 × 0.75 = 12
The moment your HashMap contains more than 12 elements, a process called Rehashing is triggered:

1. Java allocates a brand-new internal array that is double the size of the previous one (e.g., growing from 16 to 32 buckets).
2. Because the array capacity (n) has changed, the index calculation (n - 1) & hash changes too.
3. Every single existing item in the map is recalculated and migrated to its new correct bucket position in the larger array.
   (Performance Tip: If you know ahead of time that you will be storing 1,000 items in a map, initialize it using new HashMap<>(1334); to completely prevent the CPU overhead of repetitive resizing!)

Summary Architectural Cheat Sheet

[HashMap]
│
├──► Array of Buckets (Default Capacity: 16)
│ ├─── Bucket 0: [Node] ──► [Node] ──► null (Linked List for < 8 items)
│ ├─── Bucket 1: null
│ └─── Bucket 2: [TreeNode] (Red-Black Tree for >= 8 items)
│ / \
 │ [TreeNode] [TreeNode]
│
└──► Load Factor (0.75): Triggers capacity doubling + rehashing when 75% full.
Would you like to see how a custom object can completely break a HashMap if you override equals() but forget to override hashCode()?

#### TreeMap

A TreeMap is a collection that stores key/value pairs in sorted order by key.
TreeMap vs HashMap
Feature HashMap TreeMap
Order No guaranteed order Sorted by keys
Null Keys Allows one null key Does not allow null keys
Performance Faster (no sorting) Slower (maintains sorted order)

2. TreeMap — The Automatically Sorted Map

A TreeMap completely discards the bucket array and hashing system. Instead, it stores its data inside a Red-Black Tree (a self-balancing binary search tree).
• How it works: Every time you add a key-value pair, it is inserted into the tree structure based on the value of the key.
• Performance: Because it utilizes a binary search tree, finding, adding, or deleting items takes logarithmic time: \(O(\log n)\).
• The Sorting Rule: Keys must either implement the Comparable interface (natural ordering like numbers or alphabetical text), or you must pass a custom Comparator when creating the map.

#### LinkedHashMap

A LinkedHashMap stores keys and values, and keeps them in the same order you put them in.

. LinkedHashMap — The Predictable Order Map

A LinkedHashMap is simply a HashMap with a doubly-linked list running through all its entries.
• How it works: Under the hood, it maintains the exact same bucket array as a HashMap. However, each node contains two extra pointers: before and after. These pointers hook every entry together in a continuous chain.
• Performance: It performs lookups at O(1) speed, with a fractionally higher memory footprint due to the link pointers.
• Ordering Modes: You can configure a LinkedHashMap to maintain two different types of order: 1. Insertion Order (Default): Iterating over the map returns elements in the exact order they were put in. 2. Access Order: The map automatically rearranges its entries. Every time you call map.get() or map.put(), that specific item is yanked from its current position and moved straight to the very end of the chain.

💡 Real-World Use Case: Building an LRU (Least Recently Used) Cache

Because access-order mode pushes recently accessed items to the end of the chain, the items at the front of the chain are automatically the oldest and least used. You can override its removeEldestEntry() method to create a self-cleaning memory cache in just a few lines of code.

### Queue interface

Queue / Deque: A collection designed for holding elements prior to processing, typically operating in a First-In-First-Out (FIFO) manner or via double-ended operations (e.g., PriorityQueue, ArrayDeque).

#### Queue and deque implementations

A `Queue` represents elements waiting to be processed. Many queues use FIFO (first in, first out), but ordering depends on the implementation. The `offer`, `poll`, and `peek` methods are often preferable when a full queue or empty queue should be reported with a return value rather than an exception.

| Implementation  | Main characteristics                                                                                                                                |
| --------------- | --------------------------------------------------------------------------------------------------------------------------------------------------- |
| `PriorityQueue` | Head is selected by natural ordering or a `Comparator`; iteration is **not** a globally sorted traversal. Does not permit `null`.                   |
| `ArrayDeque`    | Resizable array implementation of `Deque`; supports adding/removing at both ends and is often a good queue or stack choice. Does not permit `null`. |
| `LinkedList`    | Also implements `Deque`; can be used for queue/deque operations as well as list operations.                                                         |

`Deque` (pronounced “deck”) is a double-ended queue. Add and remove at either end with methods such as `addFirst`, `addLast`, `removeFirst`, `removeLast`, `offerFirst`, and `pollLast`.

```java
Deque<String> tasks = new ArrayDeque<>();
tasks.addLast("compile");
tasks.addLast("test");
String nextTask = tasks.removeFirst(); // FIFO queue use

Deque<Integer> stack = new ArrayDeque<>();
stack.push(10);
stack.push(20);
int top = stack.pop();                // LIFO stack use
```

### Comparable

java.lang

The Comparable interface in Java is used to define the natural ordering of objects of a class. It enables objects to be compared and sorted automatically without using an external Comparator.

It contains the compareTo() method, which compares the current object with another object.
It is commonly used with Collections.sort() and Arrays.sort() for sorting custom objects.

Student implements Comparable<Student> and overrides compareTo() to define the sorting logic.
compareTo() returns a negative, zero, or positive value to indicate order.
Collections.sort(students) sorts the list automatically using the natural order defined in compareTo().
Output shows the students sorted by ID in ascending order.

- `Comparable<T>` is implemented by the type being ordered and defines its natural ordering through `compareTo(T)`. It is appropriate when a class has one natural ordering.

### Comparator

- `Comparator<T>` is supplied separately and defines an ordering through `compare(T, T)`. It allows multiple orderings without changing the class.

```java
List<String> sortedNames = new ArrayList<>(List.of("Mia", "Ava", "Noah"));
Collections.sort(sortedNames);        // Natural String order
sortedNames.sort(Comparator.comparingInt(String::length)
                           .thenComparing(Comparator.naturalOrder()));
```

`Comparator`'s primary comparison method is `compare`; `equals` is inherited from `Object` and is not the method used to order items. `Collections.sort(list)` sorts by natural order, while `Collections.sort(list, comparator)` uses the provided comparator. `List.sort(comparator)` is another option.

Choose a collection based on the operations and ordering you need:

| Need                                           | Common choice   |
| ---------------------------------------------- | --------------- |
| Indexed resizable sequence, duplicates allowed | `ArrayList`     |
| Unique values, no ordering requirement         | `HashSet`       |
| Unique values, insertion order                 | `LinkedHashSet` |
| Unique values, sorted order/range queries      | `TreeSet`       |
| Key-value lookup                               | `HashMap`       |
| Key-value lookup with insertion order          | `LinkedHashMap` |
| Key-value lookup with sorted keys              | `TreeMap`       |
| FIFO work queue / double-ended queue / stack   | `ArrayDeque`    |
| Priority-based processing                      | `PriorityQueue` |

Use the interface type on the left and an implementation on the right (`List<String> names = new ArrayList<>();`). This makes it easier to change implementations. `Map` is part of the framework but does not extend `Collection`. Collection implementations differ in ordering, null handling, complexity, and thread-safety.

Big-O describes how work grows with input size: for example, array indexed access is O(1), while scanning an unsorted array is O(n). Hash collections typically offer expected O(1) lookup, but this is not an unconditional worst-case guarantee. Trees typically offer O(log n) operations. Choose based on actual access patterns, not slogans.

- Know whether order, uniqueness, index access, or key lookup is required.
- Use `equals`/`hashCode` correctly for hash collections and a consistent `compareTo`/`Comparator` for sorted collections.
- Avoid modifying a collection structurally while iterating unless using the iterator's supported removal or a suitable concurrent collection.
- Use a concurrent collection rather than assuming a regular collection is thread-safe.

## Exceptions

An exception represents an abnormal condition that interrupts normal control flow. Checked exceptions (subclasses of `Exception` other than `RuntimeException`) must be caught or declared; unchecked exceptions include `RuntimeException` and `Error` subclasses. `try` / `catch` handles exceptions, `finally` is generally used for cleanup, and try-with-resources is preferred for `AutoCloseable` resources.

- `throw` throws a particular exception object.
- `throws` declares possible exceptions in a method signature.
- Multiple `catch` clauses can handle different exception types; order more-specific types before broader types.
- `Throwable` is the root type for exceptions and errors. Applications should not ordinarily catch `Error`.

`finally` normally runs whether or not an exception was caught, but it is not guaranteed during abrupt JVM/process termination or a system failure. Prefer try-with-resources for closing files and other resources. `finalize()` is deprecated for removal and is not a reliable cleanup mechanism; use `AutoCloseable`, try-with-resources, or carefully designed cleaners instead.

• **Error**: Severe system-level crises (like OutOfMemoryError or StackOverflowError) [•]. Your program cannot catch or recover from these.
• _Exception (Checked Exceptions)_: Errors that the compiler forces you to handle before it allows compilation (e.g., IOException, FileNotFoundException).
• _RuntimeException (Unchecked Exceptions)_: Errors caused by bad programming logic (e.g., NullPointerException, ArrayIndexOutOfBoundsException). The compiler does not check for these; they appear dynamically at runtime.

### Exception

An exception represents an exceptional condition and transfers control away from the normal path.

- **Checked exceptions** must be caught or declared
- **unchecked exceptions** (`RuntimeException` and its subclasses) often indicate invalid arguments or programming errors. `Error` represents serious JVM or environment problems and is not ordinarily caught by application code.

```java
static int parsePositive(String text) {
    int value = Integer.parseInt(text); // May throw NumberFormatException
    if (value <= 0) {
        throw new IllegalArgumentException("Value must be positive");
    }
    return value;
}
```

### Exception Handling

`try` contains code that may fail; `catch` handles a specific exception; `finally` is for cleanup that must run in ordinary completion paths. Try-with-resources closes `AutoCloseable` resources reliably, including when an exception occurs.

• catch: Intercepts and handles a specific exception if it occurs inside the matching try block.
• finally: A block that always executes, regardless of whether an exception was thrown or caught. Used to close files or connections.
• throw: Explicitly throws a specific exception manually.
• throws: Declared in a method signature to warn callers that this method might throw an exception.

```java
try (BufferedReader reader = Files.newBufferedReader(path)) {
    return reader.readLine();
} catch (IOException e) {
    throw new UncheckedIOException("Could not read " + path, e);
}
```

Use `throw` to raise an exception object and `throws` to declare exceptions a method may pass to its caller. Custom exceptions are useful when they communicate a meaningful domain failure, not just to rename every error.

- Catch exceptions only when you can handle them, add useful context, or translate them at a boundary.
- Do not swallow exceptions or catch `Exception`/`Throwable` broadly without a deliberate reason.
- Preserve the cause when wrapping an exception.
- Use try-with-resources for files, streams, sockets, and other closeable resources.
- Validate input at system boundaries and fail with clear messages.

### Try with resources

Since Java 7, you can use try-with-resources. It is a special form of try that works with resources (like files and streams). The resource is declared inside parentheses try(...), and Java will close it automatically when the block finishes - even if an error occurs.

## Streams

A **stream** is a pipeline for processing data from a source. Intermediate operations (such as `filter`, `map`, and `sorted`) are lazy; a terminal operation (such as `toList`, `collect`, `count`, or `forEach`) triggers processing. A stream is normally consumed once.

```java
List<String> longNames = names.stream()
        .filter(name -> name.length() >= 5)
        .map(String::toUpperCase)
        .sorted()
        .toList(); // Unmodifiable result on modern Java
```

Use streams when the transformation pipeline becomes clearer than an explicit loop. Avoid side effects in stream operations, especially parallel streams. Parallel execution is not automatically faster and is usually inappropriate for tiny tasks or shared mutable state.

`Optional<T>` represents a value that may be absent and is most useful as a return type when absence is a normal outcome. It is not a universal replacement for every nullable field or parameter.

```java
String displayName = findName(userId)
        .filter(name -> !name.isBlank())
        .orElse("Guest");
```

The first two lists are separate views copied at iteration time, so do not rely on matching positions to preserve key-value pairs; use the entry list when the relationship matters. In Java 8+, streams can also collect map views into a specific collection:

```java
ArrayList<String> keyList = scores.keySet().stream()
        .collect(Collectors.toCollection(ArrayList::new));
ArrayList<Integer> valueList = scores.values().stream()
        .collect(Collectors.toCollection(ArrayList::new));
```

**Remember when coding**

- Always include a terminal operation if you expect a stream pipeline to execute.
- Avoid `peek` for essential program behavior; it is mainly useful for debugging.
- Prefer `orElseGet` when the fallback is expensive and should be computed only when absent.
- Do not call `get()` on an Optional without first establishing that a value exists.

## Records

A **record** (finalized in Java 16) is a concise way to declare a data-carrier class. The compiler provides component accessors, `equals`, `hashCode`, and `toString`. Record components are final, but records are only shallowly immutable: a mutable object stored in a component can still change. Records are not identical to C or C++ `struct` types; they are Java classes with specific restrictions and generated behavior.

```java
record Point(int x, int y) {}

Point point = new Point(10, 20);
System.out.println(point.x()); // 10
```

Java has no `struct` or `union` declaration. Use a class or record to group data. Java also has no raw, overlapping-memory union; to model a value that can be one of several types, use a type-safe design such as a sealed interface with permitted implementations.

## sealed types

**Sealed classes and interfaces** (finalized in Java 17) restrict which types may extend or implement them. Permitted subtypes declare whether they are `final`, `sealed`, or `non-sealed`. This is useful when a hierarchy has a deliberately limited set of cases:

```java
sealed interface Shape permits Circle, Rectangle {}
record Circle(double radius) implements Shape {}
record Rectangle(double width, double height) implements Shape {}
```

Other useful modern language features include switch expressions (Java 14), text blocks for multiline strings (Java 15), and pattern matching for `instanceof` (Java 16). Pattern matching for `switch` became a standard feature in Java 21. Always check the minimum Java release configured by the project.

**Remember when coding**

- Use enums for finite choices, not arbitrary user-provided values.
- Validate record constructor data when invariants matter.
- Defensively copy mutable record components if true immutability is required.
- Use sealed types when limiting variants improves modeling and exhaustive handling.

### Object contracts and immutability

`Object` is the root superclass of ordinary Java classes. The methods most developers need to understand are:

- `equals(Object)`: logical equality. Its contract requires reflexivity, symmetry, transitivity, consistency, and false for `null`.
- `hashCode()`: equal objects must have equal hash codes; unequal objects may collide.
- `toString()`: readable diagnostic representation; override it when useful.
- `getClass()`: returns the runtime class.

If a class overrides `equals`, it must override `hashCode` consistently; otherwise hash-based collections may behave incorrectly. `clone()` is a legacy shallow-copy mechanism and is often avoided in favor of copy constructors or factory methods. `finalize()` is deprecated for removal and must not be used for cleanup.

An immutable object cannot have its observable state changed after construction. Immutability simplifies sharing and reasoning. Typical techniques include final classes when extension is inappropriate, private final fields, no mutators, validation during construction, and defensive copies of mutable inputs and outputs.

**Remember when coding**

- Never base `equals` or `hashCode` on mutable fields if instances will be map keys or set elements.
- Handle `null` consistently in equality code (or use `Objects.equals`).
- Do not assume hash codes are unique identifiers.
- Prefer immutable value objects when practical.

## Generics

Generics let classes, interfaces, and methods work with types while preserving compile-time checking. `List<String>` describes a list whose elements are strings; it avoids unsafe casts when retrieving elements. Java generics use type erasure for most runtime behavior.

```java
static <T> T first(List<T> items) {
    if (items.isEmpty()) {
        throw new IllegalArgumentException("List must not be empty");
    }
    return items.get(0);
}
```

Type parameters are invariant: `List<Integer>` is not a subtype of `List<Number>`. Wildcards express bounded flexibility:

- `? extends T`: a producer of `T` values; read as `T`, but generally do not add non-null `T` values.
- `? super T`: a consumer of `T` values; safe to add `T`, but reads are only guaranteed as `Object`.
- `?`: unknown type, useful when the exact type is irrelevant.

This is often summarized as **PECS**: Producer Extends, Consumer Super.

```java
static void copy(List<? extends Number> source,
                 List<? super Number> destination) {
    for (Number number : source) {
        destination.add(number);
    }
}
```

**Remember when coding**

- Prefer generic types to raw types such as `List`.
- Do not use primitive type arguments; use wrappers such as `Integer`.
- Use wildcards at API boundaries when they make a method more flexible.
- Generic types are invariant; do not expect `List<Child>` to assign to `List<Parent>`.

## Lambdas and functional interfaces

A functional interface has one abstract method and can be implemented by a lambda expression. Lambdas pass behavior as a value and are commonly used with collections, callbacks, and asynchronous APIs.

```java
Predicate<String> nonEmpty = text -> !text.isBlank();
Function<String, Integer> length = String::length;
Consumer<String> print = System.out::println;
```

Common interfaces in `java.util.function` include `Predicate<T>` (test), `Function<T, R>` (transform), `Consumer<T>` (use without returning), and `Supplier<T>` (provide a value). A method reference is a concise lambda when an existing method already matches the required shape.

**Remember when coding**

- Keep lambdas short and free of surprising side effects.
- Captured local variables must be final or effectively final.
- Name a complex behavior as a method instead of embedding a long lambda.
- Know whether a callback may run immediately, later, or concurrently.

### Files, I/O, and serialization

I/O transfers data between a program and files, consoles, networks, or other processes. Byte streams (`InputStream` / `OutputStream`) handle binary data; character streams (`Reader` / `Writer`) handle text. Character encoding matters when bytes represent text.

For modern file work, `Path` and `Files` from `java.nio.file` provide useful APIs. Use buffering for efficient repeated reads/writes and try-with-resources to close resources.

```java
Path path = Path.of("data", "input.txt");
try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
    lines.filter(line -> !line.isBlank())
         .forEach(System.out::println);
} catch (IOException e) {
    System.err.println("Unable to read " + path + ": " + e.getMessage());
}
```

Serialization converts data into a form that can be stored or transmitted. Java native object serialization uses `Serializable`, but deserializing untrusted data can execute dangerous behavior and create security vulnerabilities. Prefer explicit formats such as JSON or protocol-specific formats for external data, and validate data after parsing.

**Remember when coding**

- Specify a charset for text where reproducibility matters (UTF-8 is a common choice).
- Use try-with-resources; do not rely on garbage collection to close files.
- Handle missing files, permission problems, and malformed input explicitly.
- Do not deserialize untrusted Java object streams.

### Concurrency and virtual threads

Concurrency means making progress on multiple tasks during overlapping periods; parallelism means executing tasks at the same instant on multiple cores. A Java `Thread` is one execution path. Calling `start()` schedules a new thread; calling `run()` directly is just a normal method call.

For most application tasks, use an `ExecutorService` rather than creating many raw threads yourself. Shared mutable state can cause race conditions. Use immutability, confinement, synchronization, locks, atomics, or concurrent collections to coordinate access.

```java
ExecutorService executor = Executors.newFixedThreadPool(2);
try {
    Future<Integer> result = executor.submit(() -> 20 + 22);
    System.out.println(result.get());
} finally {
    executor.shutdown();
}
```

The `synchronized` keyword protects a critical section using a monitor and establishes memory visibility. `volatile` provides visibility/order guarantees for a field but does not make compound operations such as `count++` atomic. `AtomicInteger` provides atomic operations for an integer. Locks such as `ReentrantLock` support more flexible locking but must be released in `finally`.

Common hazards include race conditions, deadlocks (cyclic lock waits), livelocks, and starvation. Avoid holding locks while calling unknown or slow code; use a consistent lock order; keep critical sections small.

Virtual threads (finalized in Java 21) are lightweight threads intended to make thread-per-task blocking workloads scale more easily. They do not make CPU-heavy work faster and do not remove the need to protect shared state.

```java
try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
    Future<String> response = executor.submit(() -> fetchData());
    System.out.println(response.get());
}
```

**Remember when coding**

- Prefer task-based executors and structured resource lifetimes over ad hoc thread management.
- Decide who owns and mutates shared state.
- Do not assume `volatile` makes a sequence of operations atomic.
- Handle interruption deliberately; restore the interrupt flag if you cannot propagate `InterruptedException`.
- Test concurrency behavior; a bug that disappears during debugging may still be a race.

### JVM, memory, and performance

The JVM manages memory automatically. The heap holds objects and arrays; each thread has a stack of method frames and local execution state. A local variable whose type is a class holds a reference to an object, not the object's contents themselves. For example, a local `Player` variable may refer to a `Player` object containing a name and score. This is a useful conceptual model, but Java does not guarantee that each reference is a literal memory address or that every local is physically stored on the stack; JVM implementations and JIT optimizations can choose different layouts.

Class metadata, program counters, and native memory are also part of the runtime picture. Exact layouts and garbage-collector behavior vary by JVM implementation. Class loaders load class definitions when needed; the built-in loader arrangement commonly includes bootstrap, platform, and application loaders.

```java
class Player {
    String name = "Virat";
    int score = 13000;
}

Player cric1 = new Player(); // cric1 refers to the Player object
System.out.println(cric1.name);
System.out.println(cric1.score);
```

Garbage collection reclaims objects that are no longer reachable; it does not guarantee immediate cleanup or close external resources. A memory leak can still occur when code accidentally keeps references to objects it no longer needs (for example, in an unbounded cache or a static collection).

Performance work should start with measurement. Big-O helps reason about algorithm growth; a profiler helps find real CPU or allocation bottlenecks. Avoid premature micro-optimization.
The JVM manages memory automatically. The **heap** primarily holds objects and arrays; **thread stacks** hold method frames, local execution state, and references as part of the conceptual model. Exact physical placement is JVM-implementation-specific: Java does not guarantee that a reference is a literal memory address or that every local variable is physically stored on a thread stack. Java also does not expose general pointer arithmetic.

A **deadlock** can occur when threads wait forever for locks held by each other. For example, thread A holds lock 1 while waiting for lock 2, and thread B holds lock 2 while waiting for lock 1. Consistent lock ordering and minimizing nested locks help reduce the risk.

Threads can be created directly, but application code commonly uses `ExecutorService` and related concurrency APIs. Calling `Thread.start()` schedules a new thread of execution; calling `run()` directly is an ordinary method call on the current thread. Overriding `start()` is generally a mistake because it can prevent the normal thread-start behavior. Use synchronization, locks, or concurrency utilities to coordinate shared mutable state.

**Remember when coding**

- Release external resources explicitly, even though memory is garbage-collected.
- Watch for unbounded caches, listeners that are never removed, and static references.
- Use a profiler and representative workload before optimizing.
- Avoid assuming a specific garbage collector or object layout.

### Reflection, annotations, and modules

**Reflection** inspects types and invokes members at runtime. It powers frameworks, dependency injection, serializers, and test tooling, but can weaken encapsulation and produce runtime-only failures. Prefer ordinary interfaces and direct calls unless runtime inspection is genuinely needed.

**Annotations** attach metadata to declarations. Built-in annotations such as `@Override`, `@Deprecated`, and `@SuppressWarnings` inform the compiler or tools. Custom annotations can be retained in source, class files, or at runtime; annotation processors can inspect them during compilation.

The Java Platform Module System (JPMS, Java 9+) organizes named modules with `module-info.java`. `requires` declares dependencies and `exports` exposes packages. Many classpath applications do not need explicit modules, but module boundaries can improve encapsulation for large systems.

**Remember when coding**

- Reflection and suppression annotations can hide problems; keep their use narrow and documented.
- `@Override` is valuable because it makes the compiler check your intention.
- Expose only the packages an application or library intends other modules to use.

### Networking and databases

Java networking APIs support sockets and higher-level HTTP clients. Prefer a well-defined protocol and a maintained client API rather than implementing wire protocols manually. Always set timeouts and handle connection failures, status codes, cancellation, and resource cleanup.

JDBC (Java Database Connectivity) is the standard low-level API for relational databases. Typical code obtains a `Connection`, prepares a parameterized `PreparedStatement`, executes it, reads a `ResultSet`, and closes resources. A connection pool is commonly used by server applications.

```java
String sql = "SELECT name FROM users WHERE id = ?";
try (Connection connection = dataSource.getConnection();
     PreparedStatement statement = connection.prepareStatement(sql)) {
    statement.setLong(1, userId);
    try (ResultSet rows = statement.executeQuery()) {
        if (rows.next()) {
            System.out.println(rows.getString("name"));
        }
    }
}
```

**Remember when coding**

- Use prepared statements for values; never concatenate untrusted input into SQL.
- Bind values using the right JDBC setter and handle SQL exceptions.
- Use transactions when a group of database changes must succeed or fail together.
- Store credentials outside source code and use least-privilege database accounts.

### Testing, debugging, and build tools

Testing checks behavior against expectations. Unit tests exercise a small unit in isolation; integration tests verify cooperating components; end-to-end tests verify workflows across system boundaries. JUnit is a common Java test framework; Mockito is commonly used for test doubles, but excessive mocking can make tests brittle.

```java
@Test
void addsTwoNumbers() {
    assertEquals(5, Calculator.add(2, 3));
}
```

Debugging means observing a program while it runs: use breakpoints, inspect variables, follow the call stack, and step through logic. Logging provides diagnostic information in production; use a logging framework rather than scattering `System.out.println` statements through application code.

Maven and Gradle manage dependencies, compilation, tests, packaging, and repeatable builds. Keep dependency versions controlled and use the project wrapper (`mvnw` or `gradlew`) where available.

**Remember when coding**

- Test normal cases, boundary cases, invalid input, and failure paths.
- Keep tests deterministic; avoid depending on real time, random values, or network availability without controlling them.
- Prefer observable behavior assertions over checking private implementation details.
- Run the same build/test command locally and in CI.

### Design, security, and maintainability

Good Java design aims for clear responsibilities, explicit dependencies, small cohesive types, and low coupling. SOLID is a set of design principles (single responsibility, open/closed, Liskov substitution, interface segregation, dependency inversion), not a checklist that requires extra classes everywhere.

Common patterns include:

- **Builder:** construct an object with many optional parameters clearly.
- **Factory:** centralize or vary object creation.
- **Strategy:** interchange algorithms behind a shared contract.
- **Adapter:** make incompatible interfaces work together.
- **Decorator:** add behavior by wrapping an object.
- **Observer:** notify interested parties when state changes.
- **Repository:** isolate persistence operations behind an abstraction.

Use a pattern when it removes a real design problem; avoid adding indirection only to match a pattern name.

Security practices matter in every layer:

- Validate and constrain untrusted input; encode output for its destination.
- Use prepared SQL statements and avoid unsafe deserialization.
- Do not hard-code passwords, tokens, or private keys.
- Handle file paths and permissions carefully; avoid path traversal.
- Keep dependencies updated and minimize unnecessary privileges.
- Do not log secrets or sensitive personal data.

**Remember when coding**

- Prefer clarity and correctness over cleverness.
- Make invalid states difficult to represent.
- Document public APIs, non-obvious constraints, and decisions—not what each obvious line does.
- Review error handling, data exposure, and boundary conditions before shipping.

### A practical Java program template

This complete example reads a count and that many integers, validates the count, computes a sum, and reports malformed input. `Scanner` is adequate for a small beginner program; use buffered parsing for performance-sensitive large input.

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            if (!scanner.hasNextInt()) {
                System.err.println("Expected an integer count.");
                return;
            }

            int count = scanner.nextInt();
            if (count < 0) {
                System.err.println("Count cannot be negative.");
                return;
            }

            long sum = 0;
            for (int i = 0; i < count; i++) {
                if (!scanner.hasNextInt()) {
                    System.err.println("Expected " + count + " integer values.");
                    return;
                }
                sum += scanner.nextInt();
            }

            System.out.println("Sum: " + sum);
        }
    }
}
```

**How to adapt it:** separate input parsing, validation, and computation into methods as the program grows. Make the computation method easy to test without console input. Use a `long` for a sum when adding many `int` values could overflow an `int`.

### Practice path and self-check

Work through these in order. For each one, implement it, test edge cases, then explain its time and space complexity:

1. Read input, validate it, and print formatted output.
2. Find min/max, sum, average, and a target in an array.
3. Reverse an array and rotate it by `k` positions.
4. Count character/word frequencies with a `Map`.
5. Remove duplicates while preserving order with a `LinkedHashSet`.
6. Build a class with invariants, a constructor, encapsulated fields, and unit tests.
7. Model a small system with interfaces and composition; add a second implementation.
8. Read a UTF-8 file safely and handle missing or malformed data.
9. Use streams to filter and group objects, then rewrite the pipeline as a loop.
10. Run independent tasks with an executor and make shared-state behavior safe.

Before considering a topic learned, check that you can answer:

- What problem does this feature solve, and when would I choose it?
- What values or states are valid, and what happens at boundaries?
- Which operations can fail, and who handles each failure?
- What are the time/space costs and mutation/ordering guarantees?
- How would I write a test for its normal case and one failure case?

---

---

---

---

---

---

---

---

---

## Java Mastery Roadmap Study Tracker

### Phase 1: Core Fundamentals

- [ ] Variables, data types, operators, type casting
- [ ] Control flow (if/else, switch, switch expressions, loops, labeled break/continue)
- [ ] Arrays (1D, 2D, jagged)
- [ ] Methods (overloading, varargs, pass-by-value semantics)
- [ ] Classes, objects, constructors, `this`
- [ ] Inheritance & polymorphism (`extends`, `super`, overriding, dynamic dispatch)
- [ ] Abstract classes vs interfaces (default/static methods)
- [ ] Access modifiers
- [ ] `static` vs instance, static blocks, static nested classes
- [ ] String pool, immutability, StringBuilder vs StringBuffer

### Phase 2: Intermediate Concepts

- [ ] Checked vs unchecked exceptions, try-with-resources, custom exceptions
- [ ] Generics (bounded types, wildcards, type erasure)
- [ ] Enums with fields/methods/constructors
- [ ] Inner classes (member, static nested, local, anonymous)
- [ ] `equals()`, `hashCode()` contract, `toString()`, `clone()`
- [ ] Designing immutable classes
- [ ] I/O basics (File, Streams, Reader/Writer, NIO intro)

### Phase 3: Collections Framework

- [ ] Collection hierarchy overview
- [ ] ArrayList vs LinkedList (internals + when to use)
- [ ] HashSet, LinkedHashSet, TreeSet
- [ ] HashMap internals (hashing, buckets, treeification, load factor)
- [ ] LinkedHashMap, TreeMap (NavigableMap methods)
- [ ] ConcurrentHashMap internals
- [ ] PriorityQueue, ArrayDeque
- [ ] Iterator vs ListIterator, fail-fast vs fail-safe
- [ ] Comparable vs Comparator, chaining comparators
- [ ] Collections utility class methods

### Phase 4: Data Structures (implement from scratch)

- [ ] Dynamic array (understand ArrayList growth)
- [ ] Singly / doubly / circular linked lists
- [ ] Stack & Queue (array-based and linked-list-based)
- [ ] Binary Tree, BST
- [ ] AVL / Red-Black trees (conceptual)
- [ ] Trie
- [ ] Min-heap (then compare to PriorityQueue)
- [ ] Graph (adjacency list/matrix) + BFS, DFS
- [ ] Dijkstra's algorithm
- [ ] Topological sort
- [ ] Hash table from scratch (chaining vs open addressing)

### Phase 5: Functional Programming & Streams

- [ ] Lambda expressions, functional interfaces
- [ ] Function, BiFunction, Predicate, Supplier, Consumer
- [ ] Method references
- [ ] Stream creation
- [ ] Intermediate ops (map, filter, sorted, distinct, flatMap, peek)
- [ ] Terminal ops (collect, reduce, forEach, count, anyMatch/allMatch)
- [ ] Collectors (groupingBy, partitioningBy, joining, toMap)
- [ ] Parallel streams (when to use / avoid)
- [ ] Optional best practices

### Phase 6: Concurrency & Multithreading

- [ ] Thread vs Runnable vs Callable, thread lifecycle
- [ ] `synchronized`, intrinsic locks, wait/notify/notifyAll
- [ ] Race conditions, deadlock, livelock, starvation
- [ ] ExecutorService & thread pools
- [ ] Future & CompletableFuture chaining
- [ ] ReentrantLock, ReadWriteLock, Condition
- [ ] Atomic classes & CAS
- [ ] ConcurrentHashMap, CopyOnWriteArrayList, BlockingQueue
- [ ] `volatile` & happens-before
- [ ] CountDownLatch, CyclicBarrier, Semaphore
- [ ] Virtual threads (Java 21+)

### Phase 7: JVM & Memory Management

- [ ] JVM architecture (class loader, heap, stack, method area)
- [ ] GC algorithms overview (Serial, Parallel, G1, ZGC)
- [ ] Object lifecycle & garbage collection
- [ ] Common memory leak causes in Java

### Phase 8: Advanced Language Features

- [ ] Records
- [ ] Sealed classes
- [ ] Pattern matching (instanceof, switch)
- [ ] Text blocks
- [ ] Reflection API
- [ ] Custom annotations
- [ ] Java Module System

### Phase 9: Design Patterns & Best Practices

- [ ] Singleton, Factory, Builder
- [ ] Adapter, Decorator, Proxy
- [ ] Observer, Strategy, Command
- [ ] SOLID principles
- [ ] Effective Java practices

### Phase 10: Ecosystem

- [ ] Maven or Gradle
- [ ] JDBC
- [ ] Spring Boot basics
- [ ] JUnit & Mockito

---

---

---

---

---

---

---

Varargs (short for Variable Arguments) is a feature introduced in Java 5 that allows a method to accept zero or a flexible number of arguments of a specified data type [•].
Instead of forcing you to manually create and pack numbers into an array before calling a method, or writing multiple overloaded methods, varargs allows you to pass a comma-separated list of items directly [•].
Under the hood, the Java compiler automatically bundles these inputs into a standard array [•].

1. Syntax Rules

To declare a varargs parameter, you follow the data type with three dots (...) and a variable name [•].
java
public static void myMethod(int... numbers) {
// 'numbers' is treated completely as an int[] array inside this block
}
Use code with caution.

The Two Strict Compiler Constraints:

1. The Maximum Count Rule: A method signature can have only one varargs parameter [•].
2. The Position Rule: The varargs parameter must be the absolute last parameter in the method signature [•].
   java
   void checkData(String label, int... values) { } // CORRECT
   // void checkData(int... values, String label) { } // ERROR: Compiles will fail!
   Use code with caution.

3. Complete Code Implementation

Here is a practical example showing how to create a flexible calculation tool using varargs:
java
package basics;

public class VarargsDemo {

    // A single method that can calculate the sum of 0, 5, or 100 integers!
    public static int calculateSum(String operationName, int... numbers) {
        System.out.println("\nExecuting: " + operationName);

        // 'numbers' is processed exactly like a standard array
        System.out.println("Arguments received: " + numbers.length);

        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        return total;
    }

    public static void main(String[] args) {
        // Case 1: Passing ZERO arguments to varargs
        int sum0 = calculateSum("Empty Check");
        System.out.println("Total: " + sum0); // Output: 0

        // Case 2: Passing a small list of comma-separated arguments
        int sum1 = calculateSum("Small Addition", 10, 20, 30);
        System.out.println("Total: " + sum1); // Output: 60

        // Case 3: Passing a larger list of arguments
        int sum2 = calculateSum("Large Addition", 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Total: " + sum2); // Output: 55

        // Case 4: You can also pass an actual pre-made array directly!
        int[] explicitArray = {100, 200, 300};
        int sum3 = calculateSum("Array Passing", explicitArray);
        System.out.println("Total: " + sum3); // Output: 600
    }

}
Use code with caution.

3. Overloading Varargs (The Ambiguity Trap)

While you can technically overload a method that contains varargs, you must be extremely careful to avoid Ambiguity Errors, where the compiler gets confused about which method you are trying to target.

The Trap Example:

java
public static void printData(int... nums) { }
public static void printData(Integer... nums) { }

// Inside main:
// printData(10, 20); // ERROR: Ambiguous method call!
// The compiler cannot decide whether to treat them
// as primitive ints or auto-box them into Wrapper Integers.
Use code with caution.

Summary Checklist

Property Standard Array Parameter (int[]) Varargs Parameter (int...)
Calling Syntax Must wrap items in an array: func(new int[]{1,2}) [•] Pass values directly as commas: func(1, 2) [•]
Accepts Empty Inputs? No, passing nothing throws a signature error. Yes, passing nothing initializes an array of size 0.
Position Restrictions Can be placed anywhere in the parameter list. Must be the final argument in the signature [•].
Count Per Method Infinite array inputs allowed. Maximum one varargs allowed per method [•].

Now that you know how varargs streamline inputs, would you like to see how Java's built-in System.out.printf() uses varargs under the hood to handle dynamic text insertions, or should we move on to Exception Handling (try-catch) frameworks?

---

Dynamic dispatch only works on normal instance methods. The JVM will completely bypass dynamic dispatch and use compile-time resolution for:
• Static Methods: They belong to the class blueprint, causing Method Hiding rather than overriding [•].
• Private Methods: They are invisible to child inheritance chains and cannot be overridden [•].
• Final Methods: They are locked down and explicitly ban overriding.
• Variables (Fields): In Java, variables do not participate in polymorphism. If a child shadows a parent variable, the output is decided strictly by the reference type at compile time [•].
Now that you have mastered the complete structural puzzle of how objects behave dynamically, let me know if you would like to proceed with:
• The next big structural pillar: Exception Handling (try-catch-finally) to prevent system crashes?
• Learning how to manage dynamic memory vectors using an ArrayList?

---

In Java, Strings are handled differently than regular objects to optimize memory usage and execution speed.
Here is the comprehensive guide to the String Pool, Immutability, and the direct architectural battle between StringBuilder and StringBuffer.

1. Immutability: Why Strings Cannot Be Changed

In Java, Strings are completely immutable, meaning that once a String object is created in memory, its text content cannot be modified, updated, or rewritten.

What happens when you alter a String?

When you write code that looks like it modifies a String, Java doesn't change the original text. Instead, it creates a brand-new String object at a completely different memory address and updates your pointer variable to look at the new location.
java
String s = "Java";
s = s + " OOP"; // The original "Java" string object remains frozen in memory.
// A new object "Java OOP" is built, and 's' now points to it.
Use code with caution.

Why did Java design Strings this way?

• Security: Strings are used to pass critical runtime data like network links, database passwords, and file paths. If Strings were mutable, an untrusted component could change a file path variable after it was validated, bypassing security gates.
• Thread Safety: Since Strings cannot change, multiple execution threads can share the exact same String instance without worrying about data corruption or synchronization errors.
• Caching & Optimization: It allows the existence of the String Pool.

2. The String Pool (String Constant Pool)

The String Pool is a specialized storage zone inside the Heap Memory designed to eliminate duplicate allocations.
Because Strings are used everywhere in code, creating a new memory block for every identical text fragment would quickly drain system RAM. The String Pool stores exactly one copy of each unique literal value.

Literal vs. new Keyword Behavior:

• Case A: Using Literals (String s1 = "Virat";)
Java checks the String Pool first. If "Virat" already exists, Java skips allocation and returns a pointer to the existing pool instance. If it doesn't exist, it creates it in the pool.
• Case B: Using new (String s2 = new String("Virat");)
The new keyword forces the JVM to bypass the pool optimization rules. It carves out a brand-new object block directly in the normal Heap area, even if "Virat" is already inside the pool.
text
[ HEAP MEMORY ZONE ]
┌───────────────────────────────────────┐
│ │
│ [ String Constant Pool ] │
│ ┌──────────────────────┐ │
s1 ───┼──►│ "Virat" │ │
│ └──────────────────────┘ │
│ ▲ │
s3 ───┼───────────────┘ │
│ │
│ [ Normal Heap Area ] │
│ ┌──────────────────────┐ │
s2 ───┼──►│ String Object (New) │ │
│ └──────────────────────┘ │
└───────────────────────────────────────┘
Use code with caution.

Code Proof Verification:

java
String s1 = "Virat";
String s3 = "Virat";
String s2 = new String("Virat");

System.out.println(s1 == s3); // true (Both reference pointers point to the exact same pool address)
System.out.println(s1 == s2); // false (s2 points to a unique custom memory block outside the pool)

// Note: Always use .equals() to compare values instead of memory pointers (==)
System.out.println(s1.equals(s2)); // true (Their actual text contents match)
Use code with caution.

3. StringBuilder vs. StringBuffer (The Dynamic Alternatives)

If you are writing a loop that concatenates a string thousands of times (e.g., building a massive CSV document file), using String is a performance nightmare because it creates thousands of temporary orphan string objects in memory.
To solve this, Java provides StringBuilder and StringBuffer. Both represent mutable sequences of characters [•]—they allow you to append, insert, or delete text inside the exact same memory box without allocating new objects.

Direct Architectural Comparison

Metric StringBuilder StringBuffer
Thread Safety Not Thread-Safe (Methods are not synchronized). Thread-Safe (Methods are locked using the synchronized keyword) [•].
Execution Speed Significantly Faster (No overhead penalty for thread locking). Slower (Locks memory blocks to guarantee thread integrity).
Introduction Added modernly in Java 5 to fix performance bottlenecks. Standard legacy class present since Java 1.0.
Primary Use Case Single-threaded loops, local methods, standard everyday text parsing. Multi-threaded operations where multiple background threads process a shared buffer concurrently.

Code Syntax Usage:

Both share identical method setups. Simply replace the class name depending on your thread-safety requirements:
java
// Modifies text dynamically in place without allocating new object structures
StringBuilder sb = new StringBuilder("Cricket");
sb.append(" Player");
sb.insert(0, "Indian ");

System.out.println(sb.toString()); // Output: Indian Cricket Player
Use code with caution.

Summary Checklist

• Use standard String when you want unchangeable text variables that can be cached safely in the String Pool [•].
• Use StringBuilder when you are doing heavy string manipulation (appending/looping) inside a single thread for maximum speed.
• Use StringBuffer only when multiple threads are reading and modifying the exact same text accumulator buffer simultaneously [•].
Now that you know how text objects operate in memory, where should we head next?
• Learn how to intercept runtime errors using Exception Handling (try-catch-finally)?
• Explore dynamic memory storage vectors using the Java ArrayList class container?

---

It looks like you are asking about throw and throws! These are two very important keywords in Java's exception handling system, and it is incredibly common to confuse them because their names are so similar.
However, they do completely different jobs. Think of it this way: throw is an action (doing something), while throws is a warning (announcing something).

The Quick Breakdown

Feature throw (Action) throws (Warning)
Purpose Used to explicitly crash the program or trigger a specific error right now. Used in a method signature to warn that this method might cause an error later.
Location Inside the method body (like an if statement). Next to the method name (in the method header).
Quantity Followed by a single exception object (new Exception()). Followed by a list of exception classes, separated by commas.

1. throw — The Action 💥

You use throw when your code detects that something is wrong, and you want to actively create and fire an error.
• Analogy: Firing a flare gun because you found a problem.
• Example: Imagine you are writing a program for a bar, and someone under 18 tries to enter.
java
public void checkAge(int age) {
if (age < 18) {
// You are actively creating and triggering the error here
throw new ArithmeticException("Access Denied: You must be at least 18 years old.");
} else {
System.out.println("Access Granted!");
}
}
Use code with caution.

2. throws — The Warning ⚠️

You use throws when a method contains code that might cause a dangerous error (like reading a file that doesn't exist), but you don't want to fix it inside this method. Instead, you are passing the responsibility to whoever calls this method.
• Analogy: Putting a "Wet Floor" sign outside a room. You aren't mopping the floor; you are just warning people before they walk in.
• Example: A method that opens a file might fail if the file is missing.
java
import java.io.FileReader;
import java.io.IOException;

public class FilePlayer {
// The "throws" keyword warns the compiler: "Hey, this method might fail with an IOException!"
public void readFile() throws IOException {
FileReader file = new FileReader("cheatsheet.txt");
// ... read file logic ...
}
}
Use code with caution.
Because readFile() has the throws warning, anyone who tries to use readFile() in the future must wrap it in a try-catch block, or their code won't compile!

Putting Them Together

You will often see them used in tandem. A method will use throws in its title to warn the world, and then use throw inside its body to actually trigger the error.
java
// 1. Warning: "This method might throw an Exception!"
public void validateUser(String username) throws Exception {
if (username.equals("admin")) {
// 2. Action: Actually throwing the exception!
throw new Exception("Username already taken.");
}
}
Use code with caution.
Learn more about managing these key concepts in the Java Exceptions Documentation.
Would you like to try a quick practice code challenge where you fix a program using throw and throws, or would you prefer to see how to handle a Checked Exception?

---

Yes, your code is syntactically correct and will run, but it uses what Java calls "Raw Types" (omitting the angle brackets <>).
While Java allows this for backward compatibility, it is considered bad practice in modern Java programming.
Here is why this happens, why it can be dangerous, and how you should write it instead.

Why does it allow any data type right now?

When you create a list without specifying a type (like new ArrayList()), Java defaults the list to hold the ultimate parent type: Object.
Because Object is the parent of all classes in Java, you can throw integers, characters, strings, and custom objects all into the exact same list.

⚠️ The Problem with this Approach

While adding mixed items is easy, getting them out safely is a nightmare.
When you retrieve an item from a raw list, Java returns it as a generic Object. To actually use it as a String or an Integer, you have to manually cast it. If you guess the wrong type, your program will crash at runtime.
java
// Danger zone example:
String myStr = (String) list1.get(0); // CRASH! Index 0 is an Integer (1), not a String.
// Throws: java.lang.ClassCastException
Use code with caution.

The Modern, Safe Way: Use Generics <>

In modern Java, you should always tell the list exactly what single data type it is allowed to hold using angle brackets <>. This catches type errors while you are typing your code (compile-time) rather than when your app is running for users.

If you only want Strings:

java
List<String> names = new ArrayList<>();
names.add("str");
// names.add(1); // The compiler will instantly block this and show an error!
Use code with caution.

If you genuinely NEED a list of mixed data types:

Instead of leaving it completely blank, explicitly state that it holds Object. This signals to other developers that the mixing is intentional.
java
List<Object> mixedList = new ArrayList<>();
mixedList.add(1);
mixedList.add('c');
mixedList.add("str");
Use code with caution.
Would you like to see how to use an instanceof check to safely read and loop through a mixed List<Object> without crashing your program?

---

Elements in an ArrayList are actually objects. In the examples above, we created elements (objects) of type "String". Remember that a String in Java is an object (not a primitive type). To use other types, such as int, you must specify an equivalent wrapper class: Integer. For other primitive types, use: Boolean for boolean, Character for char, Double for double, etc:

---

Since you just learned that Java collections can only hold objects (and not primitive types like int or char), you have stumbled right into the exact reason Wrapper Classes exist!
A Wrapper Class is a built-in Java class that wraps around a primitive data type, turning it into a full-fledged Object.

The Primitive vs. Wrapper Matchup

Every primitive type in Java has a corresponding Wrapper Class located in the java.lang package (which is imported automatically):

Primitive Type (Basic Data) Wrapper Class (Object)
int Integer
char Character
double Double
boolean Boolean
float Float
byte / short / long Byte / Short / Long

🔄 Autoboxing and Unboxing (The Magic Behind the Scenes)

Java makes working with wrapper classes incredibly easy by automatically converting back and forth between primitives and objects.

1. Autoboxing (Primitive ➔ Wrapper Object)

When you assign a primitive value directly to a wrapper class variable, Java automatically "boxes" it into an object.
java
int primitiveInt = 5;
Integer objectInt = primitiveInt; // Autoboxing happens here automatically!
Use code with caution.
Why this matters for Collections: This is exactly why you can write list.add(1) into a List<Integer>. Java automatically boxes the primitive 1 into an Integer object before saving it.

2. Unboxing (Wrapper Object ➔ Primitive)

When you assign a wrapper object back to a primitive variable, Java automatically extracts the value.
java
Integer objectInt = 25;
int primitiveInt = objectInt; // Unboxing happens here automatically!
Use code with caution.

🛠️ Why Else Do We Need Wrapper Classes? (Utility Methods)

Wrapper classes aren't just wrappers—they are packed with incredibly useful static methods to convert and manipulate data.

1. Converting Strings to Numbers (Parsing)

If you get a numeric value as text (like input from a text file or user interface), wrapper classes help you convert it:
java
String priceText = "499";
int price = Integer.parseInt(priceText); // Converts String to int
Use code with caution.

2. Checking Character Properties

The Character wrapper class has built-in tools to inspect letters and symbols:
java
char myChar = 'A';
System.out.println(Character.isUpperCase(myChar)); // true
System.out.println(Character.isDigit(myChar)); // false
Use code with caution.

3. Finding Data Limits

Ever wonder what the biggest number an int can hold is? You can check using constants inside the wrapper:
java
System.out.println(Integer.MAX_VALUE); // 2147483647
System.out.println(Integer.MIN_VALUE); // -2147483648
Use code with caution.
Would you like to see a quick code example showing how a NullPointerException can accidentally happen when trying to unbox a wrapper class that has a null value?

---

A terminal operation is the final step in a Java Stream pipeline [🏆].
Think of a stream like a factory conveyor belt. Intermediate operations (like filter() and map()) change or clean the products on the belt, but a terminal operation is the worker at the very end of the line who packages everything up into a box, counts the total, or ships it out.
Once a terminal operation is called, the stream is officially closed and cannot be reused.

⚠️ The Golden Rule: Streams are Lazy

If you don't add a terminal operation at the end of your stream pipeline, nothing happens. Java won't even execute your filters or maps.
java
// ❌ THIS DOES NOTHING (Missing terminal operation)
list.stream().filter(n -> n > 5);

// THIS WORKS (forEach is a terminal operation)
list.stream().filter(n -> n > 5).forEach(System.out::println);
Use code with caution.

Common Terminal Operations Cheat Sheet

Terminal operations generally fall into three common buckets depending on what they produce:

1. Collecting Data (Turning it back into a Collection)

• collect(Collectors.toList()): Packages the remaining elements into a fresh List or Set.
• collect(Collectors.groupingBy(...)): Groups your items into a Map (like you did in the previous challenge).

2. Looping & Side Effects

• forEach(consumer): Iterates over every element one last time (usually to print them with System.out::println).

3. Math & Aggregations (Reducing to a single value)

• count(): Returns the total number of items left in the stream as a long.
• reduce(...): Combines all elements into a single value (e.g., adding all numbers together).
• average() / sum() / max(): Math utilities available on primitive streams (like IntStream).

4. Matching & Searching (Short-circuit operations)

• findFirst() / findAny(): Grabs a single element matching your criteria and wraps it in an Optional.
• anyMatch(predicate): Returns true if at least one element matches your condition.

How to spot them in code

Look at the return type of the method.
• If a method returns another Stream<T>, it is an intermediate operation.
• If it returns anything else (like a List, a Map, a long, a boolean, or void), it is a terminal operation!
Would you like to jump back to Problem 6 now and see how to flatten nested lists using flatMap, or do you want to write a quick stream that uses the reduce() terminal operation to calculate a factorial or sum?

---

Here is the complete, comprehensive guide to all terminal operations in the Java Streams API, organized by what they return.
Remember, a terminal operation always closes the stream [🏆] and returns either a concrete value (like a List, long, boolean, or Optional) or void.

📦 1. Collection & Packaging Operations (The collect Family)

These gather the stream elements and bundle them into collections, structures, or strings.
• collect(Collector): The most flexible terminal operation. It transforms the stream into collections like List, Set, or Map.java
List<String> list = stream.collect(Collectors.toList());
Set<String> set = stream.collect(Collectors.toSet());
Use code with caution.
• toArray(): Collects the elements of the stream into a classic, fixed-size Java array.java
String[] array = stream.toArray(String[]::new);
Use code with caution.

🔍 2. Search & Find Operations

These look for specific elements in the stream and return an Optional (because the matching element might not exist).
• findFirst(): Returns an Optional containing the very first element in the stream.java
Optional<String> first = stream.findFirst();
Use code with caution.
• findAny(): Returns an Optional containing any element from the stream. In parallel streams, this is much faster than findFirst() because it grabs whichever element finishes processing first.java
Optional<String> any = stream.findAny();
Use code with caution.

📉 3. Reduction & Aggregation Operations

These take a stream of multiple values and compress or combine them down into a single final value (like a sum, maximum, or total count).
• reduce(accumulator): Combines elements using a custom binary operation (e.g., multiplying all numbers together or concatenating strings).java
Optional<Integer> sum = stream.reduce((a, b) -> a + b);
Use code with caution.
• count(): Counts the total number of elements remaining in the stream and returns a long.java
long total = stream.filter(x -> x > 10).count();
Use code with caution.
• min(Comparator): Finds the minimum element based on a sorting rule. Returns an Optional.java
Optional<Integer> minVal = stream.min(Comparator.naturalOrder());
Use code with caution.
• max(Comparator): Finds the maximum element based on a sorting rule. Returns an Optional.java
Optional<Integer> maxVal = stream.max(Comparator.naturalOrder());
Use code with caution.
💡 Special Numeric Reductions: If you convert your stream to a primitive stream (like IntStream, LongStream, or DoubleStream), you get access to three extra mathematical terminal operations out of the box:
• sum(): Adds up all numeric elements (returns int, long, or double).
• average(): Calculates the arithmetic mean (returns an OptionalDouble).
• summaryStatistics(): Returns a special object containing the count, sum, min, max, and average all at once.

🚦 4. Matching Operations (Short-Circuiting)

These check the elements against a condition and immediately return a boolean. They "short-circuit," meaning they stop processing the stream the exact moment they know the final answer.
• anyMatch(Predicate): Returns true if at least one element matches the condition.java
boolean hasAdults = numbers.stream().anyMatch(age -> age >= 18);
Use code with caution.
• allMatch(Predicate): Returns true only if every single element matches the condition.java
boolean allPassed = scores.stream().allMatch(score -> score >= 40);
Use code with caution.
• noneMatch(Predicate): Returns true if zero elements match the condition.java
boolean noNegatives = numbers.stream().noneMatch(n -> n < 0);
Use code with caution.

🔄 5. Iteration & Action Operations

These are used when you want to execute a direct action or side-effect on every remaining item rather than returning a value.
• forEach(Consumer): Iterates over every element in the exact order determined by the stream source.java
stream.forEach(System.out::println);
Use code with caution.
• forEachOrdered(Consumer): Forces the stream to process elements strictly in their original layout order, even if the stream is running across multiple CPU threads in parallel (.parallelStream()).java
parallelStream.forEachOrdered(System.out::println);
Use code with caution.
Would you like to try a mini coding challenge using reduce() or anyMatch() to see how these math and matching operations work in practice?

---

When creating your stream pipelines, you should follow this rule of thumb: Always start the stream from the concrete class (like ArrayList, HashSet, or HashMap), but collect the results back into the general interface (List, Set, or Map).
Here is exactly how this breaks down in practice.

1. The Starting Line (The Source)

You can call .stream() on any class or interface that belongs to the Java Collections Framework. Both options below are perfectly correct to start a stream:
java
// Option A: Starting from the interface (Works perfectly)
List<String> list1 = new ArrayList<>();
list1.stream()...

// Option B: Starting from the concrete class (Works perfectly too)
ArrayList<String> list2 = new ArrayList<>();
list2.stream()...
Use code with caution.
Because ArrayList implements the List interface, and List contains the .stream() blueprint method, you can start a stream from either one without any difference in performance or features.
Note for Maps: A HashMap does not have a direct .stream() method. To stream a map, you must choose what part of it you want to stream:
• map.keySet().stream() (Stream of keys)
• map.values().stream() (Stream of values)
• map.entrySet().stream() (Stream of key-value pairs)

2. The Finish Line (The Terminal Operation)

This is where the distinction becomes critical. When you use a terminal operation like Collectors.toList() or Collectors.groupingBy(), Java returns the general interface by default, not the concrete implementation.
java
// 🏆 RIGHT: Java returns a general List contract
List<String> result = names.stream()
.filter(n -> n.length() > 3)
.collect(Collectors.toList());

// ❌ WRONG: This will cause a compilation error!
ArrayList<String> result = names.stream()
.filter(n -> n.length() > 3)
.collect(Collectors.toList());
Use code with caution.
Collectors.toList() guarantees it will return some type of object that acts like a List, but it does not guarantee it will specifically be an ArrayList. Tying your final variable to ArrayList will break the compiler.

Summary Checklist for Clean Streams

• Start: Use whatever variable type you already have (List, ArrayList, HashSet, etc.). They all support .stream().
• Finish: Always store the stream's final collected output inside general interface types like List, Set, or Map to keep your code standard and flexible.
Would you like to move on to Problem 6 now and see how to flatten nested structures using flatMap, or do you have any more questions about structuring types?

---

While a standard HashMap offers fast O(1) lookup performance, it provides absolutely no guarantees about the order of its keys. If you iterate through it, your data will look completely scrambled.
To solve this, Java provides two specialized implementations: LinkedHashMap (which maintains insertion or access order) and TreeMap (which automatically sorts your keys).
Let's look at how they function under the hood and explore the navigational methods that make TreeMap exceptionally powerful.

1. LinkedHashMap — The Predictable Order Map

A LinkedHashMap is simply a HashMap with a doubly-linked list running through all its entries.
• How it works: Under the hood, it maintains the exact same bucket array as a HashMap. However, each node contains two extra pointers: before and after. These pointers hook every entry together in a continuous chain.
• Performance: It performs lookups at O(1) speed, with a fractionally higher memory footprint due to the link pointers.
• Ordering Modes: You can configure a LinkedHashMap to maintain two different types of order: 1. Insertion Order (Default): Iterating over the map returns elements in the exact order they were put in. 2. Access Order: The map automatically rearranges its entries. Every time you call map.get() or map.put(), that specific item is yanked from its current position and moved straight to the very end of the chain.

💡 Real-World Use Case: Building an LRU (Least Recently Used) Cache

Because access-order mode pushes recently accessed items to the end of the chain, the items at the front of the chain are automatically the oldest and least used. You can override its removeEldestEntry() method to create a self-cleaning memory cache in just a few lines of code.

2. TreeMap — The Automatically Sorted Map

A TreeMap completely discards the bucket array and hashing system. Instead, it stores its data inside a Red-Black Tree (a self-balancing binary search tree).
• How it works: Every time you add a key-value pair, it is inserted into the tree structure based on the value of the key.
• Performance: Because it utilizes a binary search tree, finding, adding, or deleting items takes logarithmic time: \(O(\log n)\).
• The Sorting Rule: Keys must either implement the Comparable interface (natural ordering like numbers or alphabetical text), or you must pass a custom Comparator when creating the map.

🗺️ Navigating a TreeMap (NavigableMap Methods)

Because TreeMap implements the NavigableMap interface, it acts less like a simple lookup table and more like a searchable directory. You can query the map for close matches, bounds, and ranges using these specialized methods:

🎯 Closest-Match Queries (Math Boundary Lookups)

Imagine you have a TreeMap of tax brackets or pricing tiers: [100, 200, 500].
• floorKey(K key): Returns the greatest key less than or equal to the given key.
• map.floorKey(250) → Returns 200
• ceilingKey(K key): Returns the least key greater than or equal to the given key.
• map.ceilingKey(250) → Returns 500
• lowerKey(K key): Returns the strictly greatest key less than the given key (<).
• higherKey(K key): Returns the strictly least key greater than the given key (>).

✂️ Sub-Range Extraction (Slicing Your Map)

You can instantly slice out sub-sections of your map without copying the underlying data:
• subMap(fromKey, toKey): Extracts a window of data between two keys.
• headMap(toKey): Returns everything from the very beginning up to your specified key.
• tailMap(fromKey): Returns everything from your specified key all the way to the very end.

🏎️ Quick Extrems & Direction Flips

• firstEntry() / lastEntry(): Instantly grabs the absolute lowest or highest key-value pairs in the map (O(1) operation).
• pollFirstEntry() / pollLastEntry(): Grabs and deletes the absolute lowest or highest entry (perfect for building priority queues).
• descendingMap(): Returns a backward view of your entire map, flipping the sorting logic from ascending to descending instantly.

Architectural Head-to-Head Comparison

Feature HashMap LinkedHashMap TreeMap
Underlying Structure Array + Linked List / Red-Black Tree Buckets Array Buckets + Global Doubly-Linked List Red-Black Tree Structure
Iteration Order Completely Unpredictable Insertion or Access Order Sorted Order (Natural / Comparator)
Time Complexity O(1) average O(1) average \(O(\log n)\) guaranteed
Allows null Keys? Yes (Goes to bucket 0) Yes No (Throws NullPointerException)

Would you like to try writing a mini program where we use a TreeMap to build a tiered shipping cost calculator using the .ceilingEntry() or .floorEntry() navigation methods?

---

In a standard HashMap, concurrent access by multiple threads can lead to subtle bugs or infinite loops during resizing. While Collections.synchronizedMap() fixes this by locking the entire map, it completely destroys performance because threads must wait in line to access it.
ConcurrentHashMap solves this problem by allowing highly concurrent, thread-safe access without locking the whole structure.
Here is exactly how ConcurrentHashMap achieves its thread-safe execution under the hood.

1. The Modern Architecture: Node-Level Locking (Java 8+)

In older versions of Java (Java 7 and below), ConcurrentHashMap used a technique called Segment Locking, which divided the map into 16 distinct chunks (segments).
In modern Java (Java 8 and newer), this design was replaced with a highly optimized, granular system:
• Bucket-Level Control: Instead of locking an entire section of the map, Java now locks only the single bucket head currently being modified.
• Non-Blocking Reads (get): The get(key) operation is completely lock-free. It relies on the volatile keyword applied to the internal node arrays and values. This ensures that any update made by a writing thread is instantly visible to reading threads, allowing infinite numbers of threads to read data simultaneously without ever waiting.
• Synchronized Writing (put): When a thread tries to insert or update an item using put(), it locks only the first node of that specific bucket using a standard synchronized block. Threads updating data in other buckets can run at the exact same time without any delay.

2. Lock-Free Insertions: CAS (Compare-And-Swap)

What happens if a bucket is completely empty, and a thread wants to insert the very first item? Locking the bucket head would be a waste of CPU cycles. Instead, ConcurrentHashMap uses an ultra-fast hardware-level optimization called CAS (Compare-And-Swap).
• The thread inspects the bucket slot using a low-level atomic memory operation.
• It says: "If this bucket slot is currently null, immediately set it to my new Node."
• If another thread snuck in and populated the bucket a fraction of a millisecond earlier, the CAS operation fails safely. The thread then loops back, realizes the bucket is no longer empty, and falls back to a standard synchronized block on that bucket head.

3. Concurrent Resizing (Multi-Threaded Helping)

Resizing a standard map is a heavy O(n) operation. If a single thread had to resize a massive concurrent map alone, it would freeze the application. ConcurrentHashMap introduces a unique system called Concurrent Helping During Transfer:
• Forwarding Nodes (MOVED): When the map reaches its resizing threshold, a transfer process starts. As buckets are successfully migrated to the new, larger array, a special placeholder node called a ForwardingNode (with a hash value of -1 or MOVED) is placed at the head of the old bucket.
• Cooperative Resizing: If Thread A is trying to write to a bucket and hits a ForwardingNode, it realizes a resize is actively happening. Instead of waiting idly, Thread A pauses its write operation and actively helps transfer other buckets to the new array. Once the transfer is completed by the team of threads, Thread A resumes its write operation in the new array.

4. Counter Optimization: LongAdder Style Mechanics

In a highly concurrent app, tracking the total size of the map (map.size()) using a single volatile int count would create a massive performance bottleneck because every single thread would be fighting to update the exact same memory address.
To fix this, ConcurrentHashMap uses an architecture similar to Java's LongAdder:
• It maintains a base count variable along with an internal Counter Cell Array.
• When multiple threads are writing simultaneously, Java distributes them across different cells in the counter array to avoid conflicts.
• When you call map.size(), Java loops through the array, adds up the values of the individual cells, adds the base count, and returns the unified total.

Summary Internal Mechanism Workflow

[ConcurrentHashMap]
│
├──► Reading (get): Always O(1) Lock-Free (Volatile array reads)
│
├──► Writing (put):
│ ├─── Empty Bucket? ──► Use Atomic CAS (Lock-free insertion)
│ ├─── Active Bucket? ─► Synchronize ONLY the first Node of that bucket
│ └─── Hit a 'MOVED' Node? ──► Thread pauses to help resize the map
│
└──► Size Tracking: Counter Cell Array prevents bottlenecking on map.size()
Would you like to see a quick code pattern illustrating how using map.put() inside a multi-threaded loop can still cause race conditions, and how to fix it using atomic methods like computeIfPresent() or merge()?

---

You should add these notes under the topic "Java Constructors" or "Advanced Constructor Design Patterns" within your Object-Oriented Programming (OOP) section.
Here is a clear, structured rewrite of these definitions for your notes, including real-world code use cases.

🔨 Advanced Java Constructor Patterns

Unlike some languages (like C++), Java does not provide default "copy constructors" out of the box. Constructors in Java are highly configurable blocks used to define instantiation strategies and control access boundaries.

👥 1. The Copy Constructor

A copy constructor is a user-defined constructor that initializes a new object by cloning the values of another existing object of the same class.
• Purpose: It gives you a clean way to create a deep copy or a duplicate of an object without affecting the original one.
• Alternative: It is widely considered a cleaner, safer alternative to overriding Java's built-in Object.clone() method.

💻 Code Example:

java
class Book {
String title;
int pages;

    // Standard Constructor
    Book(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    // 🏆 Copy Constructor
    Book(Book otherBook) {
        this.title = otherBook.title; // Copies value from existing instance
        this.pages = otherBook.pages;
    }

}
Use code with caution.

🔒 2. The Private Constructor

A private constructor hides a class's constructor from the outside world by changing its access modifier to private. This completely prevents other classes from calling new MyClass().

When to use it:

• Utility Classes: For classes that only contain static helper methods (like java.util.Collections or java.lang.Math). You don't want anyone creating an object of a math tool.
• Singleton Pattern: When you want to ensure that only one single instance of a class ever exists in memory throughout the entire runtime of the application (e.g., a database connection pool).

💻 Code Example (Singleton Pattern):

java
class DatabaseConnection {
// 1. Create the single instance internally
private static DatabaseConnection instance = new DatabaseConnection();

    // 2. 🏆 Private Constructor blocks 'new' from outside
    private DatabaseConnection() {}

    // 3. Provide a global point of access
    public static DatabaseConnection getInstance() {
        return instance;
    }

}
Use code with caution.
Would you like to see how a copy constructor handles a deep copy vs. a shallow copy when an object contains a reference to another object, like a List or a Custom Class?

---
