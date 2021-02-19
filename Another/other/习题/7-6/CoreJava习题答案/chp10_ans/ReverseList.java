package chp10;
import java.util.*;
public class ReverseList {

	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("Hello");
		list.add("World");
		list.add("Learn");
		list.add("java");
		reverseList(list);
		printList(list);
	}
	
	public static void reverseList(List list){
		for(int i = 0; i<=list.size()/2; i++){
			Object t = list.get(i);
			list.set( i, list.get(list.size() - 1 - i));
			list.set(list.size() - 1 - i, t);
		}
	}
	
	public static void printList(List list){
		for(int i = 0; i<list.size(); i++){
			System.out.println(list.get(i));
		}
	}
}
