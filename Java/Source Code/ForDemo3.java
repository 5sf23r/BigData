import java.util.Scanner;
class ForDemo3{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n =sc.nextInt();
        int sum=0;
        /*for(int i=1;i<=n;i+=2){
            sum=sum+i;
        }
        System.out.println(sum);*/
        for(int i=1;i<=n;i++){
            if((i&1)!=0){
                sum+=i;
            }
        }
        System.out.println(sum);
    }
}
