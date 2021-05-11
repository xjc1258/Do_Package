package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Testkkk {

	public static void main(String[] args) {
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> customermap = new HashMap<>();
		customermap.put("1", 1);
		customermap.put("code", 2);
		customermap.put("3", 3);
		customermap.put("4", 4);
		list.add(customermap);
		Map<String, Object> rrrr = new HashMap<>();
		rrrr.put("11", "222");
		rrrr.put("2", "66");
		String x =JSONObject.toJSONString(rrrr);
		System.out.println(x);
		/*
		 * Person p1 = new Person(); p1.setBanji("1"); p1.setChushengdi("1");
		 * p1.setCun("1"); p1.setName("1"); p1.setXuexiao("1");
		 */
		/*JSONObject object = new JSONObject();
		object.put("data", list);
		object.put("fqr", "NCC");
		object.put("sysRec", "NCC系统对应调用接口人员");
		System.out.println(object);*/

		//String x =JSONObject.toJSONString(data);
		// String string = object.toString();
		/*
		 * JSONArray array = object.getJSONArray("data");
		 * 
		 * for (int i = 0; i < array.size(); i++) { JSONObject o =
		 * array.getJSONObject(i); System.out.println(o.get("code")); }
		 */

	}

}
