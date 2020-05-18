package cn.commandoptionesc.method;
public class MethodDemo5{
    public static void main(String[] args){
        boolean boo=isPrime(9);
        System.out.println(boo);
    }
    public static boolean isPrime(int m){
        if(m<2){
            return false;
        }
        for(int i=2;i<=m/2;i++){
            if(m%i==0){
                return false;
            }
        }
        return true;
    }
}
