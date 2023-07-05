package com.example.demo.classes;

import java.util.List;
import java.util.Scanner;

public class ClassesMain {
    static ClassesDao classesDao = new ClassesDao();
    static Scanner scanner = new Scanner(System.in);


    public static void menu() {
        System.out.println("1: Add Classes");
        System.out.println("2: Update Classes");
        System.out.println("3: Delete Classes");
        System.out.println("4: GetList Classes");
    }

    public static void main(String []arg) {
        menu();
        int chon = scanner.nextInt();

        switch (chon) {

            case 5:
            default:
        }
    }

}
