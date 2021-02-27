package cn.tedu.sortscore;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class SortScoreMapper extends Mapper<LongWritable, Text,Score, NullWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] arr = value.toString().split("\t");
        Score s = new Score();
        s.setName(arr[0]);
        s.setScore(Integer.parseInt(arr[1]));
        context.write(s,NullWritable.get());
    }
}
