package chp2;

public class TestPi {

	public static void main(String[] args) {
		double pi = 0; //累加统计pi的值
		double base = 1; //分母
		int prefix = 1;  //用来计算是加还是减
		int i = 0;		//统计进行了多少次加减运算
		while(pi < 3.1415926 || pi > 3.1415927){
			pi += prefix * 4 / base;
			i ++;
			prefix *= -1;
			base += 2;
		}
		System.out.println(i);
	}
}
