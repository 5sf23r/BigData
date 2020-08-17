package cn.commandoptionesc.thread;

public class ThreadDemo {
    public static void main(String[] args) {

        //创建线程对象
        TDemo t = new TDemo();
        //启动线程，启动之后自动调用run方法来执行逻辑
        t.start();

        for(int i = 0;i < 5;i++){
            System.out.println("main");
        }
    }
}

//继承Thread
class TDemo extends Thread{

    //线程的执行逻辑卸载这个方法中
    @Override
    public void run() {
        for(int i = 0;i < 10;i++){
            System.out.println("TDemo");
        }
    }
}