package cn.tedu.test;

import cn.tedu.anno.First;

@First(name = "zs", age =19,addr="bj" )
class Person2{
    @First(name="ls")
    private int id;
    private String name;

    @First("xxx")
    public Person2() {
    }

    @First
    public void eat(@First String food1,String food2){
        @First
        String food3 = "";
    }

}

/**
 * 自定义注解
 */
public class Test02 {
}
