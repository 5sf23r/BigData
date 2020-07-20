package cn.commandoptionesc.staticx;
public class StaticDemo8{
    public static void main(String[] args){
        System.out.println(SDText1.x+SDText1.y);
    }
}
class SDText1{
    static SDText1 sd = new SDText1();
    static int x = 3;
    static int y;

    public SDText1(){
        x++;
        y++;
    }
}
