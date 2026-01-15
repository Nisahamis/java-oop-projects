# Java OOP Projects 

This repository contains my **Object-Oriented Programming (OOP)** practice projects in Java.  
The focus is on clean structure, OOP principles, and building small systems with real-world logic.

## Topics Covered
- OOP Fundamentals (Class, Object, Encapsulation)
- Separation of concerns (model / service / app layers)
- ArrayList-based data management
- Input validation & menu-driven console apps
- Git/GitHub workflow (commit, push)

---

## Projects

### P01 - Student Management System
A console-based application to manage students.

**Features:**
- Add student (ID, name, GPA)
- List all students
- Search student by ID
- Update student info
- Delete student
- Prevent duplicate IDs

Package:
- `student_management`

Run:
- `student_management.app.P01_StudentManagementSystem`

---

### P02 - Library Management System
A console-based library system to manage books and borrowing operations.

**Features:**
- Add book (ID, title, author)
- List all books
- Search book by ID
- Borrow book / Return book
- Delete book
- Prevent duplicate IDs

Package:
- `library_management`

Run:
- `library_management.app.P02_LibraryManagementSystem`

---

## How to Run
You can run the projects using:
- IntelliJ IDEA (recommended)
- VS Code
- Any Java-supported IDE

Each project has its own `main()` method in the `app` package.

---

## Project Structure
```text
src/
  student_management/
    model/
    service/
    app/
  library_management/
    model/
    service/
    app/
