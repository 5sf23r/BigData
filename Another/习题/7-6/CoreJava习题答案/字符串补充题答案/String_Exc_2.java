package day18;
import java.util.*;
public class String_Exc_2 {
	public static void main(String[] args) {
		int n = 8; 
		char[] cs = new char[n];
		Random r = new Random();
		
		for(int i = 0 ; i < n ; i++){
			//Îªcs[i]¸³Öµ
			int a  = r.nextInt(62);
			if (a >=0 && a <= 25) a+=65;
			else if (a >=26 && a <= 51) a+=71;
			else a-=4;
			
			cs[i] = (char)a;
		}
		
		String str = new String(cs);
		
		System.out.println(str);
		
	}

}
