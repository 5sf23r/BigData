package cn.commandoptionesc.integer;

public class IntegerDemo2 {
    public static void main(String[] args) {

        //这种写法在底层会自动封箱，调用对应类身上的ValueOf方法
        //当数据在 -128 ~ 127的时候，会从cache数组中获取对应位置上的值
        //cache是一个静态数组，所以从同一个数组中拿值
        Integer i1 = 25;// new Integer(325);
        Integer i2 = 25;// new Integer(325);

        //用==比较，比较两个对象的地址是否一致
        System.out.println(i1 == i2);

        //当包装类型和基本类型进行运算的时候，底层会将包装类型进行自动拆箱
        //所以是两个基本类型在参与运算
        Integer i3 = new Integer(500);
        int i4 = 500;
        System.out.println(i3 == i4);
    }
}
