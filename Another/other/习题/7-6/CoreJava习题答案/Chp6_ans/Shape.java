package chp6;


//Shape类中必须定义girth方法和area方法，
//目的是为了能够针对Shape类型的引用调用这两个方法

//要注意的是，求周长和求面积的方法都不带参数
//这两个方法表示求当前图形的周长或面积，
//既然是当前图形，则必然有相应的属性
//（例如，圆形有半径属性，正方形有边长属性）
//在求周长和面积时，只需要使用对象的属性，而不需要额外传递参数。

class Shape{
	public double girth(){
		return 0;
	}
	public double area(){
		return 0;
	}
}

class Circle extends Shape{
	private double radius;
	private double pi = 3.1415926;

	public Circle(double radius) {
		this.radius = radius;
	}

	public double area() {
		return pi * radius * radius;
	}

	public double girth() {
		return 2 * pi * radius;
	}
}

class Rect extends Shape{
	private double a;
	private double b;
	
	public Rect(){}
	public Rect(double a, double b) {
		this.a = a;
		this.b = b;
	}
	public double area() {
		return a*b;
	}
	public double girth() {
		return 2*(a+b);
	}
}

class Square extends Rect{
	private double a;

	public Square(double a) {
		super();
		this.a = a;
	}

	public double area() {
		return a*a;
	}

	public double girth() {
		return 4*a;
	}
	
}
