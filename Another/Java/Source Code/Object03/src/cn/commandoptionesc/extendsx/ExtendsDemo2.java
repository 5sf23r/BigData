package cn.commandoptionesc.extendsx;

public class ExtendsDemo2 {
    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        r.setX(3.5);
        r.setY(4.8);
        System.out.println(r.getArea());

        Square s = new Square();
        s.setA(3);
        System.out.println(s.getArea());
    }
}

//表示矩形 - 长方形
class Rectangle{

    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getArea(){
        return x*y;
    }
}

//表示正方形
//正方形是一种特殊的长方形
class Square extends Rectangle{
    public void setA(double a){
        setX(a);
        setY(a);
    }
}

