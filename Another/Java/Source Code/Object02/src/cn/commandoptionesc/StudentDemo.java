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


        //创建了一个Student对象s2
        Student s2 = new Student();
        s2.play();
        s2.study("Java");


        //创建了一个Student对象
        //注意：像这种没有名字的对象称之为匿名对象
        new Student().play();

        //new几次，就会创建几个对象，几个对象的地址是不一样的
        System.out.println(new Student());
        System.out.println(new Student());
        System.out.println(new Student());
        System.out.println(new Student());

        //匿名对象可以作为参数进行传递
        printName(new Student());
    }

    public static void printName(Student s){
        System.out.println(s.name);
    }
}


//定义一个类表示学生
class Student{
    //姓名、年龄、性别、班级、学号
    //属性：成员变量
    String name;
    int age;
    byte gender;
    String grade;
    String no;

    //定义方法表示“学习”行为
    //定义在方法中的变量成为局部变量
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
