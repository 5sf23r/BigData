package cn.commandoptionesc.integer;

public class IntegerDemo3 {
    public static void main(String[] args) {

        Integer i = new Integer("123");
        System.out.println(i);
        //NumberFormatException --- 数字格式异常
        //Integer i2 = new Integer("abc");
        Double d = new Double("6.81");
        System.out.println(d);
        //只要字符串不是"true"那么结果就是false
        Boolean b = new Boolean("true");
        System.out.println(b);

        int i2 = Integer.parseInt("124");
    }
}
