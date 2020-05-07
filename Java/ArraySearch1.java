import java.util.Arrays;
class ArraySearch1{
    public static void main(String[] args){
        int[] arr={1,2,3,5,6,8,9};
        int num=7;
        int min=0;
        int max=arr.length-1;
        int mid=(min+max)/2;
        boolean flag=true;
        while(arr[mid]!=num){
            if(arr[mid]<num){
                min=mid+1;
            }
            if(arr[mid]>num){
                max=mid-1;
            }
            if(min>max){
                System.out.println("no");
                flag=false;
                break;
            }
            mid=(min+max)/2;
        }
        if(flag){
            System.out.println(mid);
        }
    }
}
