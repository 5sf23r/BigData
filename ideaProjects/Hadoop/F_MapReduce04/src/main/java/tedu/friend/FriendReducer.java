package tedu.friend;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class FriendReducer extends Reducer<Text, IntWritable, Text, NullWritable> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        // values中放到的好友关系
        for (IntWritable val : values) {
            // 找的是隐藏好友
            // 真实好友关系用的1表示，推测的好友关系用0表示
            // 如果出现了1，那么说明他俩不是隐藏好友
            // 如果全部都是0，那么说明隐藏好友
            if (val.get() == 1)
                return;
        }
        context.write(key, NullWritable.get());
    }
}
