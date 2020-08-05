package chp10;
import java.util.*;

import com.kettas.common.SystemIn;
public class TestWorldCup2 {

	public static void main(String[] args) {
		Map worldCupMap = new HashMap();
		worldCupMap.put("1930", "乌拉圭");
		worldCupMap.put("1934", "意大利");
		worldCupMap.put("1938", "意大利");
		worldCupMap.put("1950", "乌拉圭");
		worldCupMap.put("1954", "德国");
		worldCupMap.put("1958", "巴西");
		worldCupMap.put("1962", "巴西");
		worldCupMap.put("1966", "英格兰");
		worldCupMap.put("1970", "巴西");
		worldCupMap.put("1974", "德国");
		worldCupMap.put("1978", "阿根廷");
		worldCupMap.put("1982", "意大利");
		worldCupMap.put("1986", "阿根廷");
		worldCupMap.put("1990", "德国");
		worldCupMap.put("1994", "巴西");
		worldCupMap.put("1998", "法国");
		worldCupMap.put("2002", "巴西");
		worldCupMap.put("2006", "意大利");
		
		String team = SystemIn.readString();
		
		if (!worldCupMap.containsValue(team)){
			System.out.println("没有获得过世界杯");
		}else{
			Set set = worldCupMap.keySet();
			Iterator iter = set.iterator();
			while(iter.hasNext()){
				Object key = iter.next();
				if (worldCupMap.get(key).equals(team)){
					System.out.print(key + "\t");
				}
			}
			System.out.println();
		}
		
	}

}
