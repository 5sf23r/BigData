package cn.commandoptionesc.extendsx;
public class ExtendsDemo{
    public static void main(String[] args){
        //创建医生类对象
        Doctor d=new Doctor();
        d.age=10;
        d.treat();
    }
}

//医疗人员类---父类、超类、基类
class Person{
    //属性
    String name;
    int age;
    char gender;
    //工号
    String nu;

    //方法
    public void treat(){
        System.out.println("在治病救人...");
    }
}
//医生类---子类、派生类
//继承---通过extends使得医生类和医疗人员类产生了关联关系
class Doctor extends Person{
    public void treat(){
        System.out.println("拿着手术刀在治病救人");
    }
}
//护士类
class Nurse extends Person{
    
}
