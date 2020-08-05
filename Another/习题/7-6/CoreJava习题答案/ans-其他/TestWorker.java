class Worker{
	String name;
	int age;
	double salary;
	Address addr;
	public Worker(){}
	public Worker(String name, int age, double salary){
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	public void work(){
		System.out.println("work");
	}
	public void work(int hours){
		System.out.println("worker works for " + hours + " hours");
	}
}

class Address{
	String address;
	String zipCode;
	public Address(){	}
	public Address(String address, String zipCode){
		this.address = address;
		this.zipCode = zipCode;
	}
}

public class TestWorker{
	public static void main(String args[]){
		Worker w = new Worker("zhangsan", 25, 2500);
		Address addr = new Address("北京市海淀区清华园1号", "100084");
		w.setAddr(addr);
	}
}







