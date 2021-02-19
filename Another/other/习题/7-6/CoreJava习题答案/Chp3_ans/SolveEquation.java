package chp3;

public class SolveEquation {

	public static void main(String[] args) {
		calRoot(2,8,1);
	}
	
	public static void calRoot(double a, double b, double c){
		if (!hasRealRoot(a,b,c)){
			System.out.println("No Real Root");
			return;
		}
		double s = Math.sqrt(b * b - 4 * a * c);
		
		double x1 = (-b + s) / (2 * a);
		double x2 = (-b - s) / (2 * a);
		
		System.out.println(x1);
		System.out.println(x2);
	}
	
	public static boolean hasRealRoot(double a, double b, double c){
		if (b*b - 4*a*c < 0) return false;
		else return true;
	}
	
}
