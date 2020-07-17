package cn.commandoptionesc.staticx;
public class StaticDemo6{
    public static void main(String[] args){
        new DB();
    }
}
class DA{
    //static DC d;
    DD dd = new DD();
    static{
        System.out.println("DA 1");
    }

    {
        System.out.println("DA 2");
    }

    public DA(){
        System.out.println("DA 3");
    }
}
class DB extends DA{
    static{
        System.out.println("DB 1");
    }

    {
        System.out.println("DB 2");
    }

    public DB(){
        System.out.println("DB 3");
    }
}
class DC{
    public DC(){
        System.out.println("DC");
    }
}
class DD extends DC{
    public DD(){
        System.out.println("DD");
    }
}




