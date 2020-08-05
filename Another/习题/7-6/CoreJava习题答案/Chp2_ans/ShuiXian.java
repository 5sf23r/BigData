package chp2;

public class ShuiXian {
	public static void main(String[] args) {
		//循环所有的三位数
		for(int i = 100; i<=999; i++){
			//分别获得三个位数上的值
			int a = i / 100;
			int b = i / 10 % 10;
			int c = i % 10;
			//计算各位数字的立方和
			int result = a*a*a + b*b*b + c*c*c;
			if (result == i){
				System.out.println(i);
			}
		}
	}
}
