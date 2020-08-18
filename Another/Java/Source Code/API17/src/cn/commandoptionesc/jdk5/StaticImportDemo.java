package cn.commandoptionesc.jdk5;

//import java.util.Arrays;
import java.util.Scanner;
import static java.util.Arrays.sort;

public class StaticImportDemo {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int len = s.nextInt();

        int[] arr = new int[len];
        for(int i = 0;i < arr.length;i++){
            arr[i] = s.nextInt();
        }
        //数组排序
        sort(arr);
        //System.out.println(toString(arr));
    }
}
