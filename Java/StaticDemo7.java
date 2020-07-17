package cn.commandoptionesc.staticx;
public class StaticDemo7{
    public static void main(String[] args){
        System.out.println(new SDText().i);
    }
}
class SDText{
    int i = 1;
    {
        i = 6;
    }
}
