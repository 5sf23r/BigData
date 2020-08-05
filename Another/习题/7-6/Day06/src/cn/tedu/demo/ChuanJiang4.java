package cn.tedu.demo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：cz
 * @date ：Created in 20/7/6 20:59
 * @version: 1.0$
 */
public class ChuanJiang4 {
    public static void main(String[] args) {
        Queue<String> q=new LinkedList<>();
        q.add("a");
        q.add("b");
        q.add("c");
        System.out.println(q.poll());
        System.out.println(q);
    }
}
