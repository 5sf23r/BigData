package cn.commandoptionesc.jdk5;

public class Enumdemo {
    public static void main(String[] args) {
        Season s = Season.Spring;
        //Season.Spring = Season.Autumn;
    }
}

//特殊的类 - 枚举
enum Season{
    //枚举常量
    //枚举常量必须放在枚举类的首行
    Spring,Summer,Autumn,Winter;
}

////定义一个类表示季节
////因为一年就只有4个季节，所以season类智能对外提供4个对象
//class Season{
//
//    //这个类的构造方法不能对外提供
//    private Season(){
//
//    }
//    public static final Season Spring = new Season();
//    public static final Season Summer = new Season();
//    public static final Season Autumn = new Season();
//    public static final Season Winter = new Season();

//}
