package cn.commandoptionesc.Date;

import java.util.Calendar;

public class CalendarDemo {
    public static void main(String[] args) {

        //Calendar本身是一个抽象类，不允许new

        Calendar c = Calendar.getInstance();
        //java.util.GregorianCalendar[time=1596697392492,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Shanghai",offset=28800000,dstSavings=0,useDaylight=false,transitions=29,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2020,MONTH=7,WEEK_OF_YEAR=32,WEEK_OF_MONTH=2,DAY_OF_MONTH=6,DAY_OF_YEAR=219,DAY_OF_WEEK=5,DAY_OF_WEEK_IN_MONTH=1,AM_PM=1,HOUR=3,HOUR_OF_DAY=15,MINUTE=3,SECOND=12,MILLISECOND=492,ZONE_OFFSET=28800000,DST_OFFSET=0]
        //java.util.GregorianCalendar --- 格里高利历
        //time = ...... --- 从1970-01-01 00:00:00到指定时间的毫秒值
        //zone --- 时区
        //offset --- 时区偏移量
        //firstDayOfWeek = 1 --- 一个周的第一天为1
        //MONTH = 11 --- 第12月，因为这个月是从0开始计算
        //WEEK_OF_YEAR = 52 --- 这一年的第52个周
        //WEEK_OF_MONTH = 4 --- 这一周的第4天，从星期天开始算，4表示星期三
        //DAY_OF_MONTH = 25 --- 这个月的第25天
        //DAY_OF_YEAR = 359 --- 这一天是这一年的359天
        //DAY_OF_WEEK =4 --- 这一天是这一周的第四天
        System.out.println(c);
    }
}
