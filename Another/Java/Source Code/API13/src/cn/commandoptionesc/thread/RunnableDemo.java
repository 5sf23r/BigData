package cn.commandoptionesc.thread;

public class RunnableDemo {
    public static void main(String[] args) {

        RDemo r = new RDemo();
        //将Runnable对象构建成Thread对象启动
        Thread t = new Thread(r);
        t.start();
    }
}

//实现Runnable
class RDemo implements Runnable{
    @Override
    public void run() {
        for(int i = 0;i < 5;i++){
            System.out.println("RDemo");
        }
    }
}
