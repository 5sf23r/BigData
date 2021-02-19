package cn.tedu;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class InvertReducer extends Reducer<Text, Text,Text,Text> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        // 现在文件名是放在values中，获取出文件名
        // 对文件名进行去重
        Set<String> set = new HashSet<>();
        for (Text val : values) {
            set.add(val.toString());
        }
        StringBuffer sb = new StringBuffer();
        for (String s : set) {
            sb.append(s).append("\t");
        }
    }
}
