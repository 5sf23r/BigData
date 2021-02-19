package chp10;
import java.util.*;
public class TestWorkerHashSet {

	public static void main(String[] args) {
		Set set = new HashSet();
		set.add(new Worker("Tom", 18, 1000));
		set.add(new Worker("Jim", 19, 2000));
		set.add(new Worker("Tom", 18, 1000)); // ²âÊÔÖØ¸´ÔªËØ
		
		Iterator iter = set.iterator();
		while(iter.hasNext()){
			Object obj = iter.next();
			Worker w = (Worker) obj;
			System.out.println(w.getName() + " " +w.getAge() + " " + w.getSalary());
		}
	}

}
