package chp4;
public class ZhuanZhi {
	public static void main(String[] args) {
		int[][] a = {
				{1,2,3},
				{4,5,6},
				{7,8,9},
				{10,11,12}
		};
		
		int[][] b = new int[a[0].length][a.length];
		for(int i = 0; i<a.length; i++){
			for(int j = 0; j<a[i].length; j++){
				b[j][i] = a[i][j];
			}
		}
		printMultiArray(b);
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
