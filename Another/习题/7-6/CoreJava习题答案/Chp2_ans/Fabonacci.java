package chp2;

import java.util.Scanner;
public class Fabonacci {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n <= 3){
			System.out.println("前3项：0, 1, 1");
		}else{
			System.out.print("0, 1, 1");
			//前一项（上一项的上一项）
			int preLast = 1;
			//上一项
			int last = 1;
			//当前项
			int thisItem = 0;
			for(int i = 4; i<=n; i++){
				//当前项的值为前一项+上一项
				thisItem = preLast + last;
				
				//为计算下一项做准备
				//下一项的前一项，就是当前项的上一项
				preLast = last;
				//下一项的上一项，就是当前项
				last = thisItem;
				System.out.print(", " + thisItem);
			}
		}
	}
}
