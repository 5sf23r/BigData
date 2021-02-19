package chp2;

public class TestSum3 {

	public static void main(String[] args) {
		int i = 1;
		int sum = 0;
		while (i<=99){
			sum += i;
			i += 2;
		}
		System.out.println(sum);
		
		sum = 0; i = 1;
		do{
			sum +=i;
			i += 2;
		}while(i <= 99);
		System.out.println(sum);
	}

}
