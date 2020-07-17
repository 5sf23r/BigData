package cn.commandoptionesc.method;
public class MethodDemo10{
    public static void main(String[] args){
        int[] arr={1,2,3};
        n(arr);
        System.out.println(arr[0]);
    }
    public static void n(int[] arr){
        arr[0]=10;
    }
}
