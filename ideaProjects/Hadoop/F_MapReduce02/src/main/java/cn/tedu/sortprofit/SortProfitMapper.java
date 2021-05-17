package cn.tedu.sortprofit;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class SortProfitMapper extends Mapper<LongWritable, Text, Profit, NullWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] arr = value.toString().split(" ");
        Profit p = new Profit();
        p.setMonth(Integer.parseInt(arr[0]));
        p.setName(arr[1]);
        p.setProfit(Integer.parseInt(arr[2]));
        context.write(p, NullWritable.get());
    }
}
