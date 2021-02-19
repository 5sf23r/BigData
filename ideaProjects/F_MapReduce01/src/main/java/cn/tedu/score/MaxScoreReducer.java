package cn.tedu.score;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class MaxScoreReducer extends Reducer<Text, IntWritable,Text,IntWritable> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        IntWritable max = new IntWritable(0);
        // 在MapReduce为了节省内存空间，采取了地址复用机制
        // 在遍历迭代器的时候，迭代对象只创建一次
        // key:Bob
        // values:312 684 340 548
        // IntWriteable val = new IntWritable();
        // val.set(312);
        // val.get() > max.get() -> 312 > 0 -> true
        // max = val; - val和max都是对象，所以赋值给的是地址 -> max和val的地址就一样了
        // val.set(684); - val和max的地址一样，那就意味着max中的值也变成了684
        // val.get() > max.get() -> 684 > 684 -> false
        // val.set(340); - max的值也跟着变成了340
        // 这么遍历下去，max的最终结果应该遍历的最后一个值
        for (IntWritable val : values) {
            if(val.get() > max.get()){
                max.set(val.get());
            }
        }
        context.write(key,max);
    }
}
