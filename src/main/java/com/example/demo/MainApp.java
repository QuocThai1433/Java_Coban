package com.example.demo;

import com.example.demo.student.Student;
import com.example.demo.student.StudentDao;

import java.util.List;

public class MainApp {
    public static void mainMenu() {
        System.out.println("Welcome to your school");
        System.out.println("1. List all students");
        System.out.println("2. Find student by id");
        System.out.println("3. Total count");
        System.out.println("4. Add student");
        System.out.println("5. Edit student");
        System.out.println("6. Delete Student");
    }

    public static void main(String[] args) {
        while (true) {
            mainMenu();
            System.out.print("Enter your choose: ");
            int choose = InputUtils.inputNumber();
            switch (choose) {
                case 1:
                    listAllStudents();
                    break;
                case 2:
                    findStudent();
                    break;
                case 3:
                    totalStudent();
                    break;
                case 4:
                    addStudent();
                    break;
                case 5:
                    updateStudent();
                    break;
                case 6:
                    deleteStudent();
                    break;
                case 0:
                    System.out.println("Have a good day !!!");
                    return;
                default:
                    break;
            }
        }
    }

    private static void deleteStudent() {
    }

    private static void updateStudent() {
    }

    private static void addStudent() {
    }

    private static void totalStudent() {
    }

    private static void findStudent() {
        System.out.print("Enter ID: ");
        int id = InputUtils.inputNumber();
        Student student = StudentDao.getInstance().getById(id);
        if (student == null) {
            System.err.println("Student not found by id = " + id);
            return;
        }
        System.err.println(student);
    }

    private static void listAllStudents() {
        List<Student> students = StudentDao.getInstance().getList();
        students.forEach(item -> System.err.println(item.toString()));
    }
}
