package chp2;

public class PerfectNumber {
	public static void main(String[] args) {
		for(int i = 2; i<=1000; i++){
			int sum = 0; //sum用来统计i的因子和
			//计算所有因子和
			for(int j = 1; j<=i/2; j++){
				if (i % j == 0) sum+=j;
			}
			if (sum == i){
				System.out.println(i);
			}
		}
	}
}
