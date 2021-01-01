package cn.tedu.domain;

public class Student {
    private int id;
    private String name;
    private Dog dog;

    public Student() {
    }

    public Student(int id, String name, Dog dog) {
        this.id = id;
        this.name = name;
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dog=" + dog +
                '}';
    }
}
