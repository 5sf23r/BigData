package cn.commandoptionesc.thread;

//生产消费模型
//生产者 消费者 商品
public class WaitNotifyAllDemo {
    public static void main(String[] args) {
        Product p = new Product();
        new Thread((new Producer2(p))).start();
        new Thread((new Producer2(p))).start();
        new Thread((new Producer2(p))).start();
        new Thread((new Consumer2(p))).start();
        new Thread((new Consumer2(p))).start();
        new Thread((new Consumer2(p))).start();
    }
}

//商品
class Product2{
    private int count;
    //标记位
    //规定：true就让生产者生产，如果为false让消费者消费
    boolean flag = true;

    public int getCount(){
        return count;
    }
    public void setCount(int count){
        this.count = count;
    }
}

//生产者
class Producer2 implements Runnable{

    private Product p;
    public Producer2(Product p){
        this.p = p;
    }

    @Override
    public void run() {
        while(true){
            synchronized (p){
                try {
                    //生产者生产了一次，如果再次抢到执行权不能执行，而是需要放开执行权等待
                    if(p.flag == false)
                        p.wait();
                    //模拟生产的商品数量
                    //表示每一次商品的数量都不相等
                    int count = (int) (Math.random() * 1000);
                    p.setCount(count);
                    System.out.println("生产者生产了：" + count);
                    p.flag = false;
                    p.notify();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
//消费者
class Consumer2 implements Runnable{
    private Product p;
    public Consumer2(Product p){
        this.p = p;
    }

    @Override
    public void run() {
        while(true){
            synchronized (p){
                try{
                    //消费者消费完成之后，需要让生产者生产
                    if(p.flag == true)
                        p.wait();
                    System.out.println("消费者消费了：" + p.getCount());
                    p.setCount(0);
                    //唤醒在等待的线程
                    p.flag = true;
                    p.notify();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}