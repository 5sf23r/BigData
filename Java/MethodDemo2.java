package cn.commandoptionesc.method;
public class MethodDemo2{
    public static void main(String[] args){
        //sum(2,4);
        //System.out.println(sum(2,4));
        int result = sum(2,5);
        System.out.println(result);
    }
    public static int sum(int m,int n){
        int sum=m+n;
        return sum;
    }
}
