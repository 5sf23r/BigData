package chp1;
import java.util.Scanner;
public class JudgeEven {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n % 2 == 0){
			System.out.println("是偶数");
		}else {
			System.out.println("是奇数");
		}
		int a = 5;
		a += (a++)+(--a)+(++a);
		System.out.println(a);
	}
}
