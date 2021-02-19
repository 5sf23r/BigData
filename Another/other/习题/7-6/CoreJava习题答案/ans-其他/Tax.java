package chp1;

import java.util.Scanner;
public class Tax {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double income = sc.nextDouble();
		double tax = 0;
		if (income < 2000){
			System.out.println("不用交税");
			return;
		}
		
		double ti = income - 2000;
		if (ti <= 500){
			tax = ti * 0.05;
		}else if (ti <= 2000){
			tax = (ti - 500) * 0.1 + 500 * 0.05;
		}else if (ti <= 5000){
			tax = (ti - 2000)* 0.15 + 1500 * 0.1 + 500 * 0.05;
		}else if (ti <= 20000){
			tax = (ti - 5000) * 0.2 + 3000* 0.15 + 1500 * 0.1 + 500 * 0.05;
		}
		
		double t2 = income - 2000;
		double tax2 = 0.0;
		if((t2 <= 20000 && t2 > 5000)
		tax2 += ((t2 <= 20000 && t2 > 5000) ? t2-5000: 20000-5000)*0.2;
		tax2 += ((t2 <= 5000 && t2 > 2000) ? t2-2000: 5000-3000)*0.15;
		tax2 += ((t2 <= 2000 && t2 > 500) ? t2-500: 2000-500)*0.1;
		tax2 += ((t2 <= 500) ? t2-0: 500-0)*0.05;
		
		
		System.out.println(tax);
		System.out.println(tax2);
	}
}
