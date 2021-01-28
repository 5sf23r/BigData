package cn.tedu.domain;

import java.util.List;

public class User {
    private int id;
    private String name;
    private List<String> addrs;
    private Dog dog;

    public User() {
    }

    public User(int id, String name, List<String> addrs, Dog dog) {
        this.id = id;
        this.name = name;
        this.addrs = addrs;
        this.dog = dog;
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

    public List<String> getAddrs() {
        return addrs;
    }

    public void setAddrs(List<String> addrs) {
        this.addrs = addrs;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addrs=" + addrs +
                ", dog=" + dog +
                '}';
    }
}
