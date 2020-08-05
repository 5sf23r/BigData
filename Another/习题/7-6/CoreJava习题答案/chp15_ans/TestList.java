package chp15;
import java.lang.reflect.*;
public class TestList {
	public static void main(String args[]) throws Exception{
		//new
		Class c = Class.forName("java.util.ArrayList");
		Object obj = c.newInstance();
		
		//add
		Method m1 = c.getDeclaredMethod("add", Object.class);
		m1.invoke(obj, "hello");
		m1.invoke(obj, "world");
		
		//get
		Method m2 = c.getDeclaredMethod("get", int.class);
		Object value = m2.invoke(obj, 0);
		System.out.println(value);
	}
}
