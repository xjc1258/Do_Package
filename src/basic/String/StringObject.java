package basic.String;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

public class StringObject {

	public static void main(String[] args) {

		List<Person> list = new ArrayList<Person>();
		Person p1 = new Person();
		p1.setBanji("1");
		p1.setChushengdi("2");
		p1.setCun("3");
		p1.setName("4");
		p1.setXuexiao("5");
		Person p2 = new Person();
		p2.setBanji("6");
		p2.setChushengdi("7");
		p2.setCun("8");
		p2.setName("9");
		p2.setXuexiao("10");
		list.add(p1);
		list.add(p2);

		String string = JSONObject.toJSONString(list);
		JSONObject parseObject = JSONObject.parseObject(string);
		System.out.println(parseObject);
	}

}
