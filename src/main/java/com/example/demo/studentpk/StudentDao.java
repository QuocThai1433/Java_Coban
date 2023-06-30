package com.example.demo.studentpk;

import com.example.demo.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class StudentDao {
    Connection connection = ConnectDB.getConnection();

    public int create(Student student) {
        int kq = 0;
        String query = "INSERT INTO student VALUE(?,?,?,?); ";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getAge());
            ps.setString(4, student.getAddress());
            kq = ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }


    public List<Student> getList() {
        List<Student> studentList = new ArrayList<>();
        String query = "select * from student";
        try {

            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                int classesId = rs.getInt("classesId");
                Student student = new Student(id, name, age, address, classesId);
                studentList.add(student);
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
        String query = "SELECT * FROM student ORDER BY id ASC LIMIT ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, ids);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                int classesId = rs.getInt("classesId");
                Student student = new Student(id, name, age, address, classesId);
                students.add(student);

            }
            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public Student getById(int aid) {
        String query = "select * from student where id =?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, aid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                int classesId = rs.getInt("classesId");
                Student student = new Student(id, name, age, address, classesId);
                return student;
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public int update(Student student) {
        int kq = 0;

        try {
            String query = "UPDATE student  SET Name =? , Age=?, Address=? WHERE ID = ? ";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(4, student.getId());
            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getAddress());
            kq = ps.executeUpdate();
            ps.close();

        }
     catch(
    Exception e)

    {
        e.printStackTrace();
    }
        return kq;
}


    public int delete(int id) {

        int kq = 0;
        String query = " DELETE FROM student WHERE ID = ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            kq = ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return kq;
    }


    public List<Student> getListByClasses(int ids) {
        List<Student> studentList = new ArrayList<>();

        String query = "SELECT * FROM student t, classes c where c.id= t.classesId and t.classesId=?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, ids);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int classesId = rs.getInt("classesId");
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                Student student = new Student(id, name, age, address, classesId);
                studentList.add(student);
            }
            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }


}
