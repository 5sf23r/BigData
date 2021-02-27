package cn.tedu.partscore;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class Score implements Writable {
    private int month;
    private String name = "";
    private int score;

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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(month);
        dataOutput.writeUTF(name);
        dataOutput.writeInt(score);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.month = dataInput.readInt();
        this.name = dataInput.readUTF();
        this.score = dataInput.readInt();
    }
}
