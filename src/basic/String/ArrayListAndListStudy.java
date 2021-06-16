package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

public class ArrayListAndListStudy {
	public static void main(String[] args) {

		java.util.Map<String, Object> rrrr = new HashMap<>();
		rrrr.put("creditCard", "222");
		rrrr.put("material", "66");
		rrrr.put("orderamount", "222");
		rrrr.put("tradeMoney", "66");
		rrrr.put("year", "2021");
		rrrr.put("month", "04");
		rrrr.put("day", "19");
		rrrr.put("phone", "18792642388");
		String x = JSONObject.toJSONString(rrrr);
		System.out.println(x);
		List<java.util.Map<String, Object>> list = new ArrayList<java.util.Map<String, Object>>();
		list.add(rrrr);
		ArrayList<java.util.Map<String, Object>> arrayList = new ArrayList<java.util.Map<String, Object>>();
		arrayList.add(rrrr);
		String www = JSONObject.toJSONString(arrayList);
		System.out.println(list);
		System.out.println(www);
		//总结：其实map中的string和object是没有区别的
	}

}
