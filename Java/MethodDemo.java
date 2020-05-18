package cn.commandoptionesc.method;
public class MethodDemo{
    public static void main(String[] args){
        printXing(3,6);
    }
    public static void printXing(int x,int y){
        for(int i=1;i<=8;i++){
                    for(int j=1;j<=6;j++){
                        System.out.print("*");
                    }
                    System.out.println();
                }
    }
}
