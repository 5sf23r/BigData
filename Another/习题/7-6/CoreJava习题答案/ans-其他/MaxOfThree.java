package chp1;

//�㷨����������������a,b,b 
//���жϣ����a<b����a=b
//���жϣ����a<c����a=c
//���������ֵ�ͱ�����a��
import java.util.Scanner;

public class MaxOfThree {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		//���a��bС������a��ֵ����b
		//�����ܱ�֤a��ֵ��a��b�бȽϴ����
		if (a < b) {
			a = b;
		}
		
		//��������жϣ��ܱ�֤a��ֵ��a��c�бȽϴ����
		if (a<c){
			a = c;
		}
		
		//a�б������������������Ǹ�
		System.out.println(a);
	}
}
