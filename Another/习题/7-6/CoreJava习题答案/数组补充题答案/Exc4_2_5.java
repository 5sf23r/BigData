package day8;
public class Exc4_2_5{
	public static void main(String[] args){
		char a,b,c; // a��ʾ��a������ ���� a='x' ��ʾa��x���
		
		for(a = 'X' ; a<='Z'; a++){
			for(b = 'X' ; b<='Z';b++){
				if (b == a) continue;
				for(c = 'X' ; c<='Z';c++){
					if (c ==a || c==b) continue;
					if (a == 'X' || c=='X' || c == 'Z') continue;
					System.out.println("A--"+a+"   B--"+b+"   C--"+c);
				}
			}
		}
	}
}