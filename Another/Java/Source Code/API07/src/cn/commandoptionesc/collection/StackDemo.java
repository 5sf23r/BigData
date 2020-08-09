package cn.commandoptionesc.collection;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {

        Stack<String> s = new Stack<>();

        //添加元素 - 入栈
        s.push("a");
        s.push("b");
        s.push("c");
        s.push("d");

        //从栈顶到栈地来寻找指定的元素第一次出现的位置，注意从1开始计费
        System.out.println("b");

        //获取但是不移除栈顶元素
        //如果栈为空，则抛出EmptyStackException
        //System.out.println(s.peek());

        //获取但是移除栈顶元素
        //System.out.println(s.pop());

        //判断是否为空
        //System.out.println(s.empty());

        //判断栈是否为空
        System.out.println(s);
    }
}
