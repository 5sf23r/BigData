package chp10;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
public class TestCourse2 {

	public static void main(String[] args) {
		//1)
		Map<String, String> map = new HashMap<String,String>();
		map.put("Tom", "CoreJava");
		map.put("John", "Oracle");
		map.put("Susan", "Oracle");
		map.put("Jerry", "JDBC");
		map.put("Jim", "Unix");
		map.put("Kevin", "JSP");
		map.put("Lucy", "JSP");
		
		//2) 增加了一个Allen教JDBC
		map.put("Allen", "JDBC");
		
		//3) Lucy改教CoreJava
		map.put("Lucy", "CoreJava");
		
		//遍历Map
		Set<Map.Entry<String, String>> set = map.entrySet();
		Iterator<Map.Entry<String, String>> iter = set.iterator();
		while(iter.hasNext()){
			Map.Entry<String, String> entry = iter.next();
			System.out.println(entry.getKey() + "-->" + entry.getValue());
		}
	}

}