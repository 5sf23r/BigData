import java.util.Scanner;
class IfDemo1{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int xing=sc.nextInt();
        if(xing>=0&&xing<10){
            System.out.println("C");
        }else if(xing>=10&&xing<20){
            System.out.println("B");
        }else if(xing>=20&&xing<30){
            System.out.println("A");
        }else if(xing>=30&&xing<90){
            System.out.println("S");
        }else if(xing>=90&&xing<100){
            System.out.println("S+");
        }else{
            System.out.println("XXXX");
        }
    }
}
