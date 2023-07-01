package com.example.demo.studentpk;

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
        float mark = rs.getFloat("mark");
        int classesId = rs.getInt("classesId");

        return new Student(id, name, age, address, mark, classesId);

    }

    public int create(Student student) {
        int kq = 0;
        String query = "INSERT INTO student VALUE(?,?,?,?,?,?); ";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getAge());
            ps.setFloat(4, student.getMark());
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
        String query = "SELECT * FROM student ORDER BY id ASC LIMIT ? ";
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
            String query = "UPDATE student  SET Name =? , Age=?, Address=?, Mark=? WHERE ID = ? ";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(5, student.getId());
            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setFloat(3, student.getMark());
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
                studentList.add(listStudent(rs));
            }
            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }


    public Student getMaxMark(int classesid) {
        Student student= new Student();
        try {
            String query= "select *  from student where classesId = ? order by mark desc limit 1";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1,classesid);
            ResultSet rs = ps.executeQuery();
            while ( rs.next())
            {
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
