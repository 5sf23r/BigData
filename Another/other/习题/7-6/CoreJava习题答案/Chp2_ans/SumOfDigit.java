package chp2;

import java.util.Scanner;
public class SumOfDigit {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		while(n != 0){
			sum += n % 10; //获得低位的值，并加到sum上
			n = n / 10;	   //去掉低位的值
		}
		System.out.println(sum);
	}
}
