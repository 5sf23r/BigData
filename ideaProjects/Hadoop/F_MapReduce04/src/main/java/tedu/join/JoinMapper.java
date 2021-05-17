package tedu.join;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class JoinMapper extends Mapper<LongWritable, Text, Text, Order> {

    private Map<String, Order> map = new HashMap<>();

    // 需要先处理product.txt文件
    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        // 从缓存中将存储的product.txt地址取出来
        URI file = context.getCacheFiles()[0];
        // 连接HDFS
        FileSystem fs = FileSystem.get(file, context.getConfiguration());
        // 打开文件，获取到一个输出流
        InputStream in = fs.open(new Path(file.toString()));
        // 获取的是字节流，但是数据却是一行一条数据，如果直接使用字节流读取，还需要自己判断什么时候读完一行
        // 所以考虑将字节流包装成一个字符流，并且希望能够进行按行读取
        // BufferedReader->String LineReader->Text
        // 当前场景中，需要将数据读取出来之后还得进行处理
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        // 读取数据
        String line;
        while ((line = reader.readLine()) != null) {
            // 1 chuizi 3999
            String[] arr = line.split(" ");
            Order o = new Order();
            o.setProId(arr[0]);
            o.setName(arr[1]);
            o.setPrice(Double.parseDouble(arr[2]));
            map.put(o.getProId(), o);
        }
        // 关流
        reader.close();
    }

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 1003 20170710 2 40
        String[] arr = value.toString().split(" ");
        Order o = new Order();
        o.setOrderId(arr[0]);
        o.setDate(arr[1]);
        o.setProId(arr[2]);
        o.setNum(Integer.parseInt(arr[3]));
        o.setName(map.get(o.getProId()).getName());
        o.setPrice(map.get(o.getProId()).getPrice());

        context.write(new Text(o.getName()), o);
    }
}
