package com.example.demo.classespk;

public class Classes {
    private int id;
    private String classname;

    public Classes() {

    }

    public int getId() {
        return id;
    }

    public String getClassname() {
        return classname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public Classes(int id, String classname) {
        super();
        this.id = id;
        this.classname = classname;
    }

    @Override
    public String toString() {
        return "id =" + id + ", classesname =" + classname;
    }
}
