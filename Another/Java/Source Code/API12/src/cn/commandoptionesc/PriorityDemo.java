package cn.commandoptionesc;

public class PriorityDemo {
    public static void main(String[] args) {

        Thread t1 = new Thread(new PDemo(),"A");
        Thread t2 = new Thread(new PDemo(),"B");

        t1.setPriority(4);
        t2.setPriority(5);

        t1.start();
        t2.start();
    }
}

class PDemo implements Runnable{
    @Override
    public void run() {

        //获取线程的名字
        String name = Thread.currentThread().getName();
        for(int i = 0;i < 9;i++){
            System.out.println(name + ":" + i);
        }
    }
}
