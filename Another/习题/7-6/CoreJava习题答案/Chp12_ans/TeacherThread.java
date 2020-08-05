package chp12;

interface Teacher{
	void answer(Student stu);
}

class MyThread extends Thread{
	private Student stu;
	public MyThread(Student stu){
		this.stu = stu;
	}
	public void run(){
		stu.study();
		stu.doHomework();
	}
}

class TeacherImpl implements Teacher{
	public void answer(Student stu){
		Thread t = new MyThread(stu);
		t.start();
	}
}

class Student{
	String name;
	int age;
	//构造方法和get/set方法请自行补充完成
	public Student(){}
	
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}


	//学生问老师问题
	public void ask(Teacher t){
		t.answer(this);//调用老师的answer方法
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

	public void study(){
		System.out.println(name + " study");
	}

	public void doHomework(){
		System.out.println(name +" do homework");
	}
}


public class TeacherThread {
	public static void main(String args[]){
		Teacher t1 = new TeacherImpl();
		Student s1 = new Student("Tom", 18);
		Student s2 = new Student("Jerry", 16);
		s1.ask(t1);
		s2.ask(t1);
	}
}
