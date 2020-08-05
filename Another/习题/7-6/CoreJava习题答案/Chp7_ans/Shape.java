package chp7;

abstract class Shape{
	abstract public double girth();
	abstract public double area();
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
