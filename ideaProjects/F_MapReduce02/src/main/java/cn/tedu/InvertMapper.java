package cn.tedu;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;

public class InvertMapper extends Mapper<LongWritable, Text,Text,Text> {

    private Text name;

    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        // 获取文件名
        FileSplit fs = (FileSplit) context.getInputSplit();
        String name = fs.getPath().getName();
        this.name = new Text(name);
    }

    // 默认情况下，每读取一行调用一次map方法
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 拆分带刺
        String[] arr = value.toString().split(" ");
        for (String s : arr) {
            context.write(new Text(s),name);
        }
    }
}
