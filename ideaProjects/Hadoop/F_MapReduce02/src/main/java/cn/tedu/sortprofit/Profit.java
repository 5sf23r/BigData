package cn.tedu.sortprofit;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class Profit implements WritableComparable<Profit> {

    private int month;
    private String name;
    private int profit;

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "Profit{" +
                "month=" + month +
                ", name='" + name + '\'' +
                ", profit=" + profit +
                '}';
    }

    // 先按照月份排序，如果是同一个月，那么就按照例如降序
    @Override
    public int compareTo(Profit o) {
        int r1 = this.month - o.month;
        if (r1 == 0) {
            // 如果为0，说明是同一个月，同一个月要按照利润降序排序
            int r2 = o.profit - this.profit;
            return r2 == 0 ? 1 : r2;
        }
        return r1;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeInt(month);
        out.writeUTF(name);
        out.writeInt(profit);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        this.month = in.readInt();
        this.name = in.readUTF();
        this.profit = in.readInt();
    }
}
