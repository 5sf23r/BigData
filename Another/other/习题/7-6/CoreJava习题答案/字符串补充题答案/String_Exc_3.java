package day18;

public class String_Exc_3 {
	public static void main(String[] args) {
		String str = "abcd23abc34bcd";
		String s = "bc";
		
		int start = 0;
		while(true){
			int i = str.indexOf(s, start);
			if (i==-1) break;
			System.out.println(i);
			start = i+s.length();
		}
	}

}
