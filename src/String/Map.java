package String;

import java.util.ArrayList;
import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;

public class Map {

	public static void main(String[] args) {
		ArrayList<String> perlist = new ArrayList<String>();
		for (int i = 0; i < 4; i++) {
			java.util.Map<String, Object> customermap = new HashMap<String, Object>();
			Person p = new Person();
			customermap.put("1", "2");
			customermap.put("2", "2");
			customermap.put("3", "2");
			customermap.put("4", "2");
			customermap.put("5", "2");
			customermap.put("6", "2");
			customermap.put("7", "2");

			perlist.add(customermap.toString());
		}
		// 对string求长度
		String s = "a,b,c,d";
		String w = "200";
		// System.out.println(s.length());
		// System.out.println(w.length());
		System.out.println(buildHahahah());
		System.out.println(build());
	}

	/*
	 * @author xjc
	 * 
	 * @data 2021.05.10
	 */
	public static String buildHahahah() {
		java.util.Map<String, Object> map1 = new HashMap<String, Object>();
		java.util.Map<String, Object> map2 = new HashMap<String, Object>();
		map1.put("1", "2");
		map1.put("2", "2");
		map1.put("3", "2");

		map2.put("4", "2");
		map2.put("5", "2");
		map2.put("6", "2");
		// 构建外层arraylist
		ArrayList<java.util.Map<String, Object>> l1 = new ArrayList<java.util.Map<String, Object>>();
		l1.add(map1);
		l1.add(map2);
		// 构建内层arraylist
		ArrayList<java.util.Map<String, Object>> l2 = new ArrayList<java.util.Map<String, Object>>();
		java.util.Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("a", "1");
		map3.put("b", "2");
		map3.put("wl", l1);
		l2.add(map3);

		// 最后构建map，将map转变成JSONObject并转成jsonstring
		java.util.Map<String, Object> map4 = new HashMap<String, Object>();
		map4.put("data", l2);

		return (new JSONObject(map4)).toJSONString();
	}

	/*
	 * @author xjc
	 * 
	 * @data 2021.05.10 另外的格式
	 */
	public static String build() {
		ArrayList<java.util.Map<String, Object>> l1 = new ArrayList<java.util.Map<String, Object>>();
		java.util.Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("1", "value");
		java.util.Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("1", "value");
		java.util.Map<String, Object> map4 = new HashMap<String, Object>();
		map4.put("1", "value");
		java.util.Map<String, Object> map5 = new HashMap<String, Object>();
		map5.put("1", "value");
		l1.add(map1);
		l1.add(map3);
		l1.add(map4);
		l1.add(map5);

		java.util.Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("error", "0");
		map2.put("data", l1);
		map2.put("errmessage", "成功");
		return (new JSONObject(map2)).toJSONString();
	}

}
