package chp2;

public class HundredChick {
	public static void main(String[] args) {
		for(int a = 0; a<=33; a++){//���33ֻ����
			for(int b = 0; b<=55; b++){//���50ֻĸ��
				for(int c = 0 ; c <=100; c++) {
					if(c % 3 != 0) continue; //c������3�ı���
					int sumPrice = a*3 + b*2 + c/3; //�����ܼ�
					if (sumPrice == 100 && a+b+c==100){
						System.out.println(a + "ֻ������" + b + "ֻĸ����" + c + "ֻС��");
					}
				}
			}
		}
		/*
		for(int a = 0 ; a<=36 ; a ++) {
			for(int b = 0 ; b <=36; b++) {
				for(int c = 0; c <=36; c++) {
					if(c %2 != 0) continue;
					int z = a*4 + b *3 + c/2;
					if(z == 36 && a + b + c == 36) {
						System.out.println(a + "�У�" + b + "Ů��" + c + "С");
					}
				}
			}
		}
		*/
	}
}
