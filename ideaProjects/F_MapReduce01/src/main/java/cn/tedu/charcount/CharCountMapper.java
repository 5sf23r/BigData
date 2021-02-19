package cn.tedu.charcount;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

// MapReduce中要求被传输的数据必须能够被序列化
// KEYIN    输入的键的类型，在默认情况下，表示的是读取的这一行的字节偏移量
//          - LongWriteable是MapReduce
// VALUEIN  输入的值的类型，在默认情况下，表示的就是读取的这一行数据
//          - Text是MapReduce针对String类型提供的序列化形式
// KEYOUT   输出的键的类型，当前案例是计算每一个字符出现的次数，所以输出的键应该是字符
// VALUEOUT 输出的值的类型，当前案例是计算每一个字符出现的次数，所以输出的值应该是次数
public class CharCountMapper extends Mapper<LongWritable, Text,Text,LongWritable> {
    // MapTask的处理逻辑是放在map方法中
    // 每读取一行，调用一次一次map方法
    // key：字节偏移量
    // value：读取的这一行数据
    // context：环境参数，作用之一是将数据从Map写到Reduce
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // value表示的是一行数据
        // 可以先统计这一行中每一个字符出现的次数
        // 将这一行中的每一个字符拆分出来
        // hello -> [h,e,l,l,o]
        char[] cs = value.toString().toCharArray();
        // h:1 e:1 l:2 o:1
        // h:1 e:1 l:1 l:1 o:1
        for(char c : cs){
            context.write(new Text(c + ""),new LongWritable(1));
        }
    }
}
