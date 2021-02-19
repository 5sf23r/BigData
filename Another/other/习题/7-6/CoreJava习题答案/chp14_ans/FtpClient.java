package chp14;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class FtpClient {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		Socket s = new Socket("127.0.0.1", 9000);
		
		//向服务器端发送文件名
		PrintWriter pw = new PrintWriter(s.getOutputStream());
		pw.println(name);
		
		//创建文件输出流
		FileOutputStream fout = new FileOutputStream("server_" + name);
		BufferedOutputStream bout = new BufferedOutputStream(fout);
		
		//创建输入流，用来从服务器端获取数据
		BufferedInputStream bin = new BufferedInputStream(s.getInputStream());
		
		byte[] bs = new byte[100];
		int len = 0;
		while( (len = bin.read(bs)) != -1 ){
			bout.write(bs, 0, len);
		}
		bout.close();
		s.close();
	}

}
