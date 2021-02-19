package cn.tedu.totalscore;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class TotalScoreDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        job.setJarByClass(TotalScoreDriver.class);
        job.setMapperClass(TotalScoreMapper.class);
        job.setReducerClass(TotalScoreReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        FileInputFormat.addInputPath(job,new Path("hdfs://hadoop01/txt/score2"));
        FileOutputFormat.setOutputPath(job,new Path("hdfs://hadoop01/result/maxscore2"));
        job.waitForCompletion(true);
    }
}
