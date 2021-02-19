package chp10.ex17;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestWorker {
	public static void main(String[] args) {
		Set set = new HashSet();
		Address addr1 = new Address("清华大学", "100001");
		Address addr2 = new Address("北京大学", "100002");
		set.add(new Worker("Tom", 18, 1000, addr1));
		set.add(new Worker("Jim", 19, 2000, addr1));
		set.add(new Worker("Tom", 18, 1000, addr2)); // 测试重复元素
		set.add(new Worker("Tom", 18, 1000, addr1)); // 测试重复元素
		
		Iterator iter = set.iterator();
		while(iter.hasNext()){
			Object obj = iter.next();
			Worker w = (Worker) obj;
			System.out.println(w.getName() + " " +w.getAge() + " " + w.getSalary());
			System.out.println(w.getAddress().getAddressName() + " " + w.getAddress().getZipCode());
		}
	}
}
