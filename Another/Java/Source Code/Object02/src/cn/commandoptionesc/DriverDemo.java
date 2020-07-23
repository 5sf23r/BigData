package cn.commandoptionesc;

public class DriverDemo {
    //创建Driver
    //构造方法、构造函数
    //这个类目前只提供了含参构造，所以只能调用含参构造来创建对象，而无法调用无参构造
    Driver d = new Driver("Amy",19,(byte)0);
    //当提供了无参构造，那么意味着可以利用无参构造创建对象
    Driver d2 = new Driver();
}

class Driver{
    String name;
    int age;
    byte gender;
    //驾照号
    String no;

    //当一个类中没有手动定义构造函数的时候，那么这个类在编译完成之后自动添加一个无参构造函数
    //与类同名，但是没有返回值类型
    //利用new关键字来调用构造方法，利用构造方法来创建对象
    public Driver(){

    }

    //定义一个含参构造
    //一个类中如果手动定义了构造方法，那么这个类在编译的时候就不会自动添加构造方法
    public Driver(String n,int a,byte g){
        if(a<18){
            System.out.println("年龄不合法，死机的最小年龄应该是18");
            //可以利用利用return来规避不合理的值，结束构造方法
            return;
        }
        name = n;
        age = a;
        gender = g;
    }
}
