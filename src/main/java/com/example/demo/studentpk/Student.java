package com.example.demo.studentpk;

public class Student {

    private int id; // private
    private String name;

    private int age;

    private String address;

    private int classesId;

    public Student() {
    }

    public Student(int id, String name, int age, String address) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Student(int id, String name, int age, String address, int classesId) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.classesId = classesId;
    }

    public String toString() {
        return "id="+ id + ", hoten="+name+", tuoi="+age+", lop="+address;
    }
    public String toString1() {
        return "id="+ id + ", hoten="+name+", tuoi="+age+", lop="+address+ ", classesId="+classesId ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getClassesId() {
        return classesId;
    }

    public void setClassesId(int classesId) {
        this.classesId = classesId;
    }
}