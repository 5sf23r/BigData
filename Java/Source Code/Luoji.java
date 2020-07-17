class LuoJi{
    public static void main(String[] args){
        int a=3;
        int b=4;
        int c=5;
        int a1=3;
        int b1=4;
        int c1=5;
        int a2=3;
        int b2=4;
        int c2=5;
        int a3=3;
        int b3=4;
        int c3=5;
        int a4=3;
        int b4=4;
        int c4=5;
        System.out.println((a++==b)&&(c++>b));
        //4,4,5
        System.out.println(a+","+b+","+c);

        System.out.println((c1++>b1)&&(a1++==b1));
        //4,4,6
        System.out.println(a1+","+b1+","+c1);

        System.out.println(true&&(a2++!=b)||(c2++>b2));
        //4,4,5
        System.out.println(a2+","+b2+","+c2);

        System.out.println(false&&(a3++!=b)||(c3++>b3));
        //3,4,6
        System.out.println(a3+","+b3+","+c3);

        // System.out.println(true||(a4++!=b4)&&(c4++>b4));
        //3,4,5
        // System.out.println(a4+","+b4+","+c4);
        System.out.println(true&&c4++>b4);
        System.out.println(c4);

    }
}
