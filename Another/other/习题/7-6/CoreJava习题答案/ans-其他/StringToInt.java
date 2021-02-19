package chp9;

import java.util.Scanner;
public class StringToInt {

	public static void main(String[] args) {
		String str = sc.nextLine();
		
		//第一种做法，str --> int
		int i1 = Integer.parseInt(str);
		System.out.println(i1);
		
		//第二种做法，str --> Integer --> int
		Integer ii = new Integer(str);
		int i2 = ii.intValue();
		System.out.println(i2);
		
	}
}
