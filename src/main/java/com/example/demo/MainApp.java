package com.example.demo;

import com.example.demo.student.Student;
import com.example.demo.student.StudentDao;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String ENTER_ID = "Enter ID: ";
    private static final String STUDENT_NOT_FOUND_BY_ID = "Student not found by id = ";

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
                    listStudentLimit();
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

    public static void mainMenu() {
        System.out.println("Welcome to your school");
        System.out.println("1. List all students");
        System.out.println("2. Find student by id");
        System.out.println("3. List students by limit");
        System.out.println("4. Add student");
        System.out.println("5. Edit student");
        System.out.println("6. Delete Student");
        System.out.println("Type \"0\" to exit");
    }

    private static void deleteStudent() {
        System.out.print(ENTER_ID);
        int id = InputUtils.inputNumber();
        Student student = StudentDao.getInstance().getById(id);
        if (student == null) {
            PrintUtils.errorMessage(STUDENT_NOT_FOUND_BY_ID + id);
            return;
        }
        StudentDao.getInstance().delete(id);
        PrintUtils.infoMessage("Student \"" + student.getName() + "\" is deleted");
    }

    private static void updateStudent() {
        System.out.print(ENTER_ID);
        int id = InputUtils.inputNumber();
        Student student = StudentDao.getInstance().getById(id);
        if (student == null) {
            PrintUtils.infoMessage(STUDENT_NOT_FOUND_BY_ID + id);
            return;
        }
        PrintUtils.infoMessage("Student: " + student);
        String message = "Change %s to: ";
        boolean isExited = false;
        while (!isExited){
            updateStudentMenu();
            System.out.print("Enter your choose: ");
            int choose = InputUtils.inputNumber();
            switch (choose) {
                case 1:
                    System.out.printf(message, student.getName());
                    student.setName(scanner.nextLine());
                    break;
                case 2:
                    System.out.printf(message, student.getAge().toString());
                    student.setAge(InputUtils.inputNumber());
                    break;
                case 3:
                    System.out.printf(message, student.getAddress());
                    student.setAddress(scanner.nextLine());
                    break;
                case 0:
                    PrintUtils.infoMessage("Cancel successfully");
                    isExited = true;
                    break;
                case 9:
                    int result = StudentDao.getInstance().update(id, student);
                    if (result == 0) {
                        PrintUtils.errorMessage("Update fail");
                    } else {
                        PrintUtils.infoMessage("Update successfully");
                    }
                    isExited = true;
                    break;
                default:
                    break;
            }
        }
    }

    private static void updateStudentMenu() {
        System.out.println("1. Name");
        System.out.println("2. Age");
        System.out.println("3. Address");
        System.out.println("Type \"9\" to save change and exit");
        System.out.println("Type \"0\" to cancel");
    }

    private static void addStudent() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = InputUtils.inputNumber();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        Student student = new Student(name, age, address);
        StudentDao.getInstance().create(student);
    }

    private static void listStudentLimit() {
        List<Student> students = StudentDao.getInstance().getListByLimit(20);
        students.forEach(item -> System.err.println(item.toString()));
    }

    private static void findStudent() {
        System.out.print(ENTER_ID);
        int id = InputUtils.inputNumber();
        Student student = StudentDao.getInstance().getById(id);
        if (student == null) {
            PrintUtils.errorMessage(STUDENT_NOT_FOUND_BY_ID + id);
            return;
        }
        PrintUtils.errorMessage(student.toString());
    }

    private static void listAllStudents() {
        List<Student> students = StudentDao.getInstance().getList();
        students.forEach(student -> PrintUtils.infoMessage(student.toString()));
    }

}
