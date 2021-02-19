package chp10;
import java.util.*;

class MyStack{
	private List data = new LinkedList();
	
	public void push(Object obj){
		data.add(0, obj);
	}
	
	public Object pop(){
		if (this.isEmpty()) return null;
		Object obj = data.get(0);
		data.remove(0);
		return obj;
	}
	
	public Object peek(){
		if (this.isEmpty()) return null;
		Object obj = data.get(0);
		return obj;
	}
	
	public boolean isEmpty(){
		return (this.data.size() == 0);
	}
	
	public int size(){
		return this.data.size();
	}
}

public class TestStack {

	public static void main(String[] args) {
		MyStack ms = new MyStack();
		ms.push("hello");
		ms.push("world");
		ms.push("kettas");
		
		System.out.println(ms.pop());
		System.out.println(ms.pop());
		System.out.println(ms.pop());
		System.out.println(ms.pop());
		
	}

}
