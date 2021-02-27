package cn.tedu.join;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class Order implements Writable {
    // 商品订单编号
    private String orderId = "";
    // 商品产生的日期
    private String date = "";
    // 卖出商品的ID
    private String proId = "";
    // 卖出的数量
    private int num;
    // 商品名称
    private String name = "";
    // 商品价格
    private double price;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeUTF(orderId);
        out.writeUTF(date);
        out.writeUTF(proId);
        out.writeInt(num);
        out.writeUTF(name);
        out.writeDouble(price);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        this.orderId = in.readUTF();
        this.date = in.readUTF();
        this.proId = in.readUTF();
        this.num = in.readInt();
        this.name = in.readUTF();
        this.price = in.readDouble();
    }
}
