package cn.commandoptionesc.object;

public class CarExer {
    public static void main(String[] args){
        //创建车对象
        Car c = new Car();
        //将c对象的属性座位数量赋值为5
        c.chairNum = 5;
        //将车对象的颜色赋值为red
        c.colour= "red";
    }
}
//定义一个类表示车，然后创建一个车对象，这个车有5个座位，车的颜色是红色的
//定义一个类表示车
class Car{
    //定义一个属性表示座位的数量
    int chairNum;
    //定义一个属性表示车的颜色
    String colour;

}
