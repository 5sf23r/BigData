package cn.tedu.charcount;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

// KEYIN, VALUEIN   输入的键值的类型 - Reduce的数据从Map来的
// KEYOUT, VALUEOUT 输出的键值的类型 - 计算每一个字符出现的次数，所以输出的是字符：次数
public class CharCountReducer extends Reducer<Text, LongWritable,Text,LongWritable> {
    // key      输入的键 -当前案例中表示的是字符，每一个键调用一次reduce方法
    // values   这个键所对应的所有的值
    // context  环境参数，此处的作用是将结果最终写回到HDFS上
    @Override
    protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
        // 记录总次数
        long sum = 0;
        // key:h
        // values:1,1,1,1,....
        // 迭代遍历这个values
        for(LongWritable val : values){
            sum += val.get();
        }
        context.write(key, new LongWritable(sum));
    }
}
