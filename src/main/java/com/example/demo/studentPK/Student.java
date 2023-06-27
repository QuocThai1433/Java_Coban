package com.example.demo.studentPK;

public class Student {

    int id;
    String name;

    int age;

    String address;

    int classesid;

    public Student() {
    }

    public Student(int id, String hoten, int tuoi, String lop, int classesId) {
        super();
        this.id = id;
        this.name = hoten;
        this.age = tuoi;
        this.address = lop;
        this.classesid = classesId;
    }

    public String toString() {
        return "id="+ id + ",fullname="+name+", age="+age+", address="+address+"classeId"+classesid;
    }

    public String toString2() {
        return "id="+ id + ",fullname="+name+", age="+age+", address="+address;
    }
}
