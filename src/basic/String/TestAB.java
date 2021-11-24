package basic.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestAB {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		List<Map<String, Object>> contentMapList = new ArrayList<Map<String, Object>>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("keyword1", "#173177");
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("keyword2", "#173177");
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("keyword3", "#173177");
		Map<String, Object> map4 = new HashMap<String, Object>();
		map4.put("keyword4", "#173177");
		contentMapList.add(map1);
		contentMapList.add(map2);
		contentMapList.add(map3);
		contentMapList.add(map4);
		
		
		Map<Integer, Object> h1 = new HashMap<Integer, Object>();
		h1.put(1, "keyword1");
		h1.put(1, "keyword2");
		h1.put(3, "keyword3");
		h1.put(4, "keyword4");
		

	}

}
