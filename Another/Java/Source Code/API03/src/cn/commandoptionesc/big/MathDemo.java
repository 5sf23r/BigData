package cn.commandoptionesc.big;

public class MathDemo {
    public static void main(String[] args) {

        /*
        //自然底数
        System.out.println(Math.E);

        //圆周率
        System.out.println(Math.PI);

        //绝对值
        System.out.println(Math.abs(-9));

        //立方根
        System.out.println(Math.cbrt(27));

        //向上取整
        System.out.println(Math.ceil(3.1));

        //向下取整
        System.out.println(Math.floor(2.9));

        //四舍五入
        System.out.println(Math.round(3.45));

        //获取[0,1)的随机小数
        System.out.println(Math.random());

        //产生6位数字组成的验证码
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < 6;i++){
            //产生0-9之间的随机数字
            //[0,10)
            int num = (int)Math.random() * 10;
            sb.append(num);
        }
        System.out.println(sb.toString());
        */

        String str = "abcdefghijklmnopqrstuvwxyz0123456789";
        char[] cs = str.toCharArray();
        int len = cs.length;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < 8;i++){
            int index = (int)(Math.random() * len);
            sb.append(cs[index]);
        }
        System.out.println(sb.toString());
    }
}
