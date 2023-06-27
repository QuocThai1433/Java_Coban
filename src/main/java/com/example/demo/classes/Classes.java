package com.example.demo.classes;

public class Classes {
    int id;
    String classname;

    public Classes() {

    }

    public Classes(int id, String classname) {
        super();
        this.id = id;
        this.classname = classname;
    }

    @Override
    public String toString() {
        return "id =" + id + ", classes name =" + classname;
    }
}
