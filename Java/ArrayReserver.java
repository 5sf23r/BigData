import java.util.Arrays;
class ArrayReserver{
    public static void main(String[] args){
        int[] arr={1,2,7,4,5};
        int[] arr1=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            arr1[arr.length-1-i]=arr[i];
        }
        arr=arr1;
        System.out.println(Arrays.toString(arr));
    }
}
