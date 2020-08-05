package chp15;

import java.lang.reflect.*;
class Address {
	private String address;
	private String zipCode;
	
	public Address(){
		
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}
class Student {
	private String name;
	private int age;
	private int score;
	private Address addr;
	
	public Student(){
		
	}
	
	public char getLevel(){
		return 'A';
	}
	
	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
}


public class ToJson {

	public static void main(String[] args) throws Exception {
		Student stu = new Student();
		stu.setAge(18);
		stu.setName("limy");
		stu.setScore(100);
		
		Address addr = new Address();
		addr.setAddress("beijing");
		addr.setZipCode("100000");
		
		stu.setAddr(addr);
		
		System.out.println(toJson(stu));
	}
	
	public static String toJson(Object o) throws Exception{
		Class c = o.getClass();
		Method[] ms = c.getMethods();
		//sb为最后的结果，一开始只有一个左花括号
		StringBuffer sb = new StringBuffer("{");
		
		for(Method m : ms){
			//如果一个方法以get开头并且方法名不是getClass
			if (m.getName().startsWith("get") && !m.getName().equals("getClass")){
				//则获得该属性名
				StringBuffer attrName = new StringBuffer(m.getName().substring(3));
				//把首字母由大写转小写
				attrName.setCharAt(0, (char)(attrName.charAt(0) + 32 )  );
				
				sb.append("\"").append(attrName).append("\":");
				
				//value为getXXX方法返回值
				Object value = m.invoke(o);
				//rtType是getXXX方法的返回值类型
				Class rtType = m.getReturnType();
				
				//如果返回值类型是基本类型或者字符串，则直接追加到结果中
				//否则递归调用
				if (rtType.isPrimitive() || rtType == String.class){
					sb.append("\"").append(value).append("\"");
				}else{
					sb.append(toJson(value));
				}
				sb.append(",");
			}
		}
		//去掉最后一个逗号。然后加上右边的花括号
		sb.deleteCharAt(sb.length() - 1);
		sb.append("}");
		return sb.toString();
		
	}

}
