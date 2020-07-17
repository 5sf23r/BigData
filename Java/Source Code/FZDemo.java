package cn.commandoptionesc.fengzhuang;
public class FZDemo{
    public static void main(String[] args){
        //创建对象
        /*Person p=new Person(-10);
        //赋值
        p.name="lili";
        p.age=10;
        p.gender='女';
        System.out.println(p.age);
        */
        Person p=new Person();
        p.setAge(10);
        System.out.println(p.getAge());
    }
}
//Person类
class Person{
    //属性
    private String name;
    //私有化属性
    private int age;
    private char gender;


    
    //方法---公共的访问方式
    public void setAge(int age){
        //判断
        if(age<0){
            System.out.println("数据有误");
        }else{
            this.age=age;
        }
    }
    public int getAge(){
        return age;
    }


    /* //有参构造
    public Person(int age){
        //对参数做判断
        if(age<0){
            System.out.println("数据有误");
            return;
        }else{
            this.age=age;
        }
    }
    */

    //方法
    public void eat(){
        System.out.println("在吃东西");
    }
}
