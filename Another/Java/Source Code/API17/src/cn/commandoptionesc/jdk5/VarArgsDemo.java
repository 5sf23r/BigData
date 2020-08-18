package cn.commandoptionesc.jdk5;

public class VarArgsDemo {
    public static void main(String[] args) {

        System.out.println(sum());
        System.out.println(sum(3,6));
        System.out.println(sum(3,4,8));
        System.out.println(sum(3,4,5,6,6,3));
        int[] arr = {3,7,9,4};
        System.out.println(sum(arr));
    }

    //用 ... 定义可一个可变参数
    public static int sum(int... arr){
        int sum = 0;
        for(int i = 0;i < arr.length;i++){
            sum += arr[i];
        }
        return sum;
    }
}
