package cn.commandoptionesc.collection;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("f");
        list.add("e");
        list.add("a");
        list.add("y");
        list.add("e");
        //在列表的指定下标位置上来插入元素:[f,e,a,s,y,e]
        list.add(3,"s");
        //IndexOutOfBoundsException:下标越界
        //list.add(-1,"f");
        System.out.println(list);

        List<String> list2 = new ArrayList<>();
        list2.add("f");
        list2.add("e");
        list2.add("a");
        list2.add("y");
        list2.add("e");
        System.out.println(list.equals(list2));

        List<String> list3 = new ArrayList<>();
        list3.add(new String("f"));
        list3.add(new String("e"));
        list3.add(new String("a"));
        list3.add(new String("y"));
        list3.add(new String("e"));
        //比较两个list是否一致
        //逐位比较，每一位上的元素是否一致
        System.out.println(list.equals(list3));

        List<String> list4 = new ArrayList<>();
        list4.add("f");
        list4.add("e");
        list4.add("a");
        list4.add("y");
        list4.add("e");

        //获取指定下标位置上的元素
        System.out.println(list4.get(0));

        //获取指定元素第一次出现的下标
        //如果没有找到，则返回-1
        System.out.println(list4.indexOf("s"));

        //获取指定元素最后一次出现的下标
        System.out.println(list4.lastIndexOf("e"));

        //溢出指定的元素，但是注意，只移除第一个
        list4.remove("e");

        //移除指定位置上的元素
        list4.remove(0);

        //替换指定位置上的元素
        System.out.println(list.set(0,"h"));

        //截取字列表 - 包头不包尾
        System.out.println(list.subList(0,3));
    }
}
