package chp10.ex17;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestWorker {
	public static void main(String[] args) {
		Set set = new HashSet();
		Address addr1 = new Address("�廪��ѧ", "100001");
		Address addr2 = new Address("������ѧ", "100002");
		set.add(new Worker("Tom", 18, 1000, addr1));
		set.add(new Worker("Jim", 19, 2000, addr1));
		set.add(new Worker("Tom", 18, 1000, addr2)); // �����ظ�Ԫ��
		set.add(new Worker("Tom", 18, 1000, addr1)); // �����ظ�Ԫ��
		
		Iterator iter = set.iterator();
		while(iter.hasNext()){
			Object obj = iter.next();
			Worker w = (Worker) obj;
			System.out.println(w.getName() + " " +w.getAge() + " " + w.getSalary());
			System.out.println(w.getAddress().getAddressName() + " " + w.getAddress().getZipCode());
		}
	}
}
