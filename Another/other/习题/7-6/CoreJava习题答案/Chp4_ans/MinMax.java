package chp4;

public class MinMax {
	public static void main(String[] args) {
		int[] a = {1,3,7,5,3,-1};
		minMax(a);
	}
	public static void minMax(int[] a){
		if (a == null || a.length == 0) return;
		//用变量min来统计数组中的最小值
		//用变量max来统计数组中的最大值
		//先让min和max都等于a[0]
		//然后扫描数组中剩下的元素
		//	如果某个元素比max更大，则把该元素的值赋值给max
		//	如果某个元素比min更小，则把该元素的值赋值给min
		//这样，当扫描完成时
		//min中保存的就是最小的元素，max中保存的是最大的元素
		
		int min = a[0], max = a[0];
		for(int i = 1; i<a.length; i++){
			if (min > a[i]){
				min = a[i];
				continue;
			}
			if (max < a[i]){
				max = a[i];
				continue;
			}
		}
		System.out.println(min);
		System.out.println(max);
	}
}
