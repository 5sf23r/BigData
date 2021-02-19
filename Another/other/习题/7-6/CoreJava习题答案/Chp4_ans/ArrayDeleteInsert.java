public class ArrayDeleteInsert{
	static int[] a = {1,3,5,7,9};
	static int index = 5;
	public static void main(String args[]){	
		printArray(); //1 3 5 7 9
		delete(2);    
		printArray(); // 1 3 7 9
		insert(1, 4);
		printArray(); // 1 4 3 7 9
		insert(2, 6);
		printArray(); // 1 4 6 3 7 9
	}
	public static void delete(int pos){
		// ��pos���������Ԫ����ǰ�ƶ�һλ
		for(int i = pos; i<index-1; i++){
			a[i] = a[i+1];
		}
		index--;
	}
	public static void insert(int pos, int value){
		// �ж�(index == a.length)�����Ƿ��㹻�����������������
		if (index == a.length) expand();
		// posλ���Լ��������е�Ԫ������ƶ�һλ
		for(int i = index; i> pos; i--){
			a[i] = a[i-1];
		}
		
		a[pos] = value;
		index++;
	}
	public static void expand(){
		int[] newArray = new int[a.length * 2];
		System.arraycopy(a, 0, newArray, 0, a.length);
		a = newArray;
	}
	public static void printArray(){
		for(int i = 0; i<index; i++){
			System.out.print(a[i] + "\t");
		}
		System.out.println();
	}
}