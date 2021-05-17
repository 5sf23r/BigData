package cn.tedu.serialflow;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class Flow implements Writable {

    private String phone = "";
    private String city = "";
    private String name = "";
    private int flow;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFlow() {
        return flow;
    }

    public void setFlow(int flow) {
        this.flow = flow;
    }

    // 序列化
    // 只需要根据业务场景，将有必要的属性写出即可
    @Override
    public void write(DataOutput out) throws IOException {
        out.writeUTF(phone);
        out.writeUTF(city);
        out.writeUTF(name);
        out.writeInt(flow);
    }

    // 反序列化
    @Override
    public void readFields(DataInput in) throws IOException {
        this.phone = in.readUTF();
        this.city = in.readUTF();
        this.name = in.readUTF();
        this.flow = in.readInt();
    }
}
