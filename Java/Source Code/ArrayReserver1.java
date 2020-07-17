import java.util.Arrays;
class ArrayReserver1{
    public static void main(String[] args){
        int[] arr={1,2,7,4,5};
        for(int i=0;i<arr.length/2;i++){
            int temp=arr[i];
            arr[i]=arr[arr.length-i-1];
            arr[arr.length-i-1]=temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
