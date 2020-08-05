package chp2;

public class HundredChick {
	public static void main(String[] args) {
		for(int a = 0; a<=33; a++){//最多33只公鸡
			for(int b = 0; b<=55; b++){//最多50只母鸡
				for(int c = 0 ; c <=100; c++) {
					if(c % 3 != 0) continue; //c必须是3的倍数
					int sumPrice = a*3 + b*2 + c/3; //计算总价
					if (sumPrice == 100 && a+b+c==100){
						System.out.println(a + "只公鸡，" + b + "只母鸡，" + c + "只小鸡");
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
						System.out.println(a + "男，" + b + "女，" + c + "小");
					}
				}
			}
		}
		*/
	}
}
