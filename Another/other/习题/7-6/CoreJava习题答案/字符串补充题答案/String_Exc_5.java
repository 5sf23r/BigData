package day18;
import java.util.*;
public class String_Exc_5 {
	public static void main(String[] args) {
		String str = "hfdsklfhdkyw3yodsldkfhqkghqKSBHlksnalkdhklsnxl1u8`8poqer32o5.cSDFc.,vx[=-=-=-r=324-=23";
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		
		for(int i = 0 ; i < str.length() ; i++){
			char c  = str.charAt(i);
			if (map.containsKey(c)){
				int m = map.get(c);
				map.put(c, m+1);
			}
			else{
				map.put(c, 1);
			}
		}
		
		Set<Character> keys = map.keySet();
		for(char c : keys){
			int i = map.get(c);
			System.out.println(c+" ---- "+i);
		}
	}

}
