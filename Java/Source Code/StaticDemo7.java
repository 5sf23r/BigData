package cn.commandoptionesc.staticx;
public class StaticDemo7{
    public static void main(String[] args){
        System.out.println(new SDText().i1);
        System.out.println(new SDText().i2);
        System.out.println(new SDText().i3);
    }
}
class SDText{
    // �����˳�Ա�����������ʣ�ִ�й�����������ݣ�����Ա�������и�ֵ�����Ľ��ֵ����6
    int i1 = 1;
    {
        i1 = 6;
    }

    int i2=1;
    {
        i2+=6;
    }

    //java��ʼ���б����ִ�У�����a=1������û�о�������ͣ��������Ŀ�ʼ�ң�����û�У����a���ɣ���ǣ��ɳ�Ա����
    //��ʱ�����Ǿ�ֻ�ܸ�ֵ�������������κβ����������ҵ���ͬ���Ķ��壬�ͻ�ѱ�ǵ�ֵ��ͬ��������ͬ�������Լ���ֵ
    //�Ͱ�ǰ��ĸ�ֵ���̸�����
    {
        i3 = 4;
    }
    int i3=2;

    /*{
        i4+=3;
    }

    int i4=1;
    */
}
