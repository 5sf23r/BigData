package chp2;

public class MoveBricks {
	public static void main(String[] args) {
		for(int a = 0; a<=9; a++){
			for(int b = 0; b<=12; b++){
			    int c = 36 - a - b;
				if (c % 2 !=0) continue;
				if (a*4 + b*3 + c/2 == 36){
					System.out.println(a + "个男，" + b + "个女，" + c + "个小孩");
				}
			}
		}
	}
}
