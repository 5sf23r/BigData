package chp2;

import java.util.Scanner;
public class JudgePrime {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i = 0;
		boolean isPrime = true;
		for(i = 2; i<=Math.sqrt(n); i++){
			if (n % i == 0){
				System.out.println("不是质数");
				isPrime = false;
				break;
			}
		}
		if (isPrime){
			System.out.println("是质数");
		}
	}
}
