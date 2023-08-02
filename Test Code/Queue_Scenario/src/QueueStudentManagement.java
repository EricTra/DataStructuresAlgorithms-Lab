import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueStudentManagement {
    public static void main(String[] args) {
        Queue<Student> studentQueue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Student Management System");
            System.out.println("1. Enqueue Student");
            System.out.println("2. Dequeue Student");
            System.out.println("3. Peek at Front Student");
            System.out.println("4. Total Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    scanner.nextLine(); // Consume newline
                    String name = scanner.nextLine();
                    System.out.print("Enter student age: ");
                    int age = scanner.nextInt();
                    studentQueue.offer(new Student(name, age));
                    System.out.println("Student enqueued successfully!");
                    break;

                case 2:
                    Student dequeuedStudent = studentQueue.poll();
                    if (dequeuedStudent != null) {
                        System.out.println("Dequeued student: " + dequeuedStudent.getName());
                    } else {
                        System.out.println("Queue is empty.");
                    }
                    break;

                case 3:
                    Student frontStudent = studentQueue.peek();
                    if (frontStudent != null) {
                        System.out.println("Front student: " + frontStudent.getName());
                    } else {
                        System.out.println("Queue is empty.");
                    }
                    break;

                case 4:
                    System.out.println("Total number of students in queue: " + studentQueue.size());
                    break;

                case 5:
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
