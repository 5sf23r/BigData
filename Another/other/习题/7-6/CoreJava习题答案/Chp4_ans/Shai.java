package chp4;

import java.util.Scanner;
public class Shai{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean bs[] = new boolean[n+1];		
		//初始化
		for(int i = 0; i<bs.length; i++){
			bs[i] = true;
		}		
		//进行bs.length轮筛选
		for(int i = 2; i<bs.length; i++){
			if (bs[i]){//i为质数
				//把i的倍数设为false
				for (int j = i*2; j<bs.length; j+= i){
					bs[j] = false;
				}
			}else{//i不为质数
				continue;
			}
		}		
		//输出
		for(int i = 2; i<bs.length; i++){
			if (bs[i]){
				System.out.print(i + "\t");
			}
		}
		System.out.println();	
	}
}