package cn.commandoptionesc.collection;

import java.util.Arrays;
import java.util.Objects;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrList list = new ArrList(3);
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        list.add(0,"f");

        System.out.println(list.indexOf("c"));
        list.remove(0);
        System.out.println(list);
    }
}

//模拟ArrayList
class ArrList{

    //需要先定义一个数组来存储元素
    private String[] data;
    //表示元素个数，也表示要添加的元素的下标
    private  int size = 0;

    public ArrList(){

        //如果没有参数，则数组的初始容量定义为10
        data = new String[10];
    }

    public ArrList(int initialCapacity){

        //需要先判断这个容量是否合法
        if(initialCapacity < 0)
            throw new IllegalArgumentException();
        //如果容量合法，则赋值
        data = new String[initialCapacity];
    }

    //添加元素
    public void add(String str){

        //判断是否需要扩容
        if(size >= data.length)
            grow();
        data[size] = str;
        size++;
    }

    //扩容
    private  void grow(){
        if(data.length <= 1)
            data = Arrays.copyOf(data,data.length + 1);
        else
            data = Arrays.copyOf(data,data.length + (data.length >> 1));
    }

    //插入元素
    public void add(int index,String str){

        //判断插入的下标是否越界
        if(index > size || index < 0)
            throw new IndexOutOfBoundsException("size:" + size + ",Index:" + index);

        //判断是否需要扩容
        if(size >= data.length)
            grow();

        for(int i = size - 1;i >= index;i--){
            data[i + 1] = data[i];
        }

        //将元素放入index位
        data[index] = str;

        //元素个数+1
        size++;
    }
    //清空列表
    public void clear(){

        data = new String[10];
        size = 0;
    }

    //获取指定元素第一次出现的下标
    //data[i] = null
    //str = null
    public int indexOf(String str){

        for(int i = 0;i < size;i++){
            if(data[i] == str || data[i] != null && data[i].equals(str))
                return i;
        }
        //如果整个循环结束都没有返回，那就说明没有这个元素
        return -1;
    }

    //判断是否有指定的元素
    public boolean contains(String str){

        int index = indexOf(str);
        return index != -1;
    }

    @Override
    public boolean equals(Object obj){
        //判断地址是否一致
        if(this == obj)
            return true;

        //判断参数是否为空
        if(obj == null)
            return false;

        if(obj.getClass() != this.getClass())
            return  false;

        ArrList list = (ArrList) obj;

        if(this.size != list.size)
            return false;

        for(int i = 0;i < size; i++){
            String s1 = this.data[i];
            String s2 = list.data[i];
            if(s1 == null){
                if(s2 != null)
                    return false;
            }else if(!s1.equals(s2))
                return false;
        }
        return true;
    }

    //判断下标是否越界
    private void outOfIndex(int index){
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Size:" + size + ",Index:" + index);
    }

    //获取指定下标上的元素
    public String get(int index){

            //判断下标是否越界
            outOfIndex(index);

            return data[index];
    }

        //判断集合是否为空
        public boolean isEmpty() {
            return size == 0;
        }

        //获取指定元素最后一次出现的下标
    public int lastIndexOf(String str){
        for(int i = size - 1;i >= 0;i--){
            if(data[8] == str || data[i] != null && data[i].equals(str))
                return i;
        }
        return -1;
    }

    //移除指定下标位置上的元素
    public void remove(int index){

        //判断下标是否越界
        outOfIndex(index);
        for(int i = index;i < size -1;i++){
            data[i] = data[i + 1];
        }
        size--;
    }

    //移除指定的元素,注意只移除第一个
    public void remove(String str){

        //获取元素的下标
        int index = indexOf(str);

        if(index != -1){
            this.remove(index);
        }
    }

    //替换指定位置上的元素
    public void set(int index,String str){
        //判断下标是否越界
        outOfIndex(index);
        data[index] = str;
    }

    //获取元素个数
    public int size(){
        return size;
    }

    //截取子列表
    public ArrList subList(int fromIndex,int toIndex){

        //判断下标是否合法
        if(toIndex < fromIndex || fromIndex < 0 || toIndex < 0 || fromIndex > size || toIndex > size)
            throw new IllegalArgumentException();
        ArrList sub = new ArrList();
        for(int i = fromIndex;i < toIndex;i++){
            sub.add(data[i]);
        }
        return sub;
    }

    //重写toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for(int i = 0;i < size;i++){
            sb.append(data[i]).append(",");
        }

        String str = sb.toString();
        if(str.length() > 2)
            str = str.substring(0,str.length() - 2);
        return str += "]";
    }
}
