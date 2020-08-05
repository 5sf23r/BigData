package cn.tedu.demo;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author ：cz
 * @date ：Created in 20/7/6 20:48
 * @version: 1.0$
 */
public class ChuanJiang3 {
    public static void main(String[] args) {
       /* Set<String> set=new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("b");
        System.out.println(set);
        for (String s:set){
            System.out.println(s);
        }*/
       //--会对添加进来的元素进行排序，默认是升序排序
       /* TreeSet<Integer> ts=new TreeSet<> ();
        ts.add(8);
        ts.add(1);
        ts.add(10);
        ts.add(100);*/

     TreeSet<Demo> set = new TreeSet<Demo> ();
     set.add(new Demo("zhangsan",77));
     set.add(new Demo("lisi",55));
     set.add(new Demo("wangwu",66));
     set.add(new Demo("zhaoliu",99));
     System.out.println(set);
     }
}
class Demo implements Comparable<Demo>{
   private  String name;
    private int age;

    public Demo(String name,int age) {
        this.age = age;
        this.name =name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    //--用来排序判断
    //--this在前是升序，this在后是降序
    public int compareTo(Demo o) {
        return o.age - this.age;
    }
}
