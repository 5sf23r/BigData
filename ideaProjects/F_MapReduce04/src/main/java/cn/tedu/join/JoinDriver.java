package cn.tedu.join;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.net.URI;

public class JoinDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        job.setJarByClass(JoinDriver.class);
        job.setMapperClass(JoinMapper.class);
        job.setReducerClass(JoinReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Order.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(DoubleWritable.class);

        // 当需要同时处理多个文件的时候，可以将其中比较小的文件放入缓存中，设置一个缓存存根
        URI[] files = {URI.create("hdfs://hadoop01:9000/txt/union/product.txt")};
        job.setCacheFiles(files);
        // 处理大文件
        FileInputFormat.addInputPath(job,new Path("hdfs://hadoop01:9000/txt/union/order.txt"));
        FileOutputFormat.setOutputPath(job,new Path("hdfs://hadoop01:9000/result/join"));
        job.waitForCompletion(true);


    }
}
