package cn.commandoptionesc.collection;

public class LinkedListDemo2 {
    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.add("a");
        //list.add("a");
        //list.add("b");
        //list.add("c");
        //list.add("d");
        //list.add("e");
        //list.add("f");

        //list.remove(0);
        //list.remove(5);
        list.remove(2);

        //System.out.println(list.indexOf("c"));

        //list.add(0,g);
        //list.add(6,"g");
        //list.add(2,"g");

        //list.clear();
        System.out.println(list);
    }
}

//模拟一个LinkedList
class LinkList {

    private Node first;//头节点
    private Node last;//尾节点
    private int size = 0;//记录元素个数

    //添加元素
    public void add(String str){

        //创建一个节点存储这个元素
        Node n = new Node(null,str,null);
        //判断这是不是添加的第一个元素
        if(size == 0){
            //如果是一个元素，头节点和尾节点就是同一个节点
            first = last = n;
        }else{
            //尾节点的下一位是新节点
            this.last.next = n;
            //新节点的上一位是尾节点
            n.prev = this.last;
            this.last = n;
        }
        size++;
    }

    //插入元素
    public void add(int index,String str){

        //判断下标是否越界
        if(index < 0 || index > size)
            throw new IllegalArgumentException();

        //创建一个Node对象来存储元素
        Node n = new Node(null,str,null);
        if(index == size){
            //尾部追加
            this.add(str);
            return ;
        }else if(index == 0){
            //头部插入
            //新节点的下一位是原来的头节点
            n.next = first;
            //原来的头节点的上一位是新节点
            first.prev = n;
            //新节点成为头结点
            first = n;
        }else {
            //中间插入
            //先找到要插入的下标位置对应的节点
            Node node = this.getNode(index);

            //原来的上一位的下一个节点成为新节点
            node.prev.next = n;
            //新节点的上一位是原来节点的上一位
            n.prev = node.prev;
            //新节点的下一位是原来的节点
            n.next = node;
            //原来节点的上一位是新节点
            node.prev = n;


        }
        size ++;
    }

    //获取指定下标位置上的节点
    private Node getNode(int index){

        if(index <= size/2){
            //下标在前半段
            int i = 0;
            Node n = this.first;

            while (i < index){
                n = n.next;
                i++;
            }
            return n;
        }else{
            //下标在后半段
            int i = size - 1;
            Node n = this.last;
            while(i > index){
                n = n.next;
                i--;
            }
            return n;
        }
    }

    //清空集合
    public void clear(){

        size = 0;
        this.first = this.last = null;
    }

    //获取指定元素出现的节点
    public int indexOf(String str){

        Node n = this.first;
        for(int i = 0;i < size;i++){
            String s = n.str;
            if(str == s || s !=null && s.equals(str))
                return i;

            n = n.next;
        }
        return -1;
    }

    //判断是否有指定元素
    public boolean contains(String str){
        int index = indexOf(str);
        return index != -1;
    }

    private void outOfIndex(int index){
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Size:" + size + ",Index" + index);
    }


    //获取指定下标上的元素
    public String get(int index){
        //先判断下标是否越界
        outOfIndex(index);
        //获取指定小标上的元素
        Node n = this.getNode(index);
        return n.str;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //获取指定元素最后一次出现的下标
    public int lastIndexOf(String str){

        Node n = this.last;
        for(int i = size - 1;i >= 0;i--){
            String s = n.str;
            if(s == str || s !=null && s.equals(str))
                return i;
            n = n.prev;
        }
        return -1;
    }

    //移除指定下标上的元素
    public void remove(int index){

        //判断下标是否越界
        this.outOfIndex(index);

        //判断是否只有1个元素
        if(size == 1){
            first = last = null;
        }else if(index == 0){
            //头部移除
            //头节点的下一个就变成了新的头节点
            first = first.next;
            //原来的头节点的指向清空
            first.prev.next = null;
            //新的头节点的上一位也要清空
            first.prev = null;
        }else if(index == size -1){
            //尾部移除
            //尾节点的上一位就变成了新的尾节点
            last = last.prev;
            //原来的尾节点的指定要清空
            last.next.prev = null;
            //新的尾节点的下一位也要清空
            last.next = null;
        }else{
            //中间移除
            //先找到要移除的位置的元素
            Node n = this.getNode(index);
            //原来节点的上一位的下一个节点要指向原来的下一位
            n.prev.next = n.next;
            //原来节点的下一位的上一位节点要指向原来的上一位
            n.next.prev = n.prev;
            //这个节点的指向要清空
            n.prev = null;
            n.next = null;
            n = null;
        }
        size --;
    }

    //移除指定的元素，只移动第一次
    public void remove(String str){
        int index = this.indexOf(str);
        if(index != -1)
            remove(index);
    }

    //替换指定位置上的元素
    public void set(int index,String str){
        //下标越界
        outOfIndex(index);
        //获取指定下标上的节点
        Node n = this.getNode(index);
        n.str = str;
    }

    //获取元素个数
    public int size(){
        return size;
    }

    //截取子字符串
    public LinkList subList(int fromIndex,int toIndex){
        if(fromIndex > toIndex || fromIndex < 0 || toIndex < 0 || fromIndex > size || toIndex > size)
            throw new IllegalArgumentException();

        LinkList list = new LinkList();
        //获取到指定下标位置上的节点
        Node n = this.getNode(fromIndex);
        for(int i = fromIndex; i < toIndex;i++){
            list.add(n.str);
            n = n.next;
        }
        return list;
    }

    //添加方法
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node n = this.first;
        for(int i = 0;i < size;i++){
            sb.append(n.str).append(",");
            //向后推后一位
            n = n.next;
        }

        String str = sb.toString();
        if(str.length() > 2)
            str = str.substring(0,str.length() - 2);

        return str += "]";
    }

    //提供一个内部类类存储节点信息
    private class Node {

        Node prev;//上一个节点
        String str;//数据
        Node next;//下一个节点

        public Node(Node prev, String str, Node next) {
            this.prev = prev;
            this.str = str;
            this.next = next;
        }
    }
}
