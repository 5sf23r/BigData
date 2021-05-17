package cn.tedu.multipleinputs;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

// 处理score3.txt
public class ScoreMapper2 extends Mapper<Text, Text, Text, IntWritable> {
    @Override
    protected void map(Text key, Text value, Context context) throws IOException, InterruptedException {
        // key = tom
        // value = math 90 english 98
        String[] arr = value.toString().split(" ");
        context.write(key, new IntWritable(Integer.parseInt(arr[1])));
        context.write(key, new IntWritable(Integer.parseInt(arr[3])));
    }
}
