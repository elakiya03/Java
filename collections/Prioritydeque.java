package collections;

import java.util.Comparator;
import java.util.PriorityQueue;

class Patient {
    String name;
    int severity; // 1 = High Priority, 3 = Low Priority

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class Prioritydeque {
    public static void main(String[] args) {
        // Create a PriorityQueue sorted by severity (lowest number first)
        PriorityQueue<Patient> q = new PriorityQueue<>(Comparator.comparingInt(p -> p.severity));

        // Add patients arriving out of order
        q.offer(new Patient("elaks (Broken Arm)", 2));
        q.offer(new Patient("kani (Heart Attack)", 1));
        q.offer(new Patient("benny (Mild Fever)", 3));

        System.out.println("--- Treating Patients by Priority ---");

        // poll() automatically pulls index 0 (the highest priority item) in O(log n)
        // time
        while (!q.isEmpty()) {
            System.out.println("Doctor is now treating: " + q.poll());
        }
    }
}
