package basic.MapXUE;

import java.util.HashSet;

/*
 * @author xjc
 * @date 2021-07-20
 * @desc hashset的一些学习
 */
public class HashSetStudy {
	public static void StudyHashSet() {
		HashSet<String> set = new HashSet<>();
		set.add("a");
		set.add("b");
		set.add("c");
		String[] array = set.toArray(new String[set.size()]);
		// hashset变成string数组
	}

}
