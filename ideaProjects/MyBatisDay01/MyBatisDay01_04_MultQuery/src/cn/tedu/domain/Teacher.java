package cn.tedu.domain;

import java.util.List;

public class Teacher {
    private int id;
    private String name;
    private List<Stu> stus;

    public Teacher() {
    }

    public Teacher(int id, String name, List<Stu> stus) {
        this.id = id;
        this.name = name;
        this.stus = stus;
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

    public List<Stu> getStus() {
        return stus;
    }

    public void setStus(List<Stu> stus) {
        this.stus = stus;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stus=" + stus +
                '}';
    }
}
