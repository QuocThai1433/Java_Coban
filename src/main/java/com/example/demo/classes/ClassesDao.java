package com.example.demo.classes;

import com.example.demo.student.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClassesDao {
    Connection connection = ConnectDB.getConnection();

    public int create(Classes classes) {
        int result = 0;
        try {
            String query = "Insert into classes value( ? ,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, classes.getId());
            ps.setString(2, classes.getClassname());
            result = ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int update(Classes classes) {
        int result = 0;
        String query = "Update classes set classesname = ? where id =?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(2, classes.getId());
            ps.setString(1, classes.getClassname());
            result = ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Classes> getList() {
        List<Classes> classesList = new ArrayList<>();
        String query = "select * from classes";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                int id = rs.getInt("id");
                String classesname = rs.getString("classesname");
                Classes classes = new Classes(id, classesname);
                classesList.add(classes);
            }
            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return classesList;
    }

    public int delete(int id) {
        int result = 0;
        String query = "delete from classes where id =?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}
