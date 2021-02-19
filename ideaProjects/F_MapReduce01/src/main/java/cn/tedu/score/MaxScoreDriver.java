package cn.tedu.score;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class MaxScoreDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        job.setJarByClass(MaxScoreDriver.class);
        job.setMapperClass(MaxScoreMapper.class);
        job.setReducerClass(MaxScoreReducer.class);

        // 如果Mapper和Reducer输出类型一致，那么可以只写一个
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        FileInputFormat.addInputPath(job,new Path("hdfs://hadoop01:9000/txt/score2.txt"));
        FileOutputFormat.setOutputPath(job,new Path("hdfs://hadoop01:9000/result/maxscore2"));
        job.waitForCompletion(true);
    }
}
