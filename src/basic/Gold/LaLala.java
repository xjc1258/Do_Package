package basic.Gold;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class LaLala {
	public static void main(String[] args) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		Map<String, Object> failMap = new HashMap<String, Object>();
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar calendar = Calendar.getInstance();
		String dateName = df.format(calendar.getTime());
		
		failMap.put("code", "20000");
		failMap.put("msg", "失败，具体错误详见子码表");
		failMap.put("sub_code", "12344");
		failMap.put("sub_msg", "失败，具体错误详见子码表");
		failMap.put("timestamp", dateName);
		list.add(failMap);
		resMap.put("instr_resp_content", list);

		System.out.println(JSON.toJSONString(resMap));
		
		String[] a = {""};

	}
}
