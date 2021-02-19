package cn.tedu.demo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

/**
 * @author ：cz
 * @date ：Created in 20/7/6 20:03
 * @version: 1.0$
 */
public class ChuanJiang2 {
    public static void main(String[] args) {
     /*   Vector<String> v=new Vector<>();
        v.add("a");
        v.add("b");
        v.add("c");
        v.add("c");
        v.add("c");
        v.add("c");
        v.add("c");
        v.add("c");
        v.add("c");
        v.add("c");
        v.add("c");
        System.out.println(v.capacity());*/
        Stack<String> s=new Stack<String> ();
        //--添加元素
        s.push("a");
        s.push("b");
        s.push("c");
        s.push("d");
//        System.out.println(s.isEmpty());
       //--获取栈顶部对象，但是不移除它
//        System.out.println(s.peek());
        //--获取栈顶部对象，并且移除，返回值就是获取的对象
//        System.out.println(s.pop());
//        System.out.println(s);
        System.out.println(s.search("b"));


    }
}
