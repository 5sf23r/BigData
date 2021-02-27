package cn.tedu.authinput;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class AuthDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        job.setJarByClass(AuthDriver.class);
        job.setMapperClass(AuthMapper.class);
        job.setReducerClass(AuthReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Score.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        // 指定输入格式类
        job.setInputFormatClass(AuthInputFormat.class);

        FileInputFormat.addInputPath(job,new Path("hdfs://hadoop01:9000/txt/score3.txt"));
        FileOutputFormat.setOutputPath(job,new Path("hdfs://hadoop01:9000/result/authinput"));

        job.waitForCompletion(true);
    }
}
