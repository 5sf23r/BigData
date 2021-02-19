package chp14;
import java.net.*;
import java.io.*;

class ServerThread extends Thread{
	private Socket s;
	public ServerThread(Socket s){
		this.s = s;
	}
	public void run(){
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String line = br.readLine();
			line = line.toUpperCase();
			PrintWriter pw = new PrintWriter(s.getOutputStream());
			pw.println(line);
			pw.flush();
		}catch(Exception ex){}
		finally{
			try{s.close();}catch(Exception e){}
		}
	}
}

public class UpperCaseServer {

	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(9001);
		
		while (true){
			Socket s = ss.accept();
			ServerThread st = new ServerThread(s);
			st.start();
		}
	}

}
