package chp13;

import java.util.*;
import java.io.*;

import java.util.Scanner;

public class TestWorldCup {

	public static void main(String[] args) {
		BufferedReader br = null;
		Map<String, String> map = new HashMap<String, String>();
		
		try{
			FileInputStream fin = new FileInputStream("worldcup.txt");
			InputStreamReader r = new InputStreamReader(fin);
			br = new BufferedReader(r);
			String line;
			while( (line = br.readLine() ) != null){
				String[] ss = line.split("/");
				map.put(ss[0], ss[1]);
			}
		}catch(Exception e){}
		finally{
			if (br!=null) try{br.close();}catch(Exception e){}
		}
		
		Scanner sc = new Scanner(System.in);
		String year = sc.nextLine();
		if (map.containsKey(year)){
			System.out.println(map.get(year));
		}else{
			System.out.println("没有举行世界杯");
		}
		
	}

}
