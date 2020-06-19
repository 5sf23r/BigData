package cn.commandoptionesc.duotai;
public class DTEx{
    public static void main(String[] args){
        //
        Shape s=new Chang(4,5);
        Shape s1=new Yuan(6);
        Shape s2=new Zheng(8);
        System.out.println(s.getArea());
        System.out.println(s.getGirth());
        System.out.println(s1.getArea());
        System.out.println(s1.getGirth());
        S
    }
}

//图形类
class Shape{
    //属性
    private double x;
    private double y;
    
    public double getX(){
        return x;
    }
    public void setX(double x){
        this.x=x;
    }
    public double getY(){
        return y;
    }
    public void setY(){
        this.y=y;
    }

    //有参构造---给属性赋值
    public Shape(double x,double y){
        this.x=x;
        this.y=y;
    }

    //面积
    public double getArea(){
        return 0.0;
    }
    //周长
    public double getGirth(){
        return 0.0;
    }
}
//长方形类
class Chang extends Shape{
    public Chang(double x,double y){
        super(x,y);
    }
    //重写
    public double getArea(){
        return getX()*getY();
    }
    public double getGirth(){
        return 2*(getX()+getY());
    }
}
//圆形类
class Yuan extends Shape{
    public Yuan(double x){
        super(x,x);
    }
    public double getArea(){
        return 3.14*getX()*getX();
    }
    public double getGirth(){
        return 2*3.14*getX();
    }
}
//正方形类
class Zheng extends Shape{
    public Zheng(double x){
        super(x,x);
    }
}

