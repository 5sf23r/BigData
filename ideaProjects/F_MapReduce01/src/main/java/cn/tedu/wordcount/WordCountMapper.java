package cn.tedu.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

// 单词统计 -> 单词：次数
public class WordCountMapper extends Mapper<LongWritable, Text,Text, IntWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 将但此举进行拆分
        String[] arr = value.toString().split(" ");
        for (String s : arr) {
            context.write(new Text(s),new IntWritable(1));
        }
    }
}
