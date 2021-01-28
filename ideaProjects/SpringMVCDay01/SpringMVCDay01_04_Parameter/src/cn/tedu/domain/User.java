package cn.tedu.domain;

public class User {
    private String uname;
    private int uage;
    private String uaddr;

    public User() {
    }

    public User(String uname, int uage, String uaddr) {
        this.uname = uname;
        this.uage = uage;
        this.uaddr = uaddr;
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

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", uage=" + uage +
                ", uaddr='" + uaddr + '\'' +
                '}';
    }
}
