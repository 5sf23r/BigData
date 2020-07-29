package cn.commandoptionesc.extendsx;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class ExtendsDemo3 {
    public static void main(String[] args) {
        Pupil p = new Pupil();
        //如果子类中没有重写study方法，则调用父类中的study方法
        //如果子类中重写了study方法，则调用子类中重写的study
        p.study();
        Junior j = new Junior();
        j.study();
        Senior s = new Senior();
        s.study();
    }
}

//代表学生
class Student{

    public void study(){
        System.out.println("在学习中");
    }
}

//小学生
class Pupil extends Student{

    //如果父子类中出现方法签名(方法名和参数列表)一致的非静态方法，则产生了方法的重写/覆盖
    //注解，@override这个主机的作用就是标记这个方法是一个被重写的方法
    @Override
    public void study() {
        //调用父类中的study方法
        //super可以看做是对父类对象的引用，可以看做一个虚拟对象
        //super的作用就是在子类中去调用父类中的方法或者属性
        System.out.println("小学生学习的课程比较简单");
    }
}

//初中生
class Junior extends Student{
    public void study(){
        System.out.println("初中生要学习很多课程");
    }
}


//高中生
class Senior extends Student{

}
