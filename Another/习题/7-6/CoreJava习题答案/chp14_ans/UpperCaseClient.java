package chp14;
import java.net.*;
import java.io.*;
public class UpperCaseClient {

	public static void main(String[] args) throws Exception {
		Socket s = new Socket("127.0.0.1", 9001);
		
		//封装过滤流
		PrintWriter pw = new PrintWriter(s.getOutputStream());
		//写数据
		pw.println("hello world");
		//注意刷新缓冲区
		pw.flush();
		
		//输入流
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String line = br.readLine();
		
		System.out.println(line);
		
		//关闭socket
		s.close();
	}

}
