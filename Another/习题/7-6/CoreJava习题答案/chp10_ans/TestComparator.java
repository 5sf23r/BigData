package chp10;

import java.util.*;

class AgeComparator implements Comparator{

	public int compare(Object o1, Object o2) {
		Worker w1 = (Worker) o1;
		Worker w2 = (Worker) o2;
		if (w1.getAge() > w2.getAge()) return -1;
		else if (w1.getAge() < w2.getAge()) return 1;
		else return 0;
	}
}

class SalaryComparator implements Comparator{
	public int compare(Object o1, Object o2) {
		Worker w1 = (Worker) o1;
		Worker w2 = (Worker) o2;
		return (int)(w1.getSalary() - w2.getSalary());
	}
}

class NameComparator implements Comparator{
	public int compare(Object o1, Object o2) {
		Worker w1 = (Worker) o1;
		Worker w2 = (Worker) o2;
		return w1.getName().compareTo(w2.getName());
	}
}

public class TestComparator {

	public static void main(String[] args) {
		List list = new ArrayList();
		list.add(new Worker("Tom", 20, 3000));
		list.add(new Worker("Jim", 25, 2500));
		list.add(new Worker("Jerry", 22, 3500));
		
		Collections.sort(list, new AgeComparator());
		print(list);
		System.out.println("-----------------------");
		Collections.sort(list, new SalaryComparator());
		print(list);
		System.out.println("-----------------------");
		Collections.sort(list, new NameComparator());
		print(list);
	}
	
	public static void print(List list){
		for(int i = 0; i<list.size(); i++){
			Worker w = (Worker) list.get(i);
			System.out.println(w.getName() + " " + w.getAge() + " " + w.getSalary());
		}
	}

}
