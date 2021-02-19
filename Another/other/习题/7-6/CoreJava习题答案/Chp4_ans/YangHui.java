package chp4;

import java.util.Scanner;
public class YangHui {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] a = new int[n][n];
		for(int i = 0; i<a.length; i++){
			//设置两边
			a[i][0] = 1; a[i][i] = 1;
			if (i == 0) continue;
			for(int j = 1; j<i;j++){
				a[i][j] = a[i-1][j-1] + a[i-1][j];
			}
		}
		
		//输出
		for(int i = 0; i<a.length; i++){
			for(int j = 0; j<=i; j++){
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
