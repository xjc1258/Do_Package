package basic.TreeMap;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Test;

/*
 * @author xjc
 * @date 2021-06-23
 * @desc treemap的基本使用方式
 */
public class TreeMapStudy {
	/*
	 * treemap是红黑树的实现，查找和删除的效率比较高； 如果排序的情况下，使用treemap，否则优先选择hashmap
	 */
	@Test
	public void one() {
		Map<String, String> tree = new TreeMap<String, String>();
		tree.put("1", "1");
		tree.put("2", "1");
		tree.put("3", "1");
		tree.put("4", "1");
		tree.put("5", "1");
		Iterator<Entry<String, String>> iterator = tree.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, String> next = iterator.next();
			System.out.println(next.getKey() + "+++" + next.getValue());

		}
		//treemap竟然可以键重复
		//和hashmap都是线程不安全的

	}

}
