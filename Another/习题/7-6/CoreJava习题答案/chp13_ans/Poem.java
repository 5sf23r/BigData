package chp13;
import java.io.*;
import java.util.*;
public class Poem {

	public static void main(String[] args) {
		BufferedReader br = null;
		List<String> list = new ArrayList<String>();
		try {
			FileInputStream fin = new FileInputStream("test.txt");
			Reader r = new InputStreamReader(fin, "GBK");
			br = new BufferedReader(r);
			String line;
			while( (line = br.readLine()) != null ){
				list.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if (br != null) try{br.close();}catch(Exception e){}
		}
		
		
		PrintWriter pw = null;
		try {
			FileOutputStream fout = new FileOutputStream("test2.txt");
			Writer w = new OutputStreamWriter(fout, "UTF-8");
			pw = new PrintWriter(w);
			for(int i = list.size() - 1; i>=0; i--){
				pw.println(list.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if (pw != null) try{pw.close();}catch(Exception e){}
		}
	}

}
