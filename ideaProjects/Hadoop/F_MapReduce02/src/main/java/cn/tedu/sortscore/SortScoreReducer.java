package cn.tedu.sortscore;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class SortScoreReducer extends Reducer<Score, NullWritable, Text, IntWritable> {
    @Override
    protected void reduce(Score key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
        context.write(new Text(key.getName()), new IntWritable(key.getScore()));
    }
}
