package cn.commandoptionesc.type;

import java.util.ArrayList;
import java.util.List;

public class TypeDemo {
    public static void main(String[] args) {

        //在JDK1.5之前，没有泛型的概念，此时集合中的元素类型可以是任意类型
        //可以通过泛型规定元素类型，使得集合中的元素就统一了
        //再去使用集合的时候就不需要考虑类型带来的问题
        //List<String> list = new ArrayList<String>();
        //从JDK1.7开始，允许后边可以不写泛型，会根据前边的类型进行自动的推导
        //List<String> list = new ArrayList<>();

        List list = new ArrayList();
        list.add("a");
        list.add(2);
        list.add(true);

        for (Object o : list) {
            //需要判断类型之后才操作
            if (o instanceof String) {
                System.out.println("这是一个字符串");
                String str = (String) o;
            } else if (o instanceof Integer) {
                System.out.println("这是一个整数");
                Integer i = (Integer) o;

            }
        }
    }
}
