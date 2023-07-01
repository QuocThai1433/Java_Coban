package com.example.demo.student;

import com.example.demo.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentDao {
    private static StudentDao instance = null;

    public static StudentDao getInstance() {
        if (instance == null) {
            instance = new StudentDao();
        }
        return instance;
    }

    public List<Student> getList() {
        List<Student> studentList = new ArrayList<>();
        Connection connection = ConnectDB.getConnection();
        if (connection == null) {
            return studentList;
        }
        try {
            String query = "select * from student";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                studentList.add(
                        StudentMapper.toEntity(rs)
                );
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }

    public List<Student> getListCount(int ids) {
        List<Student> students = new ArrayList<>();
        Connection connection = ConnectDB.getConnection();
        if (connection == null) {
            return students;
        }
        try {
            String query = "SELECT * FROM ttsv ORDER BY id ASC LIMIT ? ";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, ids);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                students.add(
                        StudentMapper.toEntity(rs)
                );
            }
            rs.close();
            ps.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public Student getById(int id) {
        Student student = null;
        Connection connection = ConnectDB.getConnection();
        if (connection == null) {
            return student;
        }
        try {
            String query = "select * from student where id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                student = StudentMapper.toEntity(rs);
            }
            ps.close();
            rs.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    public int create(Student student) {
        int result = 0;
        Connection connection = ConnectDB.getConnection();
        if (connection == null) {
            return result;
        }
        try {
            String query = "INSERT INTO ttsv VALUE(?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getAge());
            ps.setString(4, student.getAddress());
            result = ps.executeUpdate();
            ps.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int update(int c) {
        int result = 0;
        Connection connection = ConnectDB.getConnection();
        if (connection == null) {
            return result;
        }
        Scanner scanner = new Scanner(System.in);
        try {
            switch (c) {
                case 1: {
                    String query1 = "UPDATE ttsv  SET name = ? WHERE ID = ?";
                    PreparedStatement ps1 = connection.prepareStatement(query1);
                    System.out.print("ID = ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    ps1.setInt(2, id);
                    System.out.print("Name = ");
                    String name = scanner.nextLine();
                    ps1.setString(1, name);
                    result = ps1.executeUpdate();
                    ps1.close();
                    break;
                }
                case 2: {
                    String query2 = "UPDATE ttsv  SET age = ? WHERE ID = ?";
                    PreparedStatement ps2 = connection.prepareStatement(query2);
                    System.out.print("ID = ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    ps2.setInt(2, id);
                    System.out.print("Age = ");
                    int age = scanner.nextInt();
                    ps2.setInt(1, age);
                    result = ps2.executeUpdate();
                    ps2.close();
                    break;
                }
                case 3: {
                    String query3 = "UPDATE ttsv  SET address= ? WHERE ID = ?";
                    PreparedStatement ps3 = connection.prepareStatement(query3);
                    System.out.print("ID = ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    ps3.setInt(2, id);
                    System.out.print("Address =");
                    String address = scanner.nextLine();
                    ps3.setString(1, address);
                    result = ps3.executeUpdate();
                    ps3.close();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public int delete(int id) {

        int kq = 0;
//        String query = " DELETE FROM ttsv WHERE ID = ?;";
//        try {
//            PreparedStatement ps = connection.prepareStatement(query);
//            ps.setInt(1, id);
//            kq = ps.executeUpdate();
//            ps.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
        return kq;
    }


    public List<Student> getListByClasses(int ids) {
        List<Student> studentList = new ArrayList<>();

        String query = "SELECT * FROM ttsv t, classes c where c.id= t.classesId and t.classesId=?";
        try {
//            PreparedStatement ps = connection.prepareStatement(query);
//            ps.setInt(1, ids);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                int classesId = rs.getInt("classesId");
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                int age = rs.getInt("age");
//                String address = rs.getString("address");
//                Student student = new Student(id, name, age, address, classesId);
//                studentList.add(student);
//            }
//            rs.close();
//            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }

}
