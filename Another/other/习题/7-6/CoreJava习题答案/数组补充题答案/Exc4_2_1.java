package day8;
import java.util.*;
public class Exc4_2_1{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		if (n % 2 == 1) n++; // 如果n是奇数,则n+1 保证n是偶数
		int[] team = new int[n];
		for(int i = 0 ; i < n ; i++){
			team[i] = i;
		}
		
		for(int i = 1 ; i < n ; i++){
			//打印本轮对阵
			for(int j = 0 ; j < n/2 ; j++){
				System.out.print(team[j]+"---"+team[n-1-j]+"  ");
			}
			System.out.println();
			
			//计算出下轮对阵
			if (i != n-1){
				int t = team[n-1]; //用中间变量先保存team[n-1]
				for(int j = n-1 ; j > 1; j--){
					team[j] = team[j-1];
				}
				team[1] = t;
			}
		}
		
	}
}