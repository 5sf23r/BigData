package chp3;

public class Distance {

	public static void main(String[] args) {
		System.out.print("Hello World\b");
		System.out.print("\b\b");
		System.out.print("   ");
	}
	
	public static double distance(double x1, double y1, double x2, double y2){
		double result = Math.sqrt( (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2) );
		return result;
	}
}
