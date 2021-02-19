package chp10;
import java.util.*;

import com.kettas.common.SystemIn;
public class TestWorldCup {

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
		
		String year = SystemIn.readString();
		if (worldCupMap.containsKey(year)){
			System.out.println(worldCupMap.get(year));
		}else{
			System.out.println(year + "没有举行世界杯");
		}
	}

}
