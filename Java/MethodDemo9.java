package cn.commandoptionesc.method;
public class MethodDemo9{
    public static void main(String[] args){
        int i=2;
        int[] arr={1,2,3};
        m(arr[0]);
        System.out.println(arr[0]);
    }
    public static void m(int i){
        i++;
    }
}
