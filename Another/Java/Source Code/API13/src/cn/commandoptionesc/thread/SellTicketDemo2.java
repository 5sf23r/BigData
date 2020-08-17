package cn.commandoptionesc.thread;

public class SellTicketDemo2 {
    public static void main(String[] args) {
        Ticket t = new Ticket();
        t.setCount(100);
        SellSystem ss = new SellSystem(t);
        //用四个线程表示售票员
        //这4个售票员应该使用的是同一个售票系统
        new Thread(ss,"A").start();
        new Thread(ss,"B").start();
        new Thread(ss,"C").start();
        new Thread(ss,"D").start();
    }
}

//售票系统
class SellSystem implements Runnable{

    private Ticket t;
    public SellSystem(Ticket t){
        this.t = t;
    }

    @Override
    public void run() {
        while(true){
            synchronized (this){
                if(t.getCount() <= 0) {
                    break;
                }
                t.setCount(t.getCount() - 1);
                System.out.println(Thread.currentThread().getName() + "卖了一张票，剩余" + t.getCount());
            }
        }
    }
}
