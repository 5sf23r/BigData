package chp10.ex17;

public class Worker {
	private String name;
	private int age;
	private double salary;
	private Address address;
	public Worker(){}
	public Worker(String name, int age, double salary, Address address) {
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.address = address;
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public int hashCode(){
		int result = 0;
		result += (int)(age + salary);
		if (name != null) result += name.hashCode();
		if (address != null) result += this.address.hashCode();
		return result;
	}
	
	public boolean equals(Object obj){
		if (obj == null) return false;
		if (obj == this) return true;
		if (this.getClass() != obj.getClass()) return false;
		Worker w = (Worker) obj;
		if (w.name.equals(name) 
				&& w.age == age 
				&& w.salary == salary
				&& w.address.equals(this.address)){
			return true;
		}else{
			return false;
		}
	}
}
