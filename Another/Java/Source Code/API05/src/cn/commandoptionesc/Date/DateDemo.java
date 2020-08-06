package cn.commandoptionesc.Date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {
    public static void main(String[] args) throws Exception{

        /*
        //需要先获取一个Date对象
        //如果不指定，默认获取的是当前系统的时间
        Date date = new Date();
        System.out.println(date);
        */

        /*
        //指定日期：2000-10-15
        //这个long类型的参数所对应的必须是从1970-1- 00:00:00 到指定时的毫秒值
        Date date1 = new Date(242412424124L);
        System.out.println(date1);
        */

        /*
        //这是方法是在1900-01的基础上进行累加
        //这种写法比较麻烦，需要计算日期
        //而且实际开发过程中，日期形式往往是以字符串形式体现
        //那么还得考虑将字符串你转化为数字之后才能使用
        //Date上的横线表示已过时---这个方法依然可以使用，但不推荐使用，在后续版本中可能会被删除
        Date date2 = new Date(2000,10,15);
        System.out.println(date2);
        */

        //实际开发中，日期往往是以字符串形式给定
        //实际生活中，日期的表现形式是比较多样的
        //2000-10-15
        //2000.10.15
        //2000/10/15
        //例如：
        String str = "2000-10-15 14:25:54";
        //这个类可以将字符串转化为日期，也可以将日期转化为字符串
        //在转化的时候，需要制定格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //将一个字符串来转化日期
        //将日期在转化为字符串
        Date date = sdf.parse(str);

        //希望打印格式是:XXX年XX月XX日 XX时XX分XX秒
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        String s = sdf2.format(date);
        System.out.println(date);
        System.out.println(s);
        //yyyy-MM-dd -> yyyy/MM/dd
    }
}
