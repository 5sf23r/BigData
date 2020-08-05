package chp3;

public class NumOfDigit {
	public static void main(String[] args) {
		System.out.println(wei(10));
	}
	
	public static int wei(int n){
		int w = 0;
		do{
			w++;
			n = n /10;
		}while(n!=0);
		return w;
	}
}
