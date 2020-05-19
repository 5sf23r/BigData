package cn.commandoptionesc.method;
public class MethodDemo8{
    public static void main(String[] args){
        int i=2;
        m(i);
        //2
        System.out.println(i);
    }
    public static void m(int i){
        i++;
    }
}
