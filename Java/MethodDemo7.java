package cn.commandoptionesc.method;
public class MethodDemo7{
    public static void main(String[] args){
        System.out.println(sum(2,3));
    }
    //sum(int,int)
    public static int sum(int i,int j){
        System.out.println("int,int");
        return i+j;
    }
    //sum(int,double)
    public static double sum1(int m,double n){
        System.out.println("int,double");
        return m+n;
    }
    //sum(double,double)
    public static double sum2(double d1,double d2){
        System.out.println("double,double");
        return d1+d2;
    }
}
