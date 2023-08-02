import java.util.ArrayList;
import java.util.Scanner;



public class StudentManagement {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Remove Student");
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
                    students.add(new Student(name, age));
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    System.out.println("Student List:");
                    for (Student student : students) {
                        System.out.println("Name: " + student.getName() + ", Age: " + student.getAge());
                    }
                    break;

                case 3:
                    System.out.print("Enter index of student to remove: ");
                    int index = scanner.nextInt();
                    if (index >= 0 && index < students.size()) {
                        Student removedStudent = students.remove(index);
                        System.out.println("Removed student: " + removedStudent.getName());
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;

                case 4:
                    System.out.println("Total number of students: " + students.size());
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
