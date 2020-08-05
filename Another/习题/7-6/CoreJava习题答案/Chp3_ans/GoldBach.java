package chp3;

import java.util.Scanner;

public class GoldBach {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 3; i<= n/2; i+=2){
			//��n���i��n-i
			//�ֱ��ж�i��n-1�Ƿ�Ϊ����
			//�������������Ϊ��������֤������һ���
			if (isPrime(i) && isPrime(n-i)){
				System.out.println(n + "=" + i + "+" + (n-i));
			}
		}
	}
	public static boolean isPrime(int n){
		for(int i = 2; i<=Math.sqrt(n); i++){
			if (n % i == 0) return false;
		}
		return true;
	}
}
