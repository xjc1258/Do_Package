package basic.MapXUE;

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
			// 插入和遍历的顺序是不一样的，集合是无序的
		}
		/*
		 * 不同于hashmap的哈希映射，treemap实现了红黑树的结构 ;
		 * 支持序列化，是因为实现了Java.io.Serializable；
		 * 支持null键，null值
		 * 
		 * 
		 */
	}
}
