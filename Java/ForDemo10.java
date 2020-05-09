class ForDemo10{
    public static void main(String[] args){
        int n=4;
        for(int x=1;x<=n;x++){
            for(int y=0;y<n-x;y++){
                System.out.print(" ");
            }
            for(int z=1;z<=2*x-1;z++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
