package chp10;
import java.util.*;
public class TestGroup {

	public static void main(String[] args) {
		List teamList = new ArrayList();
		teamList.add("科特迪瓦");
		teamList.add("阿根廷");
		teamList.add("澳大利亚");
		teamList.add("塞尔维亚");
		teamList.add("荷兰");
		teamList.add("尼日利亚");
		teamList.add("日本");
		teamList.add("美国");
		teamList.add("中国");
		teamList.add("新西兰");
		teamList.add("巴西");
		teamList.add("比利时");
		teamList.add("韩国");
		teamList.add("喀麦隆");
		teamList.add("洪都拉斯");
		teamList.add("意大利");
		
		List groupList = new ArrayList();
		groupList.add(new ArrayList());
		groupList.add(new ArrayList());
		groupList.add(new ArrayList());
		groupList.add(new ArrayList());
		
		for(int i = 0; i<teamList.size(); i++){
			//写一个循环
			//groupIndex为抽签结果
			//当抽出的小组已满时，必须要重新抽签，直到找到一个未满的小组
			int groupIndex = 0;
			do{
				groupIndex = getRandom();
			}while( ((List)groupList.get(groupIndex)).size() == 4 );
			
			List l = (List) groupList.get(groupIndex);
			l.add(teamList.get(i));
		}
		
		
		//打印
		for(int i = 0; i<groupList.size(); i++){
			System.out.println("Group " + (char)('A' + i));
			List l = (List) groupList.get(i);
			for(int j = 0; j<l.size(); j++){
				System.out.print(l.get(j) + "\t");
			}
			System.out.println();
		}
		
	}
	
	public static int getRandom(){
		int n = (int)(Math.random() * 100 % 4);
		return n;
	}

}
