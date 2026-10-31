package streams;

import java.util.ArrayList;
import java.util.List;

class Employee {
    public String name;
    public String dept;
    public double salary;

    Employee(String name, String dept, double salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

}

public class Main {
    public static void main(String[] args) {

        List<Employee> l = new ArrayList<>();
        l.add(new Employee("viru", "cric", 150.89));
        l.add(new Employee("elaks", "it", 71.89));
        l.add(new Employee("sai", "act", 50.89));
        l.add(new Employee("aish", "act", 150.89));
        l.add(new Employee("gill", "it", 180.89));

        double highestSalary = l.stream()
                .filter(e -> e.dept.equalsIgnoreCase("it")) // Safe String comparison
                .mapToDouble(e -> e.salary) // Converts to a stream of doubles
                .max() // Terminal operation (returns OptionalDouble)
                .orElse(0.0); // Safe fallback if no IT employees exist

        System.out.println("Highest Salary in IT: " + highestSalary);
    }

}

// Imagine you have an Employee class with properties: String name, String
// department, and double salary.
// Given a List<Employee>, write a single Stream pipeline that finds the highest
// salary among employees belonging to the "IT" department.
// • Hint: Combine .filter(), .mapToDouble(), and .max().
