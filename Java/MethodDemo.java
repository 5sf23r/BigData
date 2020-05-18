package cn.commandoptionesc.method;
public class MethodDemo{
    public static void main(String[] args){
        printXing(3,6);
    }
    public static void printXing(int x,int y){
        for(int i=1;i<=x;i++){
                    for(int j=1;j<=y;j++){
                        System.out.print("*");
                    }
                    System.out.println();
                }
    }
}
