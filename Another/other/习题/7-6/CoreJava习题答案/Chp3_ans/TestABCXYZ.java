package chp3;

public class TestABCXYZ {
	public static void main(String[] args) {
		for(int i = 100; i<=999; i++){
			for (int j = 100; j<=999; j++){
				int a = i/100;
				int b = i/10%10;
				int c = i%10;
				int x = j/100;
				int y = j/10%10;
				int z = j%10;
				if (isFullSquare(i) && isFullSquare(j)
					&& isFullSquare(a*10 + x)
					&& isFullSquare(b*10 + y)
					&& isFullSquare(c*10 + z)
				){
					System.out.println(i + " " + j);
				}
			}
		}
	}	
	public static boolean isFullSquare(int n){
		int s = (int)Math.sqrt(n);
		if (s*s == n) return true;
		else return false;
	}
}
