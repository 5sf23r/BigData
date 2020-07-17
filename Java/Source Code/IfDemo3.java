class IfDemo1{
    public static void main(String[] args){
        int a=10;
        int b=1;
        int c=8;
        if(a>b){
            if(a>c){
                System.out.println(a);
            }else{
                System.out.println(c);
            }
        }else{
            if(b>c){
                System.out.println(b);
            }else{
                System.out.println(c);
            }
        }
    }
}
