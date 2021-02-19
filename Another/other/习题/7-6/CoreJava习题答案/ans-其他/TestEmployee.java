package chp6;

//1. name和birthMonth是每个员工都应该具有的属性，因此应当放在Employee类中
//2. 子类无法直接访问这两个属性，但是可以利用super()在构造方法中设置父类的属性
//3. 判断员工是否过生日的逻辑也是所有员工都有的逻辑。这个逻辑应当写在Employee类。
//4. 子类的getSalary方法应当利用super.getSalary来调用父类的getSalary方法

public class TestEmployee {
	public static void main(String[] args) {
		Employee[] es = new Employee[4];
		es[0] = new SalariedEmployee("John", 5, 5000);
		es[1] = new HourlyEmployee("Tom", 10, 25, 170);
		es[2] = new SalesEmployee("Lucy", 7, 200000, 0.03);
		es[3] = new BasePlusSalesEmployee("James", 8, 1000000, 0.02, 5000);
		
		for(int i = 0; i<es.length; i++){
			System.out.println(es[i].getSalary(5));
		}
	}
}
class Employee{
	private String name;
	private int birthMonth;
	public Employee(String name,int birthMonth){
		this.name=name;
		this.birthMonth=birthMonth;
	}
	public String getName(){
		return name;
	}
	public double getSalary(int month){
		if (this.birthMonth==month) return 100;
		else return 0;
	}
}
class SalariedEmployee extends Employee{
	private double salary;
	public SalariedEmployee(String name,int birthMonth,double salary){
		//把name，birthMonth两个参数传给父类，设置父类属性
		super(name,birthMonth);
		this.salary=salary;
	}
	public double getSalary(int month){
		//调用父类的getSalary方法（判断是否生日），并加上月工资
		return salary+super.getSalary(month);
	}
}
class HourlyEmployee extends Employee{
	private double salaryPerHour;
	private int hours;
	public HourlyEmployee(String name, int birthMonth, double salaryPerHour, int hours) {
		super(name, birthMonth);
		this.salaryPerHour = salaryPerHour;
		this.hours = hours;
	}
	public double getSalary(int month){
		double result=0;
		if (hours>160) result=160*this.salaryPerHour+(hours-160)*this.salaryPerHour*1.5;
		else result=this.hours*this.salaryPerHour;
		return result+super.getSalary(month);
	}
}
class SalesEmployee extends Employee{
	private double sales;
	private double rate;
	public SalesEmployee(String name, int birthMonth, double sales, double rate) {
		super(name, birthMonth);
		this.sales = sales;
		this.rate = rate;
	}
	public double getSalary(int month) {
		return this.sales*this.rate+super.getSalary(month);
	}
}
class BasePlusSalesEmployee extends SalesEmployee{
	private double basedSalary;
	public BasePlusSalesEmployee(String name, int birthMonth, double sales, double rate, double basedSalary) {
		super(name, birthMonth, sales, rate);
		this.basedSalary = basedSalary;
	}
	public double getSalary(int month) {
		return this.basedSalary+super.getSalary(month);
	}
}
