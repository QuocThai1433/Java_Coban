package com.example.demo.studentPK;

import java.util.List;
import java.util.Scanner;

public class StudentMain {
    static Scanner scanner = new Scanner(System.in);
    static StudentDao sinhVienDao = new StudentDao();

    public static Student inputSV() {
        System.out.println("Input id:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Input name: ");
        String name = scanner.nextLine();
        System.out.println("Input age");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Input address");
        String address = scanner.nextLine();
        System.out.println("Input classesId");
        int classesId = scanner.nextInt();
        return new Student(id, name, age, address,classesId);
    }

    public static boolean checkExistId(int id) {
        var student = sinhVienDao.getById(id);
        if (student != null)
            return true;
        return false;
    }

    public static boolean checkNumber(int id) {

        var student = sinhVienDao.getById(id);
        if (student != null)
            return true;
        return false;
    }


    public static void Add() {
        var student = inputSV();
        //checkNumber(student.);
        sinhVienDao.create(student);
        System.out.println("Create successful");
    }

    public static void update() {
        System.out.println("Your Select: ");
        System.out.println("1 name:");
        System.out.println("2 age:");
        System.out.println("3 address:");
        int id = scanner.nextInt();
        sinhVienDao.update(id);

    }

    public static void delete() {
        System.out.println("Input id Student:");
        int id = scanner.nextInt();
        sinhVienDao.delete(id);
        System.out.println("Delete successful");
    }

    public static void getById() {
        System.out.println("Input id Student: ");
        int id = scanner.nextInt();
        Student student = sinhVienDao.getById(id);
        System.out.println(student.toString());

    }

    public static void menu() {
        System.out.println("Menu");
        System.out.println("1.GetList");
        System.out.println("2.GetById");
        System.out.println("3.GetListCount");
        System.out.println("4.Add student");
        System.out.println("5.Update student");
        System.out.println("6.Delete Student");

//        System.out.println("Menu");
//        System.out.println("Menu");


    }

    public static void getList() {
        List<Student> students = sinhVienDao.getList();
        System.out.println(students.toString());
    }

    public static void getListCout() {
        System.out.println("Input list SV: ");
        int list = scanner.nextInt();
        List<Student> student = sinhVienDao.getListCount(list);
        System.out.println(student.toString());
    }

    public static void getListByClasses() {
        System.out.println("Input list SV: ");
        int list = scanner.nextInt();
        List<Student> student = sinhVienDao.getListByClasses(list);
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
                Add();
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
            case 8:
            default:
        }

    }


}
