package cn.commandoptionesc.integer;

public class IntegerDemo {
    public static void main(String[] args) {

        //int i = 157;

        /*
        //将基本类型的变量封装成对应的包装类型
        Integer in = new Integer(i);
        System.out.println(in);
        */

        /*
        //将基本类型的变量i赋值给了对应的引用类型的对象in
        //自动封箱
        //在底层就会调用Integer类身上的valueOf方法将i封装成Integer对象
        //等价于  Integer in = Integer.valueOf(i);
        Integer in = i;
        */

        /*
        double d = 3.57;
        //相当于Double dou = Double.valueOf(d);
        Double dou = d;
        */

        //自动拆箱
        Integer in = new Integer(4);
        //在底层会调用in对象身上的intValue方法
        int i = in;

        Double dou = new Double(3.28);
        //double d = dou.doubleValue();
        double d = dou;

        Character ch = new Character('a');
        //char c = ch.charValue();
        char c = ch;






    }
}
