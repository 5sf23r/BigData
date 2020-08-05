package cn.tedu.domain;

public class Person {
	private String name;
	private int age;
	private String addr;
	
	public Person() {
	}
	
	public Person(String name, int age, String addr) {
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	public String getNamex() {
		return name;
	}
	public void setNamex(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
}
