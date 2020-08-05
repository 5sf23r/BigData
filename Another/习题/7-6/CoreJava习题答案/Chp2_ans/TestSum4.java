package chp2;

public class TestSum4 {
	public static void main(String args[]){
		int sum = 0;
		for(int i = 3; i<=100; i+= 3){
			if (i % 5 != 0){
				sum += i;
			}
		}
		System.out.println(sum);
	}
}
