package chp4;

public class EightQueen {
	
	static int[] queens = new int[8]; //表示每一行皇后的纵坐标
	static int solveNum = 1; //统计解的数量
	public static void main(String[] args) {
		put(0);
	}
	
	//判断在之前的基础上在第n行放第m列是否可行
	public static boolean canPut(int n, int m){
		//判断是否有在同一列的
		for(int i = 0; i<n; i++){
			if (queens[i] == m) return false;
		}
		//判断是否有在左上-->右下对角线
		for(int i = 0; i<n; i++){
			if (queens[i] - i == m - n) return false;
		}
		
		//判断是否有在右上-->左下对角线
		for(int i = 0; i<n; i++){
			if (queens[i] + i == m + n) return false;
		}
		return true;
	}
	
	//表示尝试放置第n行的皇后
	public static void put(int n){
		if (n == 8){
			System.out.println(solveNum++);
			printQueen();
			return;
		}
		for(int i = 0; i<queens.length; i++){
			if (canPut(n, i)){
				queens[n] = i;
				put(n+1);
				queens[n] = 0;
			}
		}
	}
	public static void printQueen(){
		for(int i = 0; i<queens.length; i++){
			for(int j = 0; j<queens.length; j++){
				if (queens[i] == j){
					System.out.print("*");
				}else{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
