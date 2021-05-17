package cn.tedu.partflow;

import cn.tedu.invert.InvertDriver;
import cn.tedu.invert.InvertMapper;
import cn.tedu.invert.InvertReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class PartFlowDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        job.setJarByClass(PartFlowDriver.class);
        job.setMapperClass(PartFlowMapper.class);
        job.setReducerClass(PartFlowReducer.class);

        // 指定分区类
        job.setPartitionerClass(CityPartitioner.class);
        // 每一个分区对应一个ReduceTask
        // 现在设置了3个分区，那么就需要设置3个ReduceTask
        job.setNumReduceTasks(3);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Flow.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        FileInputFormat.addInputPath(job,
                new Path("hdfs://hadoop01:9000/txt/flow.txt"));
        FileOutputFormat.setOutputPath(job,
                new Path("hdfs://hadoop01:9000/result/partflow"));

        job.waitForCompletion(true);
    }
}
