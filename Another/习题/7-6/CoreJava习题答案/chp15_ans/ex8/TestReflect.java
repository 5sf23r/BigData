package chp15.ex8;
import java.io.*;
public class TestReflect {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("person.conf"));
		String className = br.readLine();
		String name = br.readLine();
		int age = Integer.parseInt(br.readLine());
		br.close();
		
		Person p = (Person) Class.forName(className).newInstance();
		p.setName(name);
		p.setAge(age);
		p.work();
	}

}
