package day18;

public class String_Exc_4 {
	public static void main(String[] args) {
		String str = "1239586838923173478943890234092";
		int[] c = new int[10];
		
		for(int i = 0 ; i < str.length(); i++){
			char ch = str.charAt(i);
			int a = ch-48;
			c[a]++;
		}
		
		for(int i : c){
			System.out.println(i);
		}
	}

}
