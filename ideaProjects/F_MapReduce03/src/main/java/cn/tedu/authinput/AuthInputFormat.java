package cn.tedu.authinput;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.util.LineReader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

// 泛型表示的输出类型 - 泛型定义的是什么类型，那么Mapper接收的就是什么类型
public class AuthInputFormat extends FileInputFormat<Text,Text> {
    @Override
    public RecordReader<Text, Text> createRecordReader(InputSplit inputSplit, TaskAttemptContext taskAttemptContext) throws IOException, InterruptedException {
        return new AuthReader();
    }
}
class AuthReader extends RecordReader<Text,Text>{
    private LineReader reader;
    private static final byte[] blank = new Text(" ").getBytes();
    private Text key;
    private Text value;
    // 初始化的方法，在这个方法中一般获取一个真正的用于读取数据的流
    @Override
    public void initialize(InputSplit inputSplit, TaskAttemptContext taskAttemptContext) throws IOException, InterruptedException {
        // 获取地址
        FileSplit fsplit = (FileSplit) inputSplit;
        Path path = fsplit.getPath();
        URI uri = URI.create(path.toString());
        // 连接HDFS
        FileSystem fs = FileSystem.get(uri,taskAttemptContext.getConfiguration());
        // 获取输入流用于读取数据
        InputStream in = fs.open(path);
        // 获取的这个输入流是一个字节流
        // 目的是为了读取3行，每3行组成1条数据 - 字节流在读取的时候还得自己判断什么时候才读完3行
        // 考虑将字节流包装成字符流，并且这个字符流最好能够按行读取
        reader = new LineReader(in);
    }

    // 判断是是否有下一个键值对来提供给map方法处理，如果有返回true
    // 可以试图读取数据，如果读取到了数据，那么说明还有数据提供给map处理，返回true
    // 如果没有读取到数据，那么说明所有的数据已经读取完了，那么map方法也没有数据处理，返回false
    @Override
    public boolean nextKeyValue() throws IOException, InterruptedException {
        // 初始化变量
        key = new Text();
        value = new Text();
        Text tmp = new Text();

        // 试图读取
        // 读取第一行
        // 如果没有读取到数据，返回0
        if(reader.readLine(tmp) == 0)
            return false;
        key.set(tmp.toString());
        // 读取第二行
        if(reader.readLine(tmp) == 0)
            return false;
        value.set(tmp.toString());
        // 需要在值之间拼接空格
        value.append(blank,0,blank.length);
        // 读取第三行
        if(reader.readLine(tmp) == 0)
            return false;
        byte[] data = tmp.getBytes();
        value.append(data,0,data.length);
        // 读取完成之后的结构
        // key = tom
        // value = math 90 english 98

        return true;
    }

    // 获取键
    @Override
    public Text getCurrentKey() throws IOException, InterruptedException {
        return key;
    }

    // 获取值
    @Override
    public Text getCurrentValue() throws IOException, InterruptedException {
        return value;
    }

    // 获取当前MapTask的执行进度 - 实际上就是获取数据读取的进度
    // 是否覆盖整个方法对整个结果没有影响
    @Override
    public float getProgress() throws IOException, InterruptedException {
        return 0;
    }

    // 回收
    @Override
    public void close() throws IOException {
        if(reader != null)
            reader.close();
        key = null;
        value = null;
    }
}