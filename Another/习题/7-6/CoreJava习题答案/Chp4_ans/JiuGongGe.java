import java.util.Scanner;
public class JiuGongGe{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] a = new int[n][n];
		int row = 0;
		int col = n/2;
		//第一行正中间为1
		a[row][col] = 1;
		for(int i = 2; i<= n*n; ++i){
			//向斜上方
			row--;
			col++;
			
			//既出了上边界又出了右边界
			//则行+2；列-1
			if ( row<0 && col>=n ){
				row +=2;
				col--;
			}
			//出了右边界，则行不变，列变为0
			else if(col >= n){
				col = 0;
			}
			//出了上边界，则列不变，行=n-1
			else if(row < 0){
				row = n - 1;
			}
			//斜上方有数字
			//则行+2；列-1
			else if(a[row][col] != 0){
				row +=2;
				col--;
			}
			a[row][col] = i;
		}
		print(a);
	}

	public static void print(int[][] a){
		for(int i = 0; i<a.length; ++i){
			for (int j = 0; j<a[i].length; ++j){
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
