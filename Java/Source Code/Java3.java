class Java3{
    public static void main(String[] args){
        for(int i=1;i<=9;i++){
            for(int j=1;j<=i;j++){
                // int m=i*j;
                // System.out.print(j+"*"+i+"="+m);
                System.out.print(j+"*"+i+"="+(i*j)+'\t');
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
