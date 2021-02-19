package chp10.ex19;
import java.util.*;
public class TestAccount {
	public static void main(String args[]){
		List list = new ArrayList();
		list.add(new Account(10.00, "1234"));
		list.add(new Account(15.00, "5678"));
		list.add(new Account(0, "1010"));
		
		Map map = new HashMap();
		for(int i = 0; i<list.size(); i++){
			Account a = (Account) list.get(i);
			map.put(a.getId(), a);
		}
		
		Collection col = map.values();
		Iterator citer = col.iterator();
		while(citer.hasNext()){
			Account a = (Account) citer.next();
			System.out.println(a.getId() + " " + a.getBalance());
		}
	}
}
