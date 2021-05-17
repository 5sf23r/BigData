package cn.tedu.multipleinputs;

import cn.tedu.authinput.AuthInputFormat;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class ScoreDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        job.setJarByClass(ScoreDriver.class);
        job.setReducerClass(ScoreReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        // 多源输入
        MultipleInputs.addInputPath(job, new Path("hdfs://hadoop01:9000/txt/score.txt"),
                TextInputFormat.class, ScoreMapper1.class);
        MultipleInputs.addInputPath(job, new Path("hdfs://hadoop01:9000/txt/score3.txt"),
                AuthInputFormat.class, ScoreMapper2.class);

        FileOutputFormat.setOutputPath(job,
                new Path("hdfs://hadoop01:9000/result/multipleinputs"));
        job.waitForCompletion(true);
    }
}
