package cn.tedu.domain;

public class User2 {
    private String uname;
    private int uage;
    private String uaddr;
    private Dog dog;

    public User2() {
    }

    public User2(String uname, int uage, String uaddr, Dog dog) {
        this.uname = uname;
        this.uage = uage;
        this.uaddr = uaddr;
        this.dog = dog;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getUage() {
        return uage;
    }

    public void setUage(int uage) {
        this.uage = uage;
    }

    public String getUaddr() {
        return uaddr;
    }

    public void setUaddr(String uaddr) {
        this.uaddr = uaddr;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "User2{" +
                "uname='" + uname + '\'' +
                ", uage=" + uage +
                ", uaddr='" + uaddr + '\'' +
                ", dog=" + dog +
                '}';
    }
}
