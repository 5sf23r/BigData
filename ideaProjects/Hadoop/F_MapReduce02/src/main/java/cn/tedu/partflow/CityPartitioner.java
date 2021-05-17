package cn.tedu.partflow;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

// 按照城市对数据进行分类 - 不同的城市发往不同的分区
public class CityPartitioner extends Partitioner<Text, Flow> {
    @Override
    public int getPartition(Text text, Flow flow, int numPartitions) {
        // 获取城市
        String city = flow.getCity();
        // 分区是有编号的，编号是从0开始‘
        // 所以就需要将城市和编号进行对应
        if (city.equals("bj"))
            return 0;
        else if (city.equals("sh"))
            return 1;
        else
            return 2;
    }
}
