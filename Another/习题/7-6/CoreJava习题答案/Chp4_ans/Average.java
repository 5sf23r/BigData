package chp4;

public class Average {

	public static void main(String[] args) {
		System.out.println(aver(new int[]{10, 15, 20, 25}));
	}
	public static double aver(int[] n){
		int sum = 0;
		for(int i = 0; i<n.length; i++){
			sum += n[i];
		}
		return (double)sum / n.length;
	}
}
