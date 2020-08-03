package cn.commandoptionesc.stringx;

public class StringDemo2 {
    public static void main(String[] args) {

        // 获取1970-01-01 00：00：00到现在时间的毫秒值
        long begin = System.currentTimeMillis();
        /*
        //7800+
        String str = "";
        for(int i = 0;i < 100000;i++){
            str += "a";
        }
        */

        //198
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < 10000000;i++){
            sb.append("a");
        }
        String str = sb.toString();
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }
}


