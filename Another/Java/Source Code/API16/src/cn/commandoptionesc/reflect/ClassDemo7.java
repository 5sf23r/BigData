package cn.commandoptionesc.reflect;

public class ClassDemo7 {
    public static void main(String[] args) {

        Class<String> c1z1 = String.class;
        Class<Object> c1z2 = Object.class;
        Class<Comparable> c1z3 = Comparable.class;
        //判断String类是否继承了Object类
        System.out.println(c1z2.isAssignableFrom(c1z1));
        //判断String类是否实现了Comparable接口
        System.out.println(c1z3.isAssignableFrom(c1z1));
    }
}
