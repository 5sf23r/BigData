import java.util.Arrays;
class ArraySearch{
    public static void main(String[] args){
        int[] arr={1,5,2,8,3,4};
        int num=8;
        int count=0;
        for(int i:arr){
            if(i==num){
                System.out.println(count);
                break;
            }
            count++;
        }
    }
}
