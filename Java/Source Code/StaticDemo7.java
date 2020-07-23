package cn.commandoptionesc.staticx;
public class StaticDemo7{
    public static void main(String[] args){
        System.out.println(new SDText().i1);
        System.out.println(new SDText().i2);
        System.out.println(new SDText().i3);
    }
}
class SDText{
    // 定义了成员变量并且优质，执行构造代码块的内容，给成员变量进行赋值，最后的结果值就是6
    int i1 = 1;
    {
        i1 = 6;
    }

    int i2=1;
    {
        i2+=6;
    }

    //java开始进行编译和执行，读到a=1，发现没有具体的类型，从上下文开始找，发现没有，会把a看成（标记）成成员变量
    //此时这个标记就只能赋值，坐不了其他任何操作，往下找到了同名的定义，就会把标记的值给同名变量，同名变量自己赋值
    //就把前面的赋值过程覆盖了
    {
        i3 = 4;
    }
    int i3=2;

    /*{
        i4+=3;
    }

    int i4=1;
    */
}
