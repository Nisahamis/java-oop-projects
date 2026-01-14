package student_management.app;

import student_management.model.Student;
import student_management.service.StudentService;

import java.util.Scanner;

public class P01_StudentManagementSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentService service = new StudentService();

        System.out.println("=== Student Management System ===");

        while (true) {
            System.out.println("\n1- Add Student");
            System.out.println("2- List Students");
            System.out.println("3- Search Student by ID");
            System.out.println("4- Delete Student by ID");
            System.out.println("5- Update Student");
            System.out.println("6- Exit");

            System.out.print("Choose: ");
            int choice = input.nextInt();

            if (choice == 1) {
                System.out.print("Enter ID: ");
                int id = input.nextInt();
                input.nextLine(); // clear buffer

                if (service.existsById(id)) {
                    System.out.println("ERROR! This ID already exists!");
                    continue;
                }

                System.out.print("Enter name: ");
                String name = input.nextLine();

                System.out.print("Enter GPA (0.0 - 4.0): ");
                double gpa = input.nextDouble();

                if (gpa < 0 || gpa > 4) {
                    System.out.println("ERROR! GPA must be between 0.0 and 4.0");
                    continue;
                }

                service.addStudent(new Student(id, name, gpa));
                System.out.println("Student added!");

            } else if (choice == 2) {
                service.listStudents();

            } else if (choice == 3) {
                System.out.print("Enter ID to search: ");
                int id = input.nextInt();

                Student s = service.findById(id);
                if (s == null) {
                    System.out.println("Student not found!");
                } else {
                    System.out.println("Found! " + s);
                }

            } else if (choice == 4) {
                System.out.print("Enter ID to delete: ");
                int id = input.nextInt();

                if (service.deleteById(id)) {
                    System.out.println("Student deleted!");
                } else {
                    System.out.println("Student not found!");
                }

            } else if (choice == 5) {
                System.out.print("Enter ID to update: ");
                int id = input.nextInt();
                input.nextLine(); // clear buffer

                if (!service.existsById(id)) {
                    System.out.println("Student not found!");
                    continue;
                }

                System.out.print("Enter new name: ");
                String newName = input.nextLine();

                System.out.print("Enter new GPA (0.0 - 4.0): ");
                double newGpa = input.nextDouble();

                if (newGpa < 0 || newGpa > 4) {
                    System.out.println("ERROR! GPA must be between 0.0 and 4.0");
                    continue;
                }

                if (service.updateStudent(id, newName, newGpa)) {
                    System.out.println("Student updated!");
                } else {
                    System.out.println("Student not found!");
                }

            } else if (choice == 6) {
                System.out.println("Goodbye...");
                break;

            } else {
                System.out.println("ERROR! Invalid choice!");
            }
        }
    }
}
