package chp4;

import java.util.Scanner;
public class LuoXuan{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in); 
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		int[][] a = new int[m][n];
		int col=0, row = 0;
		a[row][col] = 1;
		
		int[][] direction = {
			{0, 1}, //右
			{1, 0}, //下
			{0, -1},//左
			{-1, 0} //上
		};
		int directIndex = 0; //用来标识方向，一开始为右
		
		for(int i = 2; i<= m*n; i++){
			//按照之前的方向，计算下一个坐标
			row = row + direction[directIndex][0];
			col = col + direction[directIndex][1];
			
			//如果计算所得的坐标超出了范围
			if ( ( row >=m || row <0 )
			||(col >=n || col <0)
			|| (a[row][col] != 0) ){
			    //复原
				row = row - direction[directIndex][0];
				col = col - direction[directIndex][1];
				//换成下一个方向
				directIndex++;
				if (directIndex == 4) directIndex = 0;
				
				//计算新坐标
				row = row + direction[directIndex][0];
				col = col + direction[directIndex][1];
			}
			
			a[row][col] = i;
		}
		
		printMultiArray(a);
	}
	
	public static void printMultiArray(int[][] a){
		for(int i = 0; i<a.length; i++){
			for(int j = 0; j<a[i].length; j++){
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
	}
}