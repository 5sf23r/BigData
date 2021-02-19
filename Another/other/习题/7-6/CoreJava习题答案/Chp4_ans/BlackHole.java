import java.util.Scanner;
public class BlackHole {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n % 1111 == 0){
			return;
		}
		while(n!=6174){
			//������תΪ����
			int[] a = intToArray(n);
			//�������������
			java.util.Arrays.sort(a);
			//�������������飬�����Сֵ
			int min = arrayToMin(a);
			//�������������飬������ֵ
			int max = arrayToMax(a);
			System.out.println(max + "-" +  min + "=" + (max-min) );
			n = max - min;
		}
	}
	public static int[] intToArray(int n){
		int[] a = new int[4];
		a[0] = n/1000;
		a[1] = n/100%10;
		a[2] = n/10%10;
		a[3] = n%10;
		return a;
	}
	public static int arrayToMin(int[] a){
		return a[0]*1000 + a[1] * 100 + a[2] * 10 + a[3];
	}
	public static int arrayToMax(int[] a){
		return a[3]*1000 + a[2] * 100 + a[1] * 10 + a[0];
	}
}
