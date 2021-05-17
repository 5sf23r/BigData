package cn.tedu.serialscore;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class SerialScoreMapper extends Mapper<LongWritable, Text, Text, Score> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // Bob 90 64 92
        String[] arr = value.toString().split(" ");
        Score s = new Score();
        s.setName(arr[0]);
        int[] scores = new int[arr.length - 1];
        for (int i = 0; i < scores.length; i++) {
            scores[i] = Integer.parseInt(arr[i + 1]);
        }
        s.setScores(scores);
        context.write(new Text(s.getName()), s);
    }
}
