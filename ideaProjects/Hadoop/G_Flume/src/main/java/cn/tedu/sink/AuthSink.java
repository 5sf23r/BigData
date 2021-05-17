package cn.tedu.sink;

import org.apache.flume.*;
import org.apache.flume.conf.Configurable;
import org.apache.flume.sink.AbstractSink;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Map;

// 模拟File_roll Sink
public class AuthSink extends AbstractSink implements Sink, Configurable {

    private File file;
    // 往文件中写的流
    private PrintStream ps;

    @Override
    public void configure(Context context) {
        // 获取属性值
        String dir = context.getString("dir");
        // 判断是否指定了输出的目录
        if (dir == null) {
            throw new NullPointerException("存储的目录路径不能为空！！！");
        }
        file = new File(dir);
    }

    @Override
    public synchronized void start() {
        System.out.println("Sink已经启动~~~");
        // 判断路径是否存在
        if (!file.exists())
            // 如果路径不存在，试着创建这个路径
            file.mkdirs();
        // 初始化流对象
        try {
            ps = new PrintStream(file.getPath() + "/" + System.currentTimeMillis());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        super.start();
    }

    @Override
    public Status process() {

        // 获取Channel
        Channel c = super.getChannel();
        // 获取Transaction
        Transaction t = c.getTransaction();
        // 开启事务
        t.begin();
        // 创建Event
        Event e;
        try {
            while ((e = c.take()) != null) {
                Map<String, String> headers = e.getHeaders();
                byte[] body = e.getBody();
                ps.println("headers:");
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    ps.println("\t" + entry.getKey() + ":" + entry.getValue());
                }
                ps.println("body:");
                ps.println("\t" + new String(body));
            }
            t.commit();
        } catch (Exception ex) {
            // 如果写失败了，回滚
            t.rollback();
            ex.printStackTrace();
            return Status.BACKOFF;
        } finally {
            t.close();
        }
        return Status.READY;
    }

    @Override
    public synchronized void stop() {
        ps.close();
        System.out.println("Sink已经执行完了");
        super.stop();
    }
}
