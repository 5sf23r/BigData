package cn.tedu.authinput;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class Score implements Writable {
    private int math;
    private int english;

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(math);
        dataOutput.writeInt(english);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.math = dataInput.readInt();
        this.english = dataInput.readInt();
    }
}
