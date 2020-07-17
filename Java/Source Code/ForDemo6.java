class ForDemo6{
    public static void main(String[] args){
        for(int i=100;i<1000;i++){
            int ge=i%10;
            int shi=i/10%10;
            int bai=i/100;
            if(i==ge*ge*ge+shi*shi*shi+bai*bai*bai){
                System.out.println(i);
            }
        }
    }
}
