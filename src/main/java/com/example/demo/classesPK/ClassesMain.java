package com.example.demo.classesPK;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class ClassesMain {
    static ClasssesDao classsesDao = new ClasssesDao();
    static Scanner scanner = new Scanner(System.in);

    public static Classes inputClasses() {
        System.out.println("Input Id:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Input name");
        String name = scanner.nextLine();
        return new Classes(id, name);

    }

    public static void addClasses() {
        Classes classes = inputClasses();
        classsesDao.create(classes);
        System.out.println("Add Classes Successful");
    }

    public static void updateClasses() {
        Classes classes = inputClasses();
        classsesDao.update(classes);
        System.out.println("Update Classes Successful");
    }

    public static void delete() {
        System.out.println("Input id Student:");
        int id = scanner.nextInt();
        classsesDao.delete(id);
        System.out.println("Delete Classes Successful");
    }

    public static void getList (){
        List<Classes> classes = classsesDao.getList();
        System.out.println(classes.toString());
    }
    public static void menu() {
        System.out.println("1: Add Classes");
        System.out.println("2: Update Classes");
        System.out.println("3: Delete Classes");
        System.out.println("4: GetList Classes");
    }

    public static void main(String arg[]) {
        System.out.println("");
        menu();
        int chon = scanner.nextInt();

        switch (chon) {
            case 1:
                addClasses();
                break;
            case 2:
                updateClasses();
                break;
            case 3:
                delete();
                break;
            case 4:
                getList();
                break;
        }
    }

}
