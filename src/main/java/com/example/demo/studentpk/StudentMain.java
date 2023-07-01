package com.example.demo.studentpk;

import java.util.List;
import java.util.Scanner;

public class StudentMain {
    static Scanner scanner = new Scanner(System.in);
    static StudentDao studentDao = new StudentDao();

    static StudentService studentService = new StudentService();



    public static void checkCharacters(String name){
        do
        {
            if(name.length()>10) {
                System.out.println("Name cannot exceed 10 characters!! Please input again: ");
                name = scanner.nextLine();
            }
        }while (name.length()>10);

    }


    public static void checkAge(int age){
        do {
            if(age>=200)
            {
                System.out.println("Age not more than 200!! Please input again:");
                age = scanner.nextInt();
                scanner.nextLine();
            }


        }while (age>=200);
    }


    public static Student inputSV() {
        System.out.println("Input id:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Input name: ");
        String name = scanner.nextLine();
        checkCharacters(name);

        System.out.println("Input age");
        int age = scanner.nextInt();
        scanner.nextLine();
        checkAge(age);
        System.out.println("Input address");
        String address = scanner.nextLine();
        System.out.println("Input mark");
        float mark = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Input classesId");
        int classesId = scanner.nextInt();

        return new Student(id, name, age, address,mark, classesId);
    }

    public static boolean checkExistId(int id) {
        var student = studentDao.getById(id);
        if (student != null)
            return true;
        return false;
    }

    public static boolean checkNumber(int id) {

        var student = studentDao.getById(id);
        if (student != null)
            return true;
        return false;
    }


    public static void add() {
        Student student = inputSV();

        studentDao.create(student);
        System.out.println("Create successful");
    }

    public static void update() {
        System.out.println("Input id Student: ");
        int id = scanner.nextInt();
        Student student = studentDao.getById(id);
        System.out.println("Your Select: ");
        System.out.println("1 name:");
        System.out.println("2 age:");
        System.out.println("3 address:");
        int choose = scanner.nextInt();
        student = studentService.updateChoose(student, choose); // chỗ này truyền j astud e/// e cần gì thì truyền dô
        studentDao.update(student);
        // 1. GetById mình sẽ có một thằng student
        // 2. Chọn thuộc tính ào sửa thì Student set thuc tính đó, set xong hết rồi thì gọi hàm dưới
        // có thêm option cho người dùng muốn sửa nhiều thuộc tính
        // 3. Call Dao for Update
    }

    public static void delete() {
        System.out.println("Input id Student:");
        int id = scanner.nextInt();
        studentDao.delete(id);
        System.out.println("Delete successful");
    }

    public static void getById() {
        System.out.println("Input id Student: ");
        int id = scanner.nextInt();
        Student student = studentDao.getById(id);
        System.out.println(student.toString1());

    }

    public static void getMaxMark() {
        System.out.println("Input Class: ");
        int classesid = scanner.nextInt();
        Student student = studentDao.getMaxMark(classesid);
        System.out.println(student.toString1());

    }

    public static void menu() {
        System.out.println("Menu");
        System.out.println("1.GetList");
        System.out.println("2.GetById");
        System.out.println("3.GetListCount");
        System.out.println("4.Add student");
        System.out.println("5.Update student");
        System.out.println("6.Delete Student");
        System.out.println("7.Get List Count Student");
        System.out.println("8.Get Student Max Mark Class");

    }

    public static void getList() {
        List<Student> students = studentDao.getList();
        System.out.println(students.toString());
    }

    public static void getListCout() {
        System.out.println("Input list SV: ");
        int list = scanner.nextInt();
        List<Student> student = studentDao.getListCount(list);
        System.out.println(student.toString());
    }

    public static void getListByClasses() {
        System.out.println("Input list SV: ");
        int list = scanner.nextInt();
        List<Student> student = studentDao.getListByClasses(list);
        System.out.println(student.toString());
    }


    public static void main(String[] args) {
        menu();
        int select = 0;
        select = scanner.nextInt();
        switch (select) {
            case 1:
                System.out.println("GetList");
                getList();
                break;
            case 2:
                System.out.println("GetById");
                getById();
                break;
            case 3:
                System.out.println("Get list student by quantity");
                getListCout();
                break;
            case 4:
                System.out.println("Add Student");
                add();
                break;
            case 5:
                System.out.println("Update Student ");
                update();
                break;
            case 6:
                System.out.println("Delete Student");
                delete();
                break;
            case 7:
                System.out.println("Get List Student By Class");
                getListByClasses();
                break;
            case 8:
                System.out.println("Get Student Max Mark");
                getMaxMark();
                break;
            case 9:
            default:
        }

    }


}
