package cn.commandoptionesc.object;
public class ObjectDemo2{
    public static void main(String[] args){
        //创建对象
        Baby b=new Baby();
        System.out.println("b.name:"+b.name+","+"b.age:"+b.age);


        Baby b1=new Baby("lol",12);
        System.out.println("b1.name:"+b1.name+","+"b1.age:"+b1.age);


        //创建匿名对象,调用属性和方法
        new Baby("lilei",13).Cry();


        //用于参数传递
        //给对象传值
        m(Baby());

    }
    public static void m(Bybu b){}
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
        //检验构造代码块是否在每个构造方法前执行
        System.out.println("构造代码块");
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
        System.out.println("有参构造");
    }
    //方法
    public void Cry(){
        System.out.println(this.name+"在哇哇哇的哭");
    }
}
