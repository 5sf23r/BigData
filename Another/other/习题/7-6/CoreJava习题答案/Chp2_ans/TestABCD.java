package chp2;

public class TestABCD {
	public static void main(String[] args) {
		for(int i = 1000; i<=9999; i++){
			int ab = i / 100;
			int cd = i % 100;
			if ( (ab + cd)*(ab + cd) == i){
				System.out.println(i);
			}
		}
	}
}
