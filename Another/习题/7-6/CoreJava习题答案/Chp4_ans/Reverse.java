package chp4;

public class Reverse {

	public static void main(String[] args) {
		int[] a = {3,1,2,5,7};
		printArray(a);
		reverse(a);
		printArray(a);
	}

	public static void reverse(int[] a){
		//i变化范围为数组长度的一半
		for(int i = 0; i<a.length/2; i++){
			//交换a[i]和a[a.length - i - 1]
			int t = a[i];
			a[i] = a[a.length - 1 - i];
			a[a.length - 1 - i] = t;
		}
	}
	public static void printArray(int[] a){
		for(int i = 0; i<a.length; i++){
			System.out.print(a[i] + "\t");
		}
		System.out.println();
	}
}
