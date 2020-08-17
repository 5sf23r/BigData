package cn.commandoptionesc.reflect;

public class ClassDemo6 {
    public static void main(String[] args) {

        Class<String> c1z = String.class;

        //判断是否是一个注解
        System.out.println(c1z.isAnnotation());

        //判断是否是一个匿名内部类
        System.out.println(c1z.isAnonymousClass());
        //判断是否是一个方法内部类/局部内部类
        System.out.println(c1z.isLocalClass());
        //判断是否是一个成员内部类
        System.out.println(c1z.isMemberClass());
        //判断是否是一个基本类型
        System.out.println(c1z.isPrimitive());

        Object str = "hello";
        //str是否是一个String对象
        System.out.println(c1z.isInstance(str));
    }
}
