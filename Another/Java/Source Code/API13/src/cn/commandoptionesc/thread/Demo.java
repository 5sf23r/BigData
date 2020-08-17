package cn.commandoptionesc.thread;

public class Demo {
    private static Printer p = new Printer();
    private static Scanner s = new Scanner();

    public static void main(String[] args) {
        //第一个员工
        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    synchronized (p) {
                        p.print();
                        Thread.sleep(100);
                        synchronized (s){
                            s.scan();
                        }
                    }
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();
        //第二个员工
        new Thread(new Runnable(){
            @Override
            public void run() {
                try{
                    synchronized (s){
                        s.scan();
                        Thread.sleep(100);
                        synchronized (p){
                            p.print();
                        }
                    }

                }catch(Exception e){
                    e.printStackTrace();
                }

            }
        }).start();

    }
}

//打印机
class Printer{
    public void print(){
        System.out.println("这台打印机在哼哧哼哧的打印~~~");
    }
}

class Scanner{
    public void scan(){
        System.out.println("这部扫描仪在吱呦吱呦的扫描~~~");
    }
}
