package chp4;

public class TestBubbleSort {

	public static void main(String[] args) {
		int[] a = {3,1,2,5,4};
		printArray(a);
		bubbleSort(a);
		printArray(a);
	}
	
	public static void bubbleSort(int[] a){
		for(int i = 0; i<a.length; i++){
			for(int j = 0; j<i; j++){
				if(a[j] > a[i]){
					int t = a[i];
					a[i] = a[j];
					a[j] = t;
				}
			}
		}
	}
	
	public static void printArray(int[] a){
		for(int i = 0; i<a.length; i++){
			System.out.print(a[i] + "\t");
		}
		System.out.println();
	}
}
