package cn.tedu.maxscore;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MaxScoreMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // Adair 345
        String[] arr = value.toString().split(" ");
        context.write(new Text(arr[0]), new IntWritable(Integer.parseInt(arr[1])));
    }
}
