package cn.commandoptionesc.io.file;

        import java.io.FileReader;
        import java.io.IOException;

public class FileReaderDemo2 {
    public static void main(String[] args) throws IOException {

        //创建一个输入流指向要读取的文件
        FileReader reader = new FileReader("../Other/io/ex.txt");
        //准备缓冲区 - 输入流的缓冲区需要自己来定义
        //准备了一个字符数组作为缓冲区来使用
        char[] cs = new char[5];
        //将数据线写到cs数组中，等数组写满了，再一次行的向外打印
        //返回值表示的这次读取到的字符个数
        //定义一个变量来记录每次读取到的字符个数
        int len;
        //第一次读取，读取了hello这5个字符，将5赋值给len
        //第二次读取，读取了f这1个字符，将1赋值给len
        //第三次读取，没有读取到数据，那么说明读到了末尾，那么僵-1赋值给len
        while((len = reader.read(cs)) !=-1){
            System.out.println(new String(cs,0,len));
        }
        //关流
        reader.close();
    }
}
