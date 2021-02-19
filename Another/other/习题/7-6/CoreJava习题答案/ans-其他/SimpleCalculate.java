package chp1;
import java.util.Scanner;
public class SimpleCalculate {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println("1 ： +");
		System.out.println("2 ： -");
		System.out.println("3 ： *");
		System.out.println("4 ： /");
		System.out.println("请输入您的选择：");
		int choice = sc.nextInt();
		switch(choice){
			case 1:
				System.out.println(a + "+" + b + "=" + (a + b));
				break;
			case 2:
				System.out.println(a + "-" + b + "=" + (a - b));
				break;
			case 3:
				System.out.println(a + "*" + b + "=" + (a * b));
				break;
			case 4:
				System.out.println(a + "/" + b + "=" + (a / b));
				break;
			default:
				System.out.println("没有这个选项！");
		}
	}
}
