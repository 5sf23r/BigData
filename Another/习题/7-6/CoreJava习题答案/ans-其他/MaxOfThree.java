package chp1;

//算法描述：读入三个数a,b,b 
//先判断：如果a<b则让a=b
//再判断：如果a<c则让a=c
//这样，最大值就保存在a中
import java.util.Scanner;

public class MaxOfThree {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		//如果a比b小，则让a的值等于b
		//这样能保证a的值是a、b中比较大的数
		if (a < b) {
			a = b;
		}
		
		//下面这个判断，能保证a的值是a、c中比较大的数
		if (a<c){
			a = c;
		}
		
		//a中保存了三个数中最大的那个
		System.out.println(a);
	}
}
