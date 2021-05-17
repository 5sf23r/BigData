package cn.tedu.serialscore;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class Score implements Writable {

    private String name = "";
    private int[] scores = new int[0];

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getScores() {
        return scores;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeUTF(name);
        out.writeInt(scores.length);
        for (int score : scores) {
            out.writeInt(score);
        }
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        this.name = in.readUTF();
        this.scores = new int[in.readInt()];
        for (int i = 0; i < scores.length; i++) {
            scores[i] = in.readInt();
        }
    }
}
