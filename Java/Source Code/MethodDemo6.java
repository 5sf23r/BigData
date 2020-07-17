package cn.commandoptionesc.method;
public class MethodDemo6{
    public static void main(String[] args){
        isPrime(9);
    }
    public static void isPrime(int m){
        if(m<2){
            System.out.println("N");
            return;
        }
        for(int i=2;i<=m/2;i++){
            if(m%i==0){
                System.out.println("N");
                return;
            }
        }
        System.out.println("Y");
    }
}
