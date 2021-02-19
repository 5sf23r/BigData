package chp11;

import java.util.Scanner;

class MyException1 extends Exception {

	public MyException1() {
		super();
	}

	public MyException1(String message) {
		super(message);
	}

}

class MyException2 extends RuntimeException {

	public MyException2() {
		super();
	}

	public MyException2(String message) {
		super(message);
	}

}

public class TestMyException {

	public static void main(String args[]) {
		int n;
		// 读入n
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		try {
			m(n);
		} catch (MyException1 ex1) {
			// 输出ex1详细的方法调用栈信息
			ex1.printStackTrace();
		} catch (MyException2 ex2) {
			// 输出ex2的详细信息
			System.out.println(ex2.getMessage());
			// 并把ex2重新抛出
			throw ex2;
		}
	}

	public static void m(int n) throws MyException1 { // 声明抛出MyException1
		if (n == 1) {
			// 抛出MyException1
			// 并设定其详细信息为“n == 1”
			throw new MyException1("n == 1");
		} else {
			// 抛出MyException2
			// 并设定其详细信息为“n == 2”
			throw new MyException2("n == 2");
		}
	}

}
