package day8;
import java.util.*;
public class Exc4_2_6{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		
		int num = a*a*a;
		
		//��ʽ  (n+i-1)*i=num  n��ʾ���е�һ��,����������,i��ʾ����Ԫ�ظ���
		for(int i = 2 ; i<=(int)Math.sqrt(num) ; i++){
			if (num % i == 0){
				int n = num/i+1-i;
				if (n <0 || n %2==0) continue;
				for(int k = n ; k<= n+(i-1)*2 ; k+=2){
					System.out.print(k+"  ");
				}
				System.out.println();
			}
		}
		
	}
}
