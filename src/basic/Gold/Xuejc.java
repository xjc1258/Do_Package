package Gold;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Xuejc {

	public static String getData() {

		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> detail1 = new HashMap<String, Object>();
		detail1.put("out_trade_code", "111");
		detail1.put("currency_code", "222");
		Map<String, Object> detail2 = new HashMap<String, Object>();
		detail2.put("out_trade_code", "333");
		detail2.put("currency_code", "444");
		list.add(detail1);
		list.add(detail2);
		System.out.println(list);
		JSONObject object = new JSONObject();
		object.put("biz_request_content", list);
		return object.toString();

	}

	public static String SynAccountInfo(String json) {
		JSONObject parseObject = JSON.parseObject(json);
		JSONArray dataArray = parseObject.getJSONArray("biz_request_content");
		for (int i = 0; i < dataArray.size(); i++) {
			JSONObject dataJson = JSONObject.parseObject(dataArray.getString(i));
			System.out.println(dataJson.getString("out_trade_code"));
			System.out.println(dataJson.getString("currency_code"));
		}
		return "xjc";

	}

	public static void main(String[] args) {
		System.out.println(getData());
		//SynAccountInfo(getData());
	}
}
