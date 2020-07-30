package cn.commandoptionesc.finalx;

public class FinalDemo2 {
    public static void main(String[] args) {
        final int i = 3;
        m(i);
        System.out.println(i);
    }

    public static void m(int i ){
        i++;
    }
}
