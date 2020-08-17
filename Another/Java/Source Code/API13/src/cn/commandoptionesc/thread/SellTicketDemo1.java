package cn.commandoptionesc.thread;

//总票数为100，四个人共卖100张票
public class SellTicketDemo1 {
    public static void main(String[] args) {

        Ticket t = new Ticket();
        t.setCount(100);
        new Thread(new Seller(t),"A").start();
        new Thread(new Seller(t),"B").start();
        new Thread(new Seller(t),"C").start();
        new Thread(new Seller(t),"D").start();
    }
}

class Seller implements Runnable{

    private Ticket t;
    public Seller(Ticket t) {
        this.t = t;
    }

    @Override
    public  void run(){
        while(true){
            //synchronized(t) {
            synchronized(Seller.class) {
                if (t.getCount() <= 0)
                    break;
                try {
                    //参数表示沉睡时间，单位是毫秒
                    //sleep不影响执行结果，只是将执行时间拉长
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //卖了一张票
                t.setCount(t.getCount() - 1);
                //获取线程名字
                String name = Thread.currentThread().getName();
                System.out.println(name + "卖出了一张票，剩余" + t.getCount());
            }
        }
    }
}

class Ticket{

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}