package DaPao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Study {

	@SuppressWarnings("unused")
	private String savePs(String data) throws DataAccessException {

		Map<String, Object> resMap = new HashMap<String, Object>();
		if (data == null || data.equals("")) {
			resMap.put("msg", "参数为空，调用失败");
			return JSON.toJSONString(resMap);
		}
		JSONObject json;
		try {
			json = JSONObject.parseObject(data);
		} catch (Exception e) {
			resMap.put("msg", "参数格式有误");
			return JSON.toJSONString(resMap);
		}
		Long group_id = json.getLong("group_is");
		String hos_id = json.getString("hos_id");
		String copy_code = json.getString("copy_code");
		String sup_id = json.getString("sup_id");

		JSONArray array = json.getJSONArray("Rows");
		int count = 0;
		if (array != null || array.size() > 0) {
			//for(array){
				
			//}
			

		}

		return JSON.toJSONString(resMap);

	}

}
