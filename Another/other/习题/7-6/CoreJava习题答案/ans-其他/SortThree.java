import java.util.Scanner;
public class SortThree {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a =sc.nextInt();
		int b =sc.nextInt() ;
		int c =sc.nextInt() ;
		
		//这段保证：a的值比b大
		if (a < b){
			int t = a; a = b; b = t;
		}
		//这段保证：a的值比c大（因此a是最大的数）
		if (a < c){
			int t = a; a = c; c = t;
		}
		//这段保证：b的值比c大（因此c是最小的数）
		if (b < c){
			int t = b; b = c; c = t;
		}
		
		System.out.println(a + " " + b + " " + c);


	}
}
