package cn.tedu.multipleinputs;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

// 处理score.txt
public class ScoreMapper1 extends Mapper<LongWritable, Text, Text, IntWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // Alex 64 63 68
        String[] arr = value.toString().split(" ");
        Text name = new Text(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            context.write(name, new IntWritable(Integer.parseInt(arr[i])));
        }

    }
}
