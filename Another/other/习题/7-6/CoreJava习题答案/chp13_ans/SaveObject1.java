package chp13;

import java.io.*;

public class SaveObject1 {

	public static void main(String[] args) throws Exception {
		Worker w1 = new Worker("Tom", 30, 5000);
		Worker w2 = new Worker("Jerry", 28, 3500);
		
		ObjectOutputStream oout = new ObjectOutputStream(
				new FileOutputStream("worker.dat"));
		oout.writeObject(w1);
		oout.writeObject(w2);
		
		oout.close();
		
		ObjectInputStream oin = new ObjectInputStream(
				new FileInputStream("worker.dat"));
		Object o1 = oin.readObject();
		Object o2 = oin.readObject();
		System.out.println(o1);
		System.out.println(o2);
		
	}

}
