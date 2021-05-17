package cn.tedu.sortscore;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class SortScoreDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        job.setJarByClass(SortScoreDriver.class);
        job.setMapperClass(SortScoreMapper.class);
        job.setReducerClass(SortScoreReducer.class);

        job.setMapOutputKeyClass(Score.class);
        job.setMapOutputValueClass(NullWritable.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        // 在MapReduce中，如果一个文件以_开头，MapReduce默认不处理这个文件
        FileInputFormat.addInputPath(job,
                new Path("hdfs://hadoop01:9000/result/totalscore"));
        FileOutputFormat.setOutputPath(job,
                new Path("hdfs://hadoop01:9000/result/sortscore"));

        job.waitForCompletion(true);
    }
}
