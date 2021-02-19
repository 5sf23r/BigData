package cn.tedu.ip;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class IPDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        job.setJarByClass(IPDriver.class);
        job.setMapperClass(IPMapper.class);
        job.setReducerClass(IPReducer.class);

        // 如果Mapper和Reducer输出类型一致，那么可以只写一个
        job.setOutputKeyClass(Text.class);
        job.setMapOutputValueClass(NullWritable.class);

        FileInputFormat.addInputPath(job,new Path("hdfs://hadoop01:9000/txt/ip.txt"));
        FileOutputFormat.setOutputPath(job,new Path("hdfs://hadoop01:9000/result/ip"));
        job.waitForCompletion(true);

    }
}
