package order;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Stringq {
	/*
	 * @author xjc
	 * 
	 * @date 2021-04-07
	 */
	public static void main(java.lang.String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "2");
		map.put("2", "2");
		map.put("3", "2");
		map.put("4", "2");
		map.put("5", "2");
		map.put("6", "2");
		map.put("7", "2");
		map.put("8", "2");
		for (Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + entry.getValue());
		}
		// 获取的是cpu核心线程数也就是计算资源
		// Runtime.getRuntime().availableProcessors()方法询问jvm，jvm去问操作系统，操作系统去问硬件
		System.out.println(Runtime.getRuntime().availableProcessors());

	}
}
