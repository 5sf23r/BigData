package cn.commandoptionesc.collection;


import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {

        //创建了一个队列
        Queue<String> queue = new LinkedList<>();

        //添加元素
        queue.add("a");
        queue.add("a");
        queue.add("a");

        //往外拿元素
        System.out.println(queue.poll());
        System.out.println(queue);

    }
}
