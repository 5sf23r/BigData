package cn.tedu.serialscore;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.text.DecimalFormat;

public class SerialScoreReducer extends Reducer<Text, Score, Text, Text> {
    @Override
    protected void reduce(Text key, Iterable<Score> values, Context context) throws IOException, InterruptedException {
        double sum = 0;
        // 因为人名是唯一的，所以迭代器中实际上只包含一个对象
        Score score = values.iterator().next();
        int[] scores = score.getScores();
        for (int s : scores) {
            sum += s;
        }
        double average = sum / scores.length;
        DecimalFormat df = new DecimalFormat("0.00");
        String str = df.format(average);
        context.write(key, new Text(str));
    }
}
