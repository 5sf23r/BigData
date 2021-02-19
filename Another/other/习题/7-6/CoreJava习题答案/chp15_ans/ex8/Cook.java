package chp15.ex8;

public class Cook implements Person{
	private int age;
	private String name;
	@Override
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void work() {
		System.out.println("Cook make meals");
	}

}
