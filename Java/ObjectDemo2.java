package cn.commandoptionesc.object;
public class ObjectDemo2{
    public static void main(String[] args){
        //创建对象
        Baby b=new Baby("lol",12);
        System.out.println(b.name+","+b.age);
    }
}
//婴儿类
class Baby{
    //属性
    int age;
    String name;
    char gender;

    //构造代码块---属性初始化
    //构造代码块会在每个构造方法之前先执行
    {
        this.name="lili";
        this.age=1;
    }

    //构造方法
    public Baby(){
        /* this.name="lili";
           this.age=1;*/
    }

    //有参构造
    public Baby(int age){
        /* this.name="lili";
           this.age=1;*/
        //this.age=age;
    }

    //
    public Baby(String name,int age){
        /* this.name=name;
           this.age=age;*/
        /*this.name="lili";
          this.age=1;*/
    }
    //方法
    public void Cry(){
        System.out.println(this.name+"在哇哇哇的哭");
    }
}
