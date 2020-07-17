class LianXi{
    public static void main(String[] args){
        int x=0;
        int y=0;
        int z=0;
        for(x=0;x<=33;x++){
            for(y=0;y<=50;y++){
                z=100-x-y;
                if(z%3==0){
                    if(3*x+2*y+(z/3)==100){
                        System.out.println(x+" "+y+" "+z);
                    }
                }
            }
        }
    }
}
