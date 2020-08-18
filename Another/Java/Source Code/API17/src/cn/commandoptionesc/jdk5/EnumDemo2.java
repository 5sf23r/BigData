package cn.commandoptionesc.jdk5;

public class EnumDemo2 {
    public static void main(String[] args) {

    }
}
enum Level{

    //public static final Level A = new Level();
    //public static final Level B = new Level(80);

    A,B(80),C,D,E;

    //默认是私有的
    Level(){

    }

    private Level(int score){
        this.score = score;
    }

    private int score;

    public int getScore(){
        return score;
    }

    public void setScore(int score){
        this.score = score;
    }
}
