package cn.commandoptionesc.io.buffer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//统计Java代码的行数
//思路拆分：
// 1. 先遍历，从目录中先找到所有的Java文件 ---
// 2. 读取Java文件然后统计Java代码的行数
public class BufferedReaderDemo2 {

    //记录行数
    private static int count = 0;

    /*
    //记录行数
    private static int lineCount = 0;
    //记录字数
    private static int letterCount = 0;
    */

    public static void main(String[] args) throws IOException {

        //创建File指向要读取的文件
        File file = new File(".");
        countLine(file);
        System.out.println("额外添加，验证是否正确");
        //System.out.println("Java代码总的行数:" + lineCount);
        //System.out.println("字符的个数：" + letterCount);
        System.out.println("Java代码总的行数：" + count);
    }

    private static void countLine(File file) throws IOException {

        //判断这个参数是否为空
        if(file == null)
            throw new NullPointerException("路径不能为空!!!!");

        //判断是否目录还是文件
        if(file.isDirectory()){
            //如果是目录，要获取这个目录下所有的子目录和子文件
            File[] fs = file.listFiles();
            //遍历数组，一次处理每一个子目录或者子文件
            for(File f : fs){
                countLine(f);
            }
        }else if(file.getName().endsWith(".java")){
            //在计算机中，file如果不是目录那么就是文件
            //如果是文件要考虑是Java文件
            //如果是Java文件，那么读取这个Java文件来统计行数
            FileReader fr = new FileReader(file);
            //创建缓冲流对象
            BufferedReader br = new BufferedReader(fr);

            //判断是否读取到了文件的末尾
            /*
            String line;
            while((line = br.readLine()) != null){

                //每读取一行，统计的行数就需要+1
                lineCount++;
                //记录字符个数
                letterCount += line.length();
            }
            */
            while(br.readLine() != null){
                count++;
            }
            //关流
            br.close();
        }
    }
}
