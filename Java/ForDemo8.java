class ForDemo8{
    public static void main(String[] args){
        for(int i=10000;i<100000;i++){
            int ge=i%10;
            int shi=i/10%10;
            int bai=i/100%10;
            int qian=i/1000%10;
            int wan=i/10000;
            if((ge==wan)&&(shi==qian)&&(ge+shi+qian+wan==bai)){
                System.out.println(i);
            }
        }
    }
}
