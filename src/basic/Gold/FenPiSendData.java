package basic.Gold;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 * @author xjc
 * @date 2021-07-30
 * @desc 分批发送数据
 */
public class FenPiSendData {

	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", "1");
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("2", "2");
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("3", "3");
		Map<String, Object> map4 = new HashMap<String, Object>();
		map4.put("4", "4");
		Map<String, Object> map5 = new HashMap<String, Object>();
		map5.put("5", "5");
		List<Map<String, Object>> list = new ArrayList<>();

		list.add(map);
		list.add(map2);
		list.add(map3);
		list.add(map4);
		list.add(map5);
		int u = 1;
		List<Map<String, Object>> newList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			newList.add(list.get(i));
			if (u == newList.size() || i == list.size() - 1) {
				System.out.println("1");
				newList.clear();
			}

		}
	}

}
