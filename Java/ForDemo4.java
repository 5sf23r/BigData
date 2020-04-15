import java.util.Scanner;
class ForDemo4{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int sum=0;
        int n=sc.nextInt();
        for(int i=0;i<=n;i+=2){
            sum+=i;
        }
        System.out.println(sum);
    }
}
