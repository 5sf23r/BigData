package chp1;

import java.util.Scanner;
public class TestAge {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		if (age < 6){
			System.out.println("儿童");
		}else if (age <=13){
			System.out.println("少儿");
		}else if (age <=18){
			System.out.println("青少年");
		}else if (age <=35){
			System.out.println("青年");
		}else if (age <=50){
			System.out.println("中年");
		}else {
			System.out.println("中老年");
		}
	}
}
