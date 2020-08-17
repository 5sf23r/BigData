package cn.commandoptionesc;

public class DaemonDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Monster(),"A");
        Thread t2 = new Thread(new Monster(),"B");
        Thread t3 = new Thread(new Monster(),"C");
        Thread t4 = new Thread(new Monster(),"D");

        //设置守护线程
        t1.setDaemon(true);
        t2.setDaemon(true);
        t3.setDaemon(true);
        t4.setDaemon(true);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        for(int i = 10; i > 0;i--){
            System.out.println("Boss掉了一滴血，剩余" + i);
            Thread.sleep(500);
        }
    }
}

class Monster implements Runnable{
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for(int i = 1000;i > 0;i--){
            System.out.println(name + "掉了一地血，剩余" + i);
            try{
                Thread.sleep(50);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
