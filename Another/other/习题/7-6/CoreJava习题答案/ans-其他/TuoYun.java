package chp1;

import java.util.Scanner;
public class TuoYun {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int weight = sc.nextInt();
		double fee = 0;
		if (weight <= 20){
			fee = 5;
		}else if (weight <=100){
			fee = 5 +  0.2 * (weight - 20);
		}else {
			fee = 5 + 0.2 * (100 - 20) + 0.15 * (weight - 100);
		}
		System.out.println(fee);
	}
}
