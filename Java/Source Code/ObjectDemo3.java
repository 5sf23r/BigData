package cn.commandoptionesc.object;
public class ObjectDemo3{
    //属性
    int j=10;
    public static void main(String[] args){
        int j=7;
        //局部（方法）代码块
        //控制变量的生命周期
        {
            int i=10;
            System.out.println(i+j);
        }

        //1000行
    }
}
