package cn.tedu.domain;

public class JDBCUtils {
    public void initConn(){
        System.out.println("初始化数据库连接...");
    }
    public void insert(){
        System.out.println("新增..");
    }
    public void update(){
        System.out.println("修改..");
    }
    public void destoryConn(){
        System.out.println("销毁数据库连接..");
    }
}
