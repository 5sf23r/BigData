package day8;
import java.util.*;
public class Exc4_2_3{
	static boolean flag[]; // flag[i]表示i这个数是否可用
	static int result[]; //记录排列的结果
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		flag = new boolean[n];
		for(int i = 0 ; i < n ; i++) flag[i]=true;
	  result = new int[n];
	  
	  place(0);
	}
	//放置第i个数,通过flag数组找出所有能用的数,并取出一个放在排列的第i个位置
	static void place(int i){
		if (i==result.length){
			for(int k = 0 ; k < result.length;k++){
				System.out.print(result[k]+1+"  ");  //打印时从1打印起,012打印为123
 			}
			System.out.println();
			return;
		}
		
		for(int k = 0 ; k < flag.length ; k++){
			if (flag[k]){  //如果k可以用
				result[i] = k;   //将k放到result数组的第i个位置
				flag[k] = false; //标记k这个数已经用过了,后面的排列中不再出现
				place(i+1);  //放下一个位置
				flag[k] = true; //将k释放,准备在第i个位置上继续尝试k+1
			}
		}		
	}
}
		