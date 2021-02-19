package chp3;

public class Hanoi {
	public static void main(String args[]){
		hanoi('A', 'C', 'B', 3);
	}
	public static void hanoi(char from, char to, char transit, int n){
		if (n == 1){
			System.out.println(from + " ---> " + to);
			return;
		}
		hanoi(from, transit, to, n-1);
		System.out.println(from + " ---> " + to);
		hanoi(transit, to, from, n-1);
	}
}
