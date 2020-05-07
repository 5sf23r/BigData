class ArrayMax1{
    public static void main(String[] args){
        int[] arr={1,5,3,8,2};
        int max = 0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[max]){
                max=i;
            }
        }
        System.out.println(arr[max]);
    }
}
