package cn.commandoptionesc;

public class StudentDemo {
    public static void main(String[] args){
        //用Student类创建一个代表学生对象
        Student s = new Student();
        //想要给s对象中的name属性赋值为"大明"
        // .可以理解为"的"
        s.name = "大明";
        //打印s的name属性的值
        System.out.println(s.name);
        //给s对象的age属性赋值为15
        s.age = 15;
        //想要调用study方法，表示大明在学习Java
        s.study("Java");

        //打印s对象，理论上因为s在栈内存中存储的是地址，所以打印的结果应该也是一个地址
        System.out.println(s);
        System.out.println(s.gender);
        System.out.println(s.grade);
        System.out.println(s.no);
    }
}


//定义一个类表示学生
class Student{
    //姓名、年龄、性别、班级、学号
    String name;
    int age;
    byte gender;
    String grade;
    String no;

    //定义方法表示“学习”行为
    public void study(String subject){
        System.out.println(name + "在学习" + subject);
    }

    //定义方法表示“吃”行为
    public void eat(String food){
        System.out.println(name + "再吃" + food);
    }


    //定义方法表示“玩耍”行为
    public void play(){
        System.out.println(name + "在玩耍");
    }
}
