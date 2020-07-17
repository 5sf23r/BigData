import java.util.Arrays;
class ArrayMaoPao{
    public static void main(String[] args){
        int[] arr={2,1,3,6,5};
        for(int i=1;i<arr.length;i++){
            for(int j=1;j<=arr.length-i;j++){
                if(arr[j-1]>arr[j]){
                    int temp=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
