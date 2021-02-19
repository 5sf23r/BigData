package chp6;

public class TestShape {
	//20题的代码
	public static void ex20(){
		Shape[] ss = new Shape[3];
		ss[0] = new Circle(2);
		ss[1] = new Rect(3,4);
		ss[2] = new Square(3.5);
		for(int i = 0; i<ss.length; i++){
			System.out.println("girth : " + ss[i].girth() 
					+ "\t"+"area : " + ss[i].area());
		}
	}
	
	//21题的代码
	public static Shape getShape(int i){
		if (i == 0) return new Circle(1);
		if (i == 1) return new Rect(3,2);
		if (i == 2) return new Square(2);
		return null;
	}
	
	//22题的代码
	public static void printShape(Shape s){
		System.out.println("girth : " + s.girth() 
				+ "\t"+"area : " + s.area());
	}
	
	public static void main(String[] args) {

	}
}
