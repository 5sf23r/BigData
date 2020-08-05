package chp13;

import java.io.*;
import java.util.*;

public class SaveObject2 {
	
	public static void saveWorkerToFile(Worker w, File file){
		PrintWriter pw = null;
		try {
			String str = w.getName() + "/" + w.getAge() + "/" + w.getSalary();
			FileOutputStream fout = new FileOutputStream(file, true);
			pw = new PrintWriter(fout);
			pw.println(str);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			if(pw != null) try{pw.close();}catch(Exception e){}
		}
	}
	
	public static List<Worker> readWorkerFromFile(File file){
		List<Worker> list = new ArrayList<Worker>();
		
		String line;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			while((line = br.readLine())!=null){
				String[] ss = line.split("/");
				Worker w = new Worker();
				w.setName(ss[0]);
				w.setAge(Integer.parseInt(ss[1]));
				w.setSalary(Double.parseDouble(ss[2]));
				list.add(w);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (br!=null) try{br.close();}catch(Exception e){}
		}
		return list;
	}
	
	public static void main(String[] args) {
		Worker w1 = new Worker("Tom", 30, 5000);
		Worker w2 = new Worker("Jerry", 28, 3500);
		
		File file = new File("Worker.txt");
		
		saveWorkerToFile(w1, file);
		saveWorkerToFile(w2, file);
		
		List<Worker> list = readWorkerFromFile(file);
		
		for(Worker w : list){
			System.out.println(w);
		}
	}

}
