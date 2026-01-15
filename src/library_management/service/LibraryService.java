package library_management.service;

import library_management.model.Book;

import java.util.ArrayList;

public class LibraryService {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books found.");
            return;
        }

        for (Book b : books) {
            System.out.println(b);
        }
    }

    public Book findById(int id) {
        for (Book b : books) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    public boolean existsById(int id) {
        return findById(id) != null;
    }

    public boolean deleteById(int id) {
        Book b = findById(id);
        if (b == null) return false;
        books.remove(b);
        return true;
    }

    public String borrowBook(int id) {
        Book b = findById(id);
        if (b == null) return "Book not found!";

        if (b.isBorrowed()) {
            return "This book is already borrowed!";
        }

        b.borrowBook();
        return "Book borrowed!";
    }

    public String returnBook(int id) {
        Book b = findById(id);
        if (b == null) return "Book not found!";

        if (!b.isBorrowed()) {
            return "This book is already available!";
        }

        b.returnBook();
        return "Book returned!";
    }
}
