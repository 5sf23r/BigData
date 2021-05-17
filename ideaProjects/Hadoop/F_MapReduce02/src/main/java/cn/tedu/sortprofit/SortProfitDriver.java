package cn.tedu.sortprofit;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class SortProfitDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        job.setJarByClass(SortProfitDriver.class);
        job.setMapperClass(SortProfitMapper.class);
        job.setReducerClass(SortProfitReducer.class);

        job.setOutputKeyClass(Profit.class);
        job.setOutputValueClass(NullWritable.class);

        // 指定合并类
        // job.setCombinerClass(SortProfitReducer.class);

        // minSize
        // FileInputFormat.setMinInputSplitSize();
        // maxSize
        // FileInputFormat.setMaxInputSplitSize();

        FileInputFormat.addInputPath(job,
                new Path("hdfs://hadoop01:9000/txt/profit3.txt"));
        FileOutputFormat.setOutputPath(job,
                new Path("hdfs://hadoop01:9000/result/sortprofit3"));

        job.waitForCompletion(true);
    }
}