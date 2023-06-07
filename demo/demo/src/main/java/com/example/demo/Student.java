package com.example.demo;

public class Student {

    int id;
    String name;

    int age;

    String address;

    public Student() {
    }

    public Student(int id, String hoten, int tuoi, String lop) {
        super();
        this.id = id;
        this.name = hoten;
        this.age = tuoi;
        this.address = lop;
    }

    public String toString() {
        return "id="+ id + ", hoten="+name+", tuoi="+age+", lop="+address;
    }
}
