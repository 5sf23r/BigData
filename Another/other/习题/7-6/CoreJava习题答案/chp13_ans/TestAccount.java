package chp13;
import java.io.*;
class Account{
	private final long id;
	
	private final File file = new File("id.dat");
	
	public Account(){
		//从文件中读id
		long data = readIdFromFile();
		//id++
		data ++;
		id = data;
		//把新id保存到文件中
		saveIdToFile(data);
	}
	
	public long getId(){
		return id;
	}
	
	private long readIdFromFile(){
		//文件不存在，说明程序是第一次运行，之前没有id
		//这样的话，则返回初始值
		if (!file.exists()){
			return 10000;
		}else{
			DataInputStream din = null;
			long data = -1;
			try {
				FileInputStream fin = new FileInputStream(file);
				din = new DataInputStream(fin);
				data = din.readLong();
			} catch (Exception e) {
			}finally{
				if (din != null) try{din.close();}catch(Exception e){}
			}
			return data;
		}
	}
	
	private void saveIdToFile(long id){
		DataOutputStream dout = null;
		try {
			FileOutputStream fout = new FileOutputStream(file);
			dout = new DataOutputStream(fout);
			dout.writeLong(id);
		} catch (Exception e) {
		
		}finally{
			if (dout != null) try{dout.close();}catch(Exception e){}
		}
	}
}


public class TestAccount {
	public static void main(String[] args) {
		Account a1 = new Account();
		Account a2 = new Account();
		Account a3 = new Account();
		System.out.println(a1.getId());
		System.out.println(a2.getId());
		System.out.println(a3.getId());
	}
}
