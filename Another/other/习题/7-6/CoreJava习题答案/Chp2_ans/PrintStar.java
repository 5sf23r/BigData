package chp2;

import java.util.Scanner;
public class PrintStar {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 1; i<=n; i++){
			//输出n-i个空格
			for(int j = 1; j<=n-i; j++){
				System.out.print(" ");
			}
			//输出2*i-1个星
			for(int j = 1; j<=2*i-1; j++){
				System.out.print("*");
			}
			//换行
			System.out.println();
		}
	}
}
