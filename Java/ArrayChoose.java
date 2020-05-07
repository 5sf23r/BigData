import java.util.Arrays;
class ArrayChoose{
    public static void main(String[] args){
        int[] arr={1,2,9,3,6,4};
        for(int i=1;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                if(arr[i-1]>arr[j]){
                        int temp=arr[j];
                        arr[j]=arr[i-1];
                        arr[i-1]=temp;
                    }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
