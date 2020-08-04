package cn.commandoptionesc.big;

import java.math.BigDecimal;

public class BigDecimalDemo {
    public static void main(String[] args) {

        //小数在计算的时候无法保证精确
        double d1 = 3.31;
        double d2 = 2.97;
        System.out.println(d1 - d2);

        //如果需要对小数运算保证精确性，那么需要BigDecimal
        BigDecimal b1 = new BigDecimal(3.31);
        BigDecimal b2 = new BigDecimal(2.97);
        //等价于3.31 - 2.97
        System.out.println(b1.subtract(b2));
        //等价于3.31 + 2.97
        System.out.println(b1.add(b2));

        //如果需要BigDecimal进行精确运算，那么需要将参数以字符串形式来传入
        //当字符串传形式传入的时候，在底层会以字符数组形式来计算
        BigDecimal b3 = new BigDecimal("3.31");
        BigDecimal b4 = new BigDecimal("2.97");

        System.out.println(b3.subtract(b4));
        System.out.println(b3.add(b4));
    }
}
