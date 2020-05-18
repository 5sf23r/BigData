package cn.commandoptionesc.method;
public class MethodDemo3{
    public static void main(String[] args){
        printXing(3,6);
    }
    public static void printXing(int x,int y){
        for(int i=1;i<=x;i++){
            for(int j=1;j<=y;j++){
                if(j==2)
                    return;
                System.out.println("*");
            }
            System.out.println();
        }
        System.out.println(1);
    }
}
