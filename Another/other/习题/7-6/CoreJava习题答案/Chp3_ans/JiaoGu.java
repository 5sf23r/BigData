package chp3;

import java.util.Scanner;
public class JiaoGu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n != 1){
			n = getNextItem(n);
			System.out.println(" = " + n);
		}
	}
	public static int getNextItem(int n){
		if (n % 2 == 0){
			System.out.print(n + "/" + 2);
			return n/2;
		}else {
			System.out.print(n + "*3+1");
			return n * 3 + 1;
		}
	}
}
