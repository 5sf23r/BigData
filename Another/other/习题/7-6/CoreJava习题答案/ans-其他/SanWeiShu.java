package chp1;

import java.util.Scanner;
public class SanWeiShu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//百位数
		int a = n / 100;
		//十位数
		int b = n /10 % 10;
		//个位数
		int c = n % 10;
		System.out.println(a + b + c);
	}
}
