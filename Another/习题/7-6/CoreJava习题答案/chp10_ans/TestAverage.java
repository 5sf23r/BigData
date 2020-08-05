package chp10;

import java.util.*;

class Student{
	private String name;
	private int age;
	private int score;
	private String classNum;
	
	public Student(String name, int age, int score, String classNum) {
		this.name = name;
		this.age = age;
		this.score = score;
		this.classNum = classNum;
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
	public String getClassNum() {
		return classNum;
	}
	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}
	
}

public class TestAverage {

	public static void main(String[] args) {
		List list = new ArrayList();
		list.add(new Student("Tom", 18, 100, "class05"));
		list.add(new Student("Jerry", 22, 70, "class04"));
		list.add(new Student("Owen", 25, 90, "class05"));
		list.add(new Student("Jim", 30,80 , "class05"));
		list.add(new Student("Steve", 28, 66, "class06"));
		list.add(new Student("Kevin", 24, 100, "class04"));
		
		//创建Map
		Map map = new HashMap();
		//对List中的每一个学生进行遍历，把学生依次放入map中
		for(int i = 0; i<list.size(); i++){
			Student stu = (Student) list.get(i);
			//获得学生的班号
			String classNum = stu.getClassNum();
			
			//如果班号存在，即说明该学生不是本班的第一个学生
			//则可以通过键，找到班级的List，并把该学生加入到班级List中
			if(map.containsKey(classNum)){
				List l = (List) map.get(classNum);
				l.add(stu);
			}
			//如果班号不存在，说明该学生是本班的第一个学生
			//则必须创建一个新list，并调用map的put方法，以
			//班号作为键，新创建的list作为值加入到map中去
			else{
				List l = new ArrayList();
				list.add(stu);
				map.put(stu.getClassNum(), l);
			}
		}
		
		//遍历Map
		Set set = map.keySet();
		Iterator iter = set.iterator();
		while(iter.hasNext()){
			//获得班号
			Object classNum = iter.next();
			//获得班级学生的List
			List stuList = (List)map.get(classNum);
			//根据stuList，计算平均分
			double sum = 0;
			for(int i = 0; i<stuList.size(); i++){
				sum += ((Student)stuList.get(i)).getScore();
			}
			System.out.println(classNum + " " + (sum / stuList.size()));
		}
		
	}

}
