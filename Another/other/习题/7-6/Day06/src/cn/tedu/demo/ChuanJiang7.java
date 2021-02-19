package cn.tedu.demo;

/**
 * @author ：cz
 * @date ：Created in 20/7/6 21:26
 * @version: 1.0$
 */
public class ChuanJiang7 {
    public static void main(String[] args) {
        MethodType m=new MethodType();
        m.printM(5);
    }
}
class MethodType{
    public<T> void printM(T t){
        System.out.println(t);
    }
}
