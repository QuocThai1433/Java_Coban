package com.example.demo.studentpk;

import java.sql.PreparedStatement;
import java.util.Scanner;

public class StudentService {
    Scanner scanner = new Scanner(System.in);

    public Student updateChoose(Student student, int choose) {
      do {
          switch (choose) {
              case 1: {

                  System.out.print("Name = ");
                  String name = scanner.nextLine();
                  student.setName(name);
                  break;
              }
              case 2: {

                  System.out.print("Age = ");
                  String age = scanner.nextLine();
                  student.setName(age);
                  break;
              }
              case 3: {

                  System.out.print("Address = ");
                  String address = scanner.nextLine();
                  student.setName(address);
                  break;
              }
              case 4:
              default:
          }
      }while (choose >= 1 && choose<=4);
        return student;

    }
}
