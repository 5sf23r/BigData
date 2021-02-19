package chp14;

import java.net.*;
import java.io.*;

class MyServerThread extends Thread{
	Socket s;
	public MyServerThread(Socket s){
		this.s = s;
	}
	public void run(){
		BufferedInputStream bin = null;
		try{
			//从客户端读入文件名
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String name = br.readLine();
			
			//利用读入的文件名，创建文件输入流
			FileInputStream fin = new FileInputStream(name);
			bin = new BufferedInputStream(fin);
			byte[] bs = new byte[100];
			//创建针对客户端的输出流
			BufferedOutputStream bout = new BufferedOutputStream(s.getOutputStream());
			
			int len = 0;
			while( (len = bin.read(bs)) != -1){
				bout.write(bs, 0 ,len);
			}
			bout.flush();
		}catch(Exception e){
			
		}finally{
			try{s.close();}catch(Exception e){}
			if (bin != null) try{ bin.close(); }catch(Exception e){}
		}
	}
}

public class FtpServer {
	public static void main(String args[]) throws Exception{
		ServerSocket ss = new ServerSocket(9000);
		while(true){
			Socket s = ss.accept();
			MyServerThread mst = new MyServerThread(s);
		}
	}
}
