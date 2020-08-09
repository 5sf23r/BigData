package cn.commandoptionesc.type;

public class TypeDemo3 {
    public static void main(String[] args) {

        TypeMethod t = new TypeMethod();
        t.printString("ac");
        t.printString(3);
    }
}

class TypeMethod{

    //需要传入一个参数，然后将参数转化为字符串打印出来
    //需要给当前的方法来单独定义一个泛型
    //此时这个泛型是这个方法独有的
    public<T> void printString(T t){
        System.out.println(t);
    }
}
