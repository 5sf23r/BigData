package cn.commandoptionesc.object;

public class ObjectDemo1 {
    private int i;
    public static void main(String[] args) throws Exception{

        ObjectDemo1 o1 = new ObjectDemo1();
        o1.i = 5;

        //表示的是克隆，创建一个和o1属性值一样的对象
        ObjectDemo1 o2 = (ObjectDemo1) o1.clone();
        System.out.println(o2.i);
        System.out.println(o1);
        System.out.println(o2);

        //用向上造型创建o对象
        //o对象的声明类型是Object，实际类型是String
        Object o = "abc";
        //获取对象的实际类型
        System.out.println(o.getClass());

        //同一个对象的哈希码是一样的，不同的对象的哈希码是不同的
        System.out.println(o.hashCode());
        System.out.println(o.hashCode());
        System.out.println(o.hashCode());
        System.out.println(new Object().hashCode());
        System.out.println(new Object().hashCode());
        System.out.println(new Object().hashCode());
    }
}
