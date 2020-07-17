public class Ex{
    public static void main(String[] args){
        int[] a={1,2,3,4,5};
        expand(a);
        System.out.println(a);

        changeArray(a);
        System.out.println(a[0]);

        printArray(a);
    }
    public static void expand(int[] a){
        int[] newArray=new int[a.length*2];
        System.arraycopy(a,0,newArray,0,a.length);
        a=newArray;

        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+"\t");
        }
        System.out.println();

        System.out.println(a);
    }
    public static void changeArray(int[] a){
        a[0]=10;
        System.out.println(a[0]);
    }
    public static void printArray(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+"\t");
        }
        System.out.println();
    }
}
