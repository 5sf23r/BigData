class ForDemo7{
    public static void main(String[] args){
        int count=0;
        for(int i=100;i<1000;i++){
            int ge=i%10;
            int shi=i/10%10;
            int bai=i/100;
            if(i==ge*ge*ge+shi*shi*shi+bai*bai*bai){
                count++;
            }
        }
        System.out.println(count);
    }
}
