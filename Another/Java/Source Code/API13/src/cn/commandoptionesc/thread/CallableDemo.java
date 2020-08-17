package cn.commandoptionesc.thread;

import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException,InterruptedException {

        ExecutorService es = Executors.newCachedThreadPool();
        Future<String> f = es.submit(new CDemo());
        System.out.println(f.get());
        es.shutdown();
    }
}

class CDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "Success";
    }
}
