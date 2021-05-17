package cn.tedu.source;

import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.EventDrivenSource;
import org.apache.flume.channel.ChannelProcessor;
import org.apache.flume.conf.Configurable;
import org.apache.flume.event.EventBuilder;
import org.apache.flume.source.AbstractSource;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 模拟Sequence Generator Source
public class AuthSource extends AbstractSource
        implements EventDrivenSource, Configurable {

    private int step = 1;
    private ExecutorService es;

    // 获取格式文件中指定属性的只
    // a1.sources.s1.step = xxx
    @Override
    public void configure(Context context) {
        // 表示用户指定的自增的步长
        String step = context.getString("step");
        // 如果用户指定了步长，就要按照用户的指定的数值来自增
        // 如果用户没有指定步长，那么默认自增一个
        if (step != null)
            this.step = Integer.parseInt(step);
    }

    // 启动Source
    @Override
    public synchronized void start() {
        System.out.println("Source开始启动执行~~~");
        // 创建线程池
        es = Executors.newFixedThreadPool(5);
        // 获取Channel处理器
        ChannelProcessor cp = super.getChannelProcessor();
        // 提交任务，开始执行任务
        es.submit(new Add(step, cp));
    }

    @Override
    public synchronized void stop() {
        es.shutdownNow();
        System.out.println("Source执行结束~~~");
    }
}

class Add implements Runnable {

    private int step;
    private ChannelProcessor cp;

    public Add(int step, ChannelProcessor cp) {
        this.step = step;
        this.cp = cp;
    }

    @Override
    public void run() {

        int i = 0;

        while (true) {

            // Flume会将收集的数据封装成Event
            // 构建一个headers
            Map<String, String> headers = new ConcurrentHashMap<>();
            headers.put("time", System.currentTimeMillis() + "");
            // 第一个参数表示body
            // 第二个参数表示headers
            byte[] body = (i + "").getBytes();
            Event e = EventBuilder.withBody(body, headers);
            // 需要Event传递给Channel
            cp.processEvent(e);

            i += step;
        }

    }
}
