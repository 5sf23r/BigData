package cn.tedu.domain;

import java.util.List;

public class Dept {
    private int id;
    private String name;
    private List<Emp> emps;

    public Dept() {
    }

    public Dept(int id, String name, List<Emp> emps) {
        this.id = id;
        this.name = name;
        this.emps = emps;
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

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emps=" + emps +
                '}';
    }
}
