import java.util.Scanner;
public class SortThree {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a =sc.nextInt();
		int b =sc.nextInt() ;
		int c =sc.nextInt() ;
		
		//��α�֤��a��ֵ��b��
		if (a < b){
			int t = a; a = b; b = t;
		}
		//��α�֤��a��ֵ��c�����a����������
		if (a < c){
			int t = a; a = c; c = t;
		}
		//��α�֤��b��ֵ��c�����c����С������
		if (b < c){
			int t = b; b = c; c = t;
		}
		
		System.out.println(a + " " + b + " " + c);


	}
}
