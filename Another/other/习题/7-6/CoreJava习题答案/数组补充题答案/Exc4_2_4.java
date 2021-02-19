package day8;
public class Exc4_2_4{
	public static void main(String[] args){
		for(int a = 1 ; a<10 ; a++){
			for(int b =0 ;b < 10 ; b++){
				if (b == a) continue;
				for(int c =0 ; c<10 ; c++){
					if (c == a || c == b) continue;
					for(int d =0 ; d<10 ; d++){
						if (d == a || d==b||d==c) continue;
						for(int e =0 ; e<10 ; e++){
							if (e==a || e==b || e==c || e==d) continue;
							int abcd = 1000*a+100*b+10*c+d;
							int dcba = 1000*d+100*c+10*b+a;
							if (abcd*e == dcba) System.out.println(abcd+"   "+e); 
						}
					}
				}
			}
		}
	}
}