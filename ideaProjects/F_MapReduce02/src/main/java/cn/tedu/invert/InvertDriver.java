package cn.tedu.invert;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class InvertDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        job.setJarByClass(InvertDriver.class);
        job.setMapperClass(InvertMapper.class);
        job.setReducerClass(InvertReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        FileInputFormat.addInputPath(job,new Path("hdfs://hadoop01:9000/txt/invert/"));
        FileOutputFormat.setOutputPath(job,new Path("hdfs://hadoop01:9000/result/invert"));

        job.waitForCompletion(true);
    }
}
