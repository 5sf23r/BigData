package chp4;

public class ArrayExpand {

	public static void main(String[] args) {
		
	}
	
	public static int[] expand(int[] array){
		int[] newArray = new int[array.length * 2];
		System.arraycopy(array, 0, newArray, 0, array.length);
		return newArray;
		
	}
	
}
