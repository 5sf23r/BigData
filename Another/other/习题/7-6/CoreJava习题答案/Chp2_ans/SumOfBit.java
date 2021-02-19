package chp2;

import java.util.Scanner;

//由于t & 1可以用来判断最低位是否为1
//因此对每个整数，都分别移位0，1，2，... 31
//然后用&1，就能判断这个整除的0，1，2，... 31位是否为1

public class SumOfBit {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		for(int i = 0; i<32; i++){
			int t = n >> i;
			//判断最低位是否为1
			if ( (t & 1) == 1){
				sum ++;
			}
		}
		System.out.println(sum);
	}
}
