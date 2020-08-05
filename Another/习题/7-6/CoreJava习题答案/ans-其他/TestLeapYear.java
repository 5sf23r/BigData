package chp1;

import java.util.Scanner;
public class TestLeapYear {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		if ( (year % 4 == 0 && year % 100 !=0) //能被4整除不能被100
				|| year % 400 == 0){	//能被400整除
			System.out.println(year + "是闰年");
		}else{
			System.out.println(year + "不是闰年");
		}
	}
}
