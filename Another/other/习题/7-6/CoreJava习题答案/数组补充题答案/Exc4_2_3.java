package day8;
import java.util.*;
public class Exc4_2_3{
	static boolean flag[]; // flag[i]��ʾi������Ƿ����
	static int result[]; //��¼���еĽ��
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		flag = new boolean[n];
		for(int i = 0 ; i < n ; i++) flag[i]=true;
	  result = new int[n];
	  
	  place(0);
	}
	//���õ�i����,ͨ��flag�����ҳ��������õ���,��ȡ��һ���������еĵ�i��λ��
	static void place(int i){
		if (i==result.length){
			for(int k = 0 ; k < result.length;k++){
				System.out.print(result[k]+1+"  ");  //��ӡʱ��1��ӡ��,012��ӡΪ123
 			}
			System.out.println();
			return;
		}
		
		for(int k = 0 ; k < flag.length ; k++){
			if (flag[k]){  //���k������
				result[i] = k;   //��k�ŵ�result����ĵ�i��λ��
				flag[k] = false; //���k������Ѿ��ù���,����������в��ٳ���
				place(i+1);  //����һ��λ��
				flag[k] = true; //��k�ͷ�,׼���ڵ�i��λ���ϼ�������k+1
			}
		}		
	}
}
		