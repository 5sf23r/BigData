package cn.tedu.pojo;

/* Model数据模型：
*  1. 该User类 与 数据库的user表对应
*  2. 因为Java是面向对象的，可以使用javabean去描述user表
*  3. 一个javabean的对象，
*      对应着一条数据库的数据
* */
public class User {
    //1.成员变量：对应着user表中的 字段名
    private int id;
    private String username;
    private String password;
    private String nickname;
    private String email;
    //2.构造方法：专门用于创建对象

    public User() {
    }

    public User(int id, String username, String password, String nickname, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
    }
    //3.添加getter和setter方法

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    //4.toStirng方法

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
