package Json;

import com.alibaba.fastjson.JSON;

public class StudyJson {

	public void doPostTestTwo() {
	}
	public static void main(String[] args) {
		User user = new User();
		user.setName("潘晓婷");
		user.setAge(18);
		user.setGender("女");
		user.setMotto("姿势要优雅~");
		String jsonString = JSON.toJSONString(user);
		System.out.println(jsonString);
	}

}
