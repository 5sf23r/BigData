package chp10;

public class Worker implements Comparable{
	private String name;
	private int age;
	private double salary;
	public Worker(){}
	public Worker(String name, int age, double salary){
		this.name = name;
		this.age = age;
		this.salary = salary;
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
	
	public double getSalary(){
		return salary;
	}
	
	public void setSalary(double salary){
		this.salary = salary;
	}
	
	public boolean equals(Object obj){
		if (obj == null) return false;
		if (obj == this) return true;
		if (this.getClass() != obj.getClass()) return false;
		Worker w = (Worker) obj;
		if (w.name.equals(name) && w.age == age && w.salary == salary){
			return true;
		}else return false;
	}
	
	public int hashCode(){
		int result = age;
		if (name != null) result += name.hashCode();
		result += (int) salary;
		return result;
	}

	public int compareTo(Object o) {
		if (o == null) return 1;
		if (o.getClass() != this.getClass()) return 1;
		Worker w = (Worker) o;
		if (w.age != this.age){
			return this.age - w.age;
		}
		else if (w.salary != this.salary){
			return (int)(this.salary - w.salary);
		}else{
			return this.name.compareTo(w.name);
		}
	}
}
