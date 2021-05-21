package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

/*
 * @author xjc
 * @date 2021-05-21
 * @desc list集合之间的操作
 */
public class TwoListForDeleteChongFuDeKeng {
	public static void main(String[] args) {
		List<String> def20List = new ArrayList<String>();
		def20List.add("0001A110000000002MD2");
		def20List.add("0001A110000000002MCA");
		def20List.add("0001A110000000002MBG");
		def20List.add("0001A110000000002MIY");

		List<String> targetOrgIds = new ArrayList<String>();
		targetOrgIds.add("0001A110000000002MD2");

		/*
		 * 方法一
		 */
		def20List.removeAll(targetOrgIds);
		/*
		 * 方法二
		 */
		Iterator<String> iterator = def20List.iterator();
		while (iterator.hasNext()) {
			String item = iterator.next();
			for (int i = 0; i < targetOrgIds.size(); i++) {
				if (targetOrgIds.get(i).equals(item)) {
					iterator.remove();
				}
			}
		}
		System.out.println(def20List);
	}

	/*
	 * 《《重要----分割数组在去除是有问题的》》
	 */
	@Test
	public void stringBuild() {
		String a = "a,b,c,d,e";
		String[] split = a.split(a);

		List<String> asList = Arrays.asList(split);
		Iterator<String> iterator = asList.iterator();
		while (iterator.hasNext()) {
			String item = iterator.next();
			if ("a".equals(item)) {
				iterator.remove();
			}
		}
		System.out.println(asList);
		/*
		 * Exception in thread "main" java.lang.UnsupportedOperationException
		 * Arrays.asList不支持删除操作
		 */
	}
}
