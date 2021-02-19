package chp10;

import java.util.*;
public class TestCourse {

	public static void main(String[] args) {
		//1)
		Map map = new HashMap();
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
		Set set = map.keySet();
		Iterator iter = set.iterator();
		while(iter.hasNext()){
			Object key = iter.next();
			Object value = map.get(key);
			System.out.println(key + " --> " + value);
		}
		
		//输出所有教JSP的老师
		iter = set.iterator();
		while(iter.hasNext()){
			Object key = iter.next();
			Object value = map.get(key);
			if (value.equals("JSP")){
				System.out.println(key);
			}
		}
		
	}

}
