package cn.commandoptionesc.interfacex;

public class InterfaceDemo {
    public static void main(String[] args) {

        //用接口声明，用实现类创建对象 - 向上造型
        Shape s = new Rectangle();


        /*
        //接口不能直接创建对象，创建出来的是匿名内部类
        Shape s1 = new Shape() {
            @Override
            public double getGirth() {
                return 0;
            }

            @Override
            public double getArea() {
                return 0;
            }
        };
        */

    }
}

//定义一个类表示图形Shape
//用interface定义的是一个接口
interface Shape{


    //获取周长
    //在接口中因为方法默认用public abstract修饰，所以public abstract可以省略不写
    //public abstract double getGirth();
    double getGirth();
    //获取面积
    //public abstract double getArea();
    double getArea();
    //从JDK1.8开始，允许在接口中声明实体方法
    //这个实体方法必须要default进行修饰
    //实体默认使用public修饰，也可以省略
    default double getHalGirth(){
        return 0;
    }

    //在接口中是不允许有构造方法的
    /*
    public Shape();
    public Shape(){}
    */

    //接口中定义的属性默认使用public static final来修饰
    //但是public static final可以不用写，默认就有
    //public static final int id = 3;
    int id = 3;
}

interface Girth{

}

//接口和接口之间可以进行继承，为多继承
interface Girth1 extends Shape,Cloneable{

}

//Java中接口是可以多实现的
class ExD implements Shape,Girth{

    @Override
    public double getGirth() {
        return 0;
    }

    @Override
    public double getArea() {
        return 0;
    }
}

//长方形
//类和接口之间用implements关键字来产生练习，这种练习称之为实现
//Rectangle实现了接口Shape
class Rectangle implements Shape{
    //Class 'Rectangle' must either be declared abstract or implement abstract method 'getGirth()' in 'Shape'
    //类实现接口的时候必须实现这个接口中的所有方法，除非这个类是抽象类
    @Override
    public double getGirth() {
        return 0;
    }

    @Override
    public double getArea() {
        return 0;
    }

    //类中可以提供构造方法
    public Rectangle(){

    }
}
