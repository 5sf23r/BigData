package cn.commandoptionesc.method;
public class MethodDemo11{
    public static void main(String[] args){
        int[] arr={1,2,3};
        mn(arr);
        System.out.println(arr[0]);
    }
    public static void mn(int[] arr){
        arr=new int[]{2,3,4};
    }
}
