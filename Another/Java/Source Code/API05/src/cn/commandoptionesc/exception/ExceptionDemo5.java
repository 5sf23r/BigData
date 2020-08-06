package cn.commandoptionesc.exception;

import java.io.IOException;
import java.sql.SQLException;

public class ExceptionDemo5 {
    public static void main(String[] args) {

    }
}

class A{
    public void m() throws IOException{
        System.out.println("A m()");
    }
    public void m(int i) throws SQLException {
        System.out.println("A m(int)");
    }
}

class B extends A{
    //子类在重写父类中的方法的时候，抛出的编译异常不能超过父类异常的范围
    @Override
    public void m() throws IOException {
        System.out.println("B m()");
    }
}