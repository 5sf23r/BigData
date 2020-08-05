package chp4;

public class TestSelectSort {
	public static void main(String[] args) {
		int[] a = {3,1,2,5,4};
		printArray(a);
		selectSort(a);
		printArray(a);
	}
	
	public static void selectSort(int[] a){
		for(int i = 0; i<a.length; i++){
			int min = a[i];
			int minIndex = i;
			for(int j = i+1; j<a.length; j++){
				if (a[j] < min){
					min = a[j];
					minIndex = j;
				}
			}
			if (minIndex != i){
				int t = a[i];
				a[i] = a[minIndex];
				a[minIndex] = t;
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
