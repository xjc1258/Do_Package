package MapXUE;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapXue {
	public static void main(String[] args) {
		// 初始化自定义比较器
		MyComparator comparator = new MyComparator();
		// 初始化一个map集合
		Map<String, String> map = new TreeMap<String, String>(comparator);
		// 存入数据
		map.put("a", "a");
		map.put("b", "b");
		map.put("f", "f");
		map.put("d", "d");
		map.put("c", "c");
		map.put("g", "g");
		// 遍历输出
		Iterator iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			System.out.println(map.get(key));
		}
	}
}
