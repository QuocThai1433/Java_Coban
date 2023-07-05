package com.example.demo.student;

import com.example.demo.classes.Classes;
import com.example.demo.classes.ClassesDao;

import java.util.List;
import java.util.Scanner;

public class StudentMain {
    static Scanner scanner = new Scanner(System.in);
    static StudentDao studentDao = new StudentDao();
    static ClassesDao classesDao = new ClassesDao();

    static StudentService studentService = new StudentService();



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
        classesDao.create(classes);
        System.out.println("Add Classes Successful");
    }

    public static void updateClasses() {
        Classes classes = inputClasses();
        classesDao.update(classes);
        System.out.println("Update Classes Successful");
    }

    public static void deleteclasses() {
        System.out.println("Input id Student:");
        int id = scanner.nextInt();
        classesDao.delete(id);
        System.out.println("Delete Classes Successful");
    }

    public static void getListClasses (){
        List<Classes> classes = classesDao.getList();
        System.out.println(classes.toString());
    }
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


    public static Student inputStudent() {
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
        System.out.println("Input score");
        float score = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Input classesId");
        int classesId = scanner.nextInt();

        return new Student(id, name, age, address,score, classesId);
    }



    public static void addStudent() {
        Student student = inputStudent();

        studentDao.create(student);
        System.out.println("Create successful");
    }

    public static void updateStudent() {
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

    public static void deleteStudent() {
        System.out.println("Input id Student:");
        int id = scanner.nextInt();
        studentDao.delete(id);
        System.out.println("Delete successful");
    }

    public static void getByIdStudent() {
        System.out.println("Input id Student: ");
        int id = scanner.nextInt();
        Student student = studentDao.getById(id);
        System.out.println(student.toString1());

    }

    public static void getMaxScoreStudent() {
        System.out.println("Input Class: ");
        int classesid = scanner.nextInt();
        Student student = studentDao.getMaxScoreStudent(classesid);
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
        System.out.println("8.Get Student Max Score Class");
        System.out.println("9: Add Classes");
        System.out.println("10: Update Classes");
        System.out.println("11: Delete Classes");
        System.out.println("12: GetList Classes");

    }

    public static void getListStudent() {
        List<Student> students = studentDao.getList();
        System.out.println(students.toString());
    }

    public static void getListCoutStudent() {
        System.out.println("Input list SV: ");
        int list = scanner.nextInt();
        List<Student> student = studentDao.getListCount(list);
        System.out.println(student.toString());
    }

    public static void getListStudentByClasses() {
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
                System.out.println("GetListStudent");
                getListStudent();
                break;
            case 2:
                System.out.println("GetById Student");
                getByIdStudent();
                break;
            case 3:
                System.out.println("Get list student by quantity");
                getListCoutStudent();
                break;
            case 4:
                System.out.println("Add Student");
                addStudent();
                break;
            case 5:
                System.out.println("Update Student ");
                updateStudent();
                break;
            case 6:
                System.out.println("Delete Student");
                deleteStudent();
                break;
            case 7:
                System.out.println("Get List Student By Class");
                getListStudentByClasses();
                break;
            case 8:
                System.out.println("Get Student Max Score");
                getMaxScoreStudent();
                break;
            case 9:
                addClasses();
                break;
            case 10:
                updateClasses();
                break;
            case 11:
                deleteclasses();
                break;
            case 12:
                getListClasses();
                break;
            case 13:
            default:
        }

    }


}
