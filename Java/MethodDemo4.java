package cn.commandoptionesc.method;
public class MethodDemo4{
    public static void main(String[] args){
        boolean boo =isOdd(8);
        System.out.println(boo);
    }
    public static boolean isOdd(int m){
        if(m<0){
            System.out.println("rewrite");
                return false;
        }
        if(m%2!=0){
            return true;
        }
        return false;
    }
}
