package chp3;

import java.util.Scanner;

public class GoldBach {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 3; i<= n/2; i+=2){
			//把n拆成i和n-i
			//分别判断i和n-1是否为质数
			//如果这两个数都为质数，则证明这是一组解
			if (isPrime(i) && isPrime(n-i)){
				System.out.println(n + "=" + i + "+" + (n-i));
			}
		}
	}
	public static boolean isPrime(int n){
		for(int i = 2; i<=Math.sqrt(n); i++){
			if (n % i == 0) return false;
		}
		return true;
	}
}
