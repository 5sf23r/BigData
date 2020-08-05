package chp3;

public class CloseNumber {
	public static void main(String[] args) {
		for(int i = 1; i<=3000; i++){
			int b = sumAllFact(i); // i的因子和为b
			int a = sumAllFact(b); // b的因子和为a
			
			//分析：如果a == i，意味着a的因子和为b，
			//b的因子和为a，满足亲密数的要求
			//同时，为了避免重复解，要求a < b
			
			if (a < b  && a==i){
				System.out.println(a + " " + b);
			}
		}
	}
	
	//计算因子和的函数
	public static int sumAllFact(int n){
		int sum = 0;
		for(int i = 1; i<=n/2; i++){
			if (n % i == 0) sum+= i;
		}
		return sum;
	}
}
