package chp4;

public class MonkeyKing{
	public static void main(String args[]){
		//用数组表示15只猴子，true表示没有被淘汰，false表示被淘汰了
		boolean[] monkeys = new boolean[15];
		//统计还剩几只猴子
		int monkeyLeft = 15;
		//记录下只猴子报数的结果
		int num = 1;
		//
		int index = 0;
		
		//初始化
		for(int i = 0; i<monkeys.length; i++){
			monkeys[i] = true;
		}
		
		while(monkeyLeft > 1){
			if (monkeys[index]){
				num++;
				if (num == 8){
					monkeys[index] = false;
					num = 1;
					monkeyLeft--;
				}
			}
			//寻找下一个index
			index++;
			if (index == 15){
				index = 0;
			}
		}
		
		//输出
		for(int i = 0; i<monkeys.length; i++){
			if (monkeys[i]){
				System.out.println(i + 1);
				return;
			}
		}
	}
}