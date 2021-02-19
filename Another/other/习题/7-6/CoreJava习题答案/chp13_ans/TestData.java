package chp13;

import java.io.*;
public class TestData {

	public static void main(String[] args) {
		File file = new File("test.dat");
		long data = 0;
		if (file.exists()){
			DataInputStream din = null;
			try {
				din = new DataInputStream(new FileInputStream(file));
				data = din.readLong();
			} catch (FileNotFoundException e) {
			} catch (IOException e) {
			}finally{
				if (din != null) try{din.close();}catch(Exception e){}
			}
			data++;
		}else{
			data = 10000L;
		}
		
		DataOutputStream dout = null;
		try {
			dout = new DataOutputStream(new FileOutputStream(file));
			dout.writeLong(data);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (dout != null)
				try {
					dout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		System.out.println(data);
	}

}
