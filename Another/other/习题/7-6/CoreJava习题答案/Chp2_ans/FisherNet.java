package chp2;

import java.util.Scanner;
public class FisherNet {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		//int year = sc.nextInt();
		//int month = sc.nextInt();
		//int day = sc.nextInt();
		
		//ͳ��2000��1��1�յ�year��1��1�չ��˶�����
		//int days = 0;
		java.util.Date d1 = new java.text.SimpleDateFormat("yyyyMMdd").parse("20000106");
		java.util.Date d2 = new java.text.SimpleDateFormat("yyyyMMdd").parse("19991231");
		int days = (int)(d1.getTime()-d2.getTime())/1000/3600/24;
		
		int result = days % 5;
		if (result == 1 || result == 2 || result ==3){
			System.out.println("����");
		}else{			
			System.out.println("ɹ��");
		}
	}
}
