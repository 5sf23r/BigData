package chp1;

import java.util.Scanner;
public class SanWeiShu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//��λ��
		int a = n / 100;
		//ʮλ��
		int b = n /10 % 10;
		//��λ��
		int c = n % 10;
		System.out.println(a + b + c);
	}
}
