package chp3;

public class JieCheng {
	public static void main(String[] args) {
		for(int i = 100; i<=999; i++){
			int a = i/100;
			int b = i/10%10;
			int c = i % 10;
			if (jieCheng(a) + jieCheng(b) + jieCheng(c) == i){
				System.out.println(i);
			}
		}
	}	
	public static int jieCheng(int n){
		int sum = 1;
		for(int i = 2; i<=n; i++){
			sum *= i;
		}
		return sum;
	}
}
