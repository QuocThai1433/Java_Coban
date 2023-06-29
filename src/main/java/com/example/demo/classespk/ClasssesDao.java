package com.example.demo.classesPK;

import com.example.demo.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClasssesDao {
    Connection connection = ConnectDB.getConnection();

    public int create(Classes classes) {
        int kq = 0;
        try {
            String query = "Insert into classes value( ? ,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, classes.id);
            ps.setString(2, classes.classname);
            kq = ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    public int update(Classes classes) {
        int kq = 0;
        //   Classes classes = new Classes();
        String query = "Update classes set classesname = ? where id =?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(2, classes.id);
            ps.setString(1, classes.classname);
            kq = ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
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
        int kq = 0;
        String query = "delete from classes where id =?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            kq = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }


}
