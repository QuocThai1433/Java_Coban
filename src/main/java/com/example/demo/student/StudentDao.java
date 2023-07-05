package com.example.demo.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentDao {
    Connection connection = ConnectDB.getConnection();

    public Student listStudent(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        int age = rs.getInt("age");
        String address = rs.getString("address");
        float score = rs.getFloat("score");
        int classesId = rs.getInt("classesId");

        return new Student(id, name, age, address, score, classesId);

    }

    public int create(Student student) {
        int kq = 0;
        String query = "insert into student value(?,?,?,?,?,?); ";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getAge());
            ps.setFloat(4, student.getScore());
            ps.setString(5, student.getAddress());
            ps.setInt(6, student.getClassesId());
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
                studentList.add(listStudent(rs));
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
        String query = "select * from student order by id asc limit ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, ids);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                students.add(listStudent(rs));
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
        Student student = null;
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, aid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                student = listStudent(rs);
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    public int update(Student student) {
        int kq = 0;
        try {
            String query = "UPDATE student  set Name =? , age=?, address=?, score=? where id = ? ";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(5, student.getId());
            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setFloat(3, student.getScore());
            ps.setString(4, student.getAddress());
            kq = ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }


    public int delete(int id) {

        int kq = 0;
        String query = " delete from student where id = ?";
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

        String query = "select * from student t, classes c where c.id= t.classesId and t.classesId=?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, ids);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                studentList.add(listStudent(rs));
            }
            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }


    public Student getMaxScoreStudent(int classesid) {
        Student student = new Student();
        try {
            String query = "select *  from student where classesId = ? order by score desc limit 1";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, classesid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                student = listStudent(rs);
            }


        } catch (Exception e) {
            {
                e.printStackTrace();
            }
        }
        return student;
    }


}
