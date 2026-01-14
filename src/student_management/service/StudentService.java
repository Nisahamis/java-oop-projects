package student_management.service;

import student_management.model.Student;

import java.util.ArrayList;

public class StudentService {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student s : students) {
            System.out.println(s);
        }
    }

    public Student findById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public boolean existsById(int id) {
        return findById(id) != null;
    }

    public boolean deleteById(int id) {
        Student s = findById(id);
        if (s == null) return false;
        students.remove(s);
        return true;
    }

    public boolean updateStudent(int id, String newName, double newGpa) {
        Student s = findById(id);
        if (s == null) return false;

        s.setName(newName);
        s.setGpa(newGpa);
        return true;
    }
}
