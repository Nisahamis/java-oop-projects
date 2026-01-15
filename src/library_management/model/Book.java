package library_management.model;

public class Book {
    private int id;
    private String title;
    private String author;
    private boolean borrowed; // false = available, true = borrowed

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.borrowed = false; // newly added book is available
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void borrowBook() {
        this.borrowed = true;
    }

    public void returnBook() {
        this.borrowed = false;
    }

    @Override
    public String toString() {
        String status = borrowed ? "Borrowed!" : "Available!";
        return "ID: " + id + " | Title: " + title + " | Author: " + author + " | Status: " + status;
    }
}
