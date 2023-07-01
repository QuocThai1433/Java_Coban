package com.example.demo.student;

public class Student {

    private int id;

    private String name;

    private int age;

    private String address;

    private int classesId;

    public String toString() {
        return "id = " + id + ", fullName = " + name + ", age = " + age + ", address = " + address + ", classesId = " + classesId;
    }

    public Student(int id, String name, int age, String address, int classesId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.classesId = classesId;
    }

    public Student() {
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
