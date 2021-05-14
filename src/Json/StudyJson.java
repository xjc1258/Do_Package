package Json;

import java.util.ArrayList;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class StudyJson {

	public void doPostTestTwo() {
	}
	public static void main(String[] args) {
		User user = new User();
		user.setName("潘晓婷");
		user.setAge(18);
		user.setGender("女");
		user.setMotto("姿势要优雅~");
		ArrayList<User> list = new ArrayList<User>();
		list.add(user);
	//	String jsonString = JSON.toJSONString(list);
		JSONObject o = new JSONObject();
		o.put("data", list);
		//System.out.println(o);
		System.out.println(o);
	}

}
