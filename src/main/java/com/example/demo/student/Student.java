package com.example.demo.student;

public class Student {

    private int id; // private
    private String name;

    private int age;

    private String address;

    private float score;
    private int classesId;


    public Student() {
    }

    public Student(int id, String name, int age, String address,float score) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.score  = score;
    }

    public Student(int id, String name, int age, String address,float score, int classesId) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.score= score;
        this.classesId = classesId;
    }

    public String toString() {
        return "id="+ id + ", hoten="+name+", tuoi="+age+", lop="+address+ ", score" +score+ ", classesId="+classesId;
    }
    public String toString1() {
        return "id="+ id + ", hoten="+name+", tuoi="+age+", lop="+address+ ", score=" +score+ ", classesId="+classesId ;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public float getScore() {
        return score;
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