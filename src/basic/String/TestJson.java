package basic.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class TestJson {
	/*
	 * public static void main(String[] args) { String a = "123"; String b =
	 * "1"; JSONObject json = new JSONObject(); json.put("a", a); json.put("b",
	 * b); System.out.println(json); }
	 */

	public static void main(String[] args) {
		ArrayList<Map<String, Object>> perlist = new ArrayList<Map<String, Object>>();
		Person p1 = new Person();
		p1.setBanji("1");
		p1.setChushengdi("1");
		p1.setCun("1");
		p1.setName("1");
		p1.setXuexiao("1");

		Person p2 = new Person();
		p2.setBanji("2");
		p2.setChushengdi("2");
		p2.setCun("2");
		p2.setName("2");
		p2.setXuexiao("2");
		Person[] per = new Person[] { p1, p2 };

		if (per != null && per.length > 0) {
			for (int i = 0; i < per.length; i++) {
				Map<String, Object> customermap = new HashMap<String, Object>();

				// Person pppp = new Person();
				// pppp.setBanji(per[i].getBanji());
				customermap.put("1", per[i].getBanji());
				perlist.add(customermap);
			}
		}
		System.out.println(perlist);
		Person[] array = (Person[]) perlist.toArray(new Person[0]);
		System.out.println(array);
		/*
		 * String object = JSONObject.toJSONString(p1); String array =
		 * JSONArray.toJSONString(object);
		 */
		// System.out.println(perlist);
		/*
		 * JSONObject object = new JSONObject(); object.put("data", perlist);//
		 * customer为 具体入参参数。 object.put("fqr","NCC");
		 * object.put("sysRec","NCC系统对应调用接口人员");
		 * System.out.println(object.toString());
		 */
		// JSON.toJSON(map);
		/*
		 * System.out.println(object); String jsonstr = array.toString(); String
		 * string = per.toString();
		 */

		/*
		 * Map<String, Person> map = new HashMap<String, Person>(); if (per !=
		 * null && per.length > 0) { for (int i = 0; i < per.length; i++) {
		 * map.put(per[i].getName(), per[i]); } }
		 */

	}

}
