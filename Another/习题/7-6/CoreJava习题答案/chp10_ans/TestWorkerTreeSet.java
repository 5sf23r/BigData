package chp10;
import java.util.*;
public class TestWorkerTreeSet {

	public static void main(String[] args) {
		Set set = new TreeSet();
		set.add(new Worker("zhang3", 18, 1500));
		set.add(new Worker("zhang3", 18, 1500)); //ÖØ¸´ÔªËØ
		set.add(new Worker("li4", 18, 1500));
		set.add(new Worker("wang5", 18, 1600));
		set.add(new Worker("zhao6", 17, 2000));
		
		Iterator iter = set.iterator();
		while(iter.hasNext()){
			Worker w = (Worker) iter.next();
			System.out.println(w.getName() + " " + w.getAge() +" " + w.getSalary());
		}
	}
}
