package learn;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.junit.Test;

public class Map {

	public static void main(String[] args) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		Student stu0 = new Student("0", 12, 12);
		Student stu1 = new Student("1", 12, 12);
		Student stu2 = new Student("2", 12, 12);
		Student stu3 = new Student("3", 12, 12);
		Student stu4 = new Student("4", 12, 12);
		map.put("0", stu0);
		map.put("1", stu1);
		map.put("2", stu2);
		map.put("3", stu3);
		map.put("4", stu4);

		// 循环键值
		Iterator<Entry<String, Object>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, Object> entry = it.next();
			System.out.println(entry.getKey() + "====" + entry.getValue());
		}
		// hashmap的remove方法
		Object remove = map.remove("4");
		System.out.println(remove);

	}

	@Test
	public void Haaa() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");
		map.put("5", "5");
		map.put("6", "6");
		map.put("7", "7");

		String remove = map.remove("7");
		System.out.println(remove);
		for (Entry<String, String> en : map.entrySet()) {
			System.out.println(en.getKey());
		}
	}

}
