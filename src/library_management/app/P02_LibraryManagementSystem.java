package library_management.app;

import library_management.model.Book;
import library_management.service.LibraryService;

import java.util.Scanner;

public class P02_LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LibraryService service = new LibraryService();

        System.out.println("=== Library Management System ===");

        while (true) {
            System.out.println("\n1- Add Book");
            System.out.println("2- List Books");
            System.out.println("3- Search Book by ID");
            System.out.println("4- Borrow Book");
            System.out.println("5- Return Book");
            System.out.println("6- Delete Book");
            System.out.println("7- Exit");

            System.out.print("Choose: ");
            int choice = input.nextInt();
            input.nextLine(); // clear buffer

            if (choice == 1) {
                System.out.print("Enter Book ID: ");
                int id = input.nextInt();
                input.nextLine(); // clear buffer

                if (service.existsById(id)) {
                    System.out.println("ERROR! This ID already exists!");
                    continue;
                }

                System.out.print("Enter title: ");
                String title = input.nextLine().trim();

                System.out.print("Enter author: ");
                String author = input.nextLine().trim();

                if (title.isEmpty() || author.isEmpty()) {
                    System.out.println("ERROR! Title/author cannot be empty!");
                    continue;
                }

                service.addBook(new Book(id, title, author));
                System.out.println("Book added!");

            } else if (choice == 2) {
                service.listBooks();

            } else if (choice == 3) {
                System.out.print("Enter ID to search: ");
                int id = input.nextInt();

                Book b = service.findById(id);
                if (b == null) {
                    System.out.println("Book not found!");
                } else {
                    System.out.println("Found! " + b);
                }

            } else if (choice == 4) {
                System.out.print("Enter ID to borrow: ");
                int id = input.nextInt();

                System.out.println(service.borrowBook(id));

            } else if (choice == 5) {
                System.out.print("Enter ID to return: ");
                int id = input.nextInt();

                System.out.println(service.returnBook(id));

            } else if (choice == 6) {
                System.out.print("Enter ID to delete: ");
                int id = input.nextInt();

                if (service.deleteById(id)) {
                    System.out.println("Book deleted!");
                } else {
                    System.out.println("Book not found!");
                }

            } else if (choice == 7) {
                System.out.println("Goodbye...");
                break;

            } else {
                System.out.println("ERROR! Invalid choice!");
            }
        }
    }
}
