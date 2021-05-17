package tedu.friend;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RelationReducer extends Reducer<Text, Text, Text, IntWritable> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        // key = tom
        // values = rose jim smith lucy
        String name = key.toString();
        List<String> list = new ArrayList<>();
        // 用1标记的是真实好友关系
        // 迭代器只能迭代一次
        for (Text val : values) {
            String f = val.toString();
            list.add(f);
            if (name.compareTo(f) < 0)
                context.write(new Text(name + "-" + f), new IntWritable(1));
            else
                context.write(new Text(f + "-" + name), new IntWritable(1));
        }
        // 推测好友关系 - 根据好友列表，推测两两是否认识，把这种推测的关系用0表示
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                String f1 = list.get(i);
                String f2 = list.get(j);
                if (f1.compareTo(f2) < 0)
                    context.write(new Text(f1 + "-" + f2), new IntWritable(0));
                else
                    context.write(new Text(f2 + "-" + f1), new IntWritable(0));
            }
        }
    }
}
