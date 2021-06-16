package basic.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
 * @author xjc
 * @date 2021-05-25
 * @desc 取两个数组的交集
 */
public class TwoArrayForGongTong {
	public static void main(String[] args) {
		int[] num1 = new int[] { 1, 2, 2, 1 };
		int[] num2 = new int[] { 2, 2 };
		// 这个输出的是 [2]
		intersection(num1, num2);

	}

	/*
	 * 自己的写法
	 */
	public int[] intersectionxjc(int[] num1, int[] num2) {
		Set<Integer> d = new HashSet<Integer>();
		int[] res = new int[] {};

		for (int i = 0; i < num1.length; i++) {
			for (int j = 0; j < num2.length; j++) {
				if (num1[i] == num2[j]) {
					d.add(num1[i]);
				}
			}

		}

		return null;
	}

	/*
	 * 官方的解答
	 */
	public static int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set1 = new HashSet<Integer>();
		Set<Integer> set2 = new HashSet<Integer>();
		for (int num : nums1) {
			set1.add(num);
		}
		for (int num : nums2) {
			set2.add(num);
		}
		return getIntersection(set1, set2);
	}

	public static int[] getIntersection(Set<Integer> set1, Set<Integer> set2) {
		if (set1.size() > set2.size()) {
			return getIntersection(set2, set1);
		}
		Set<Integer> intersectionSet = new HashSet<Integer>();
		for (int num : set1) {
			if (set2.contains(num)) {
				intersectionSet.add(num);
			}
		}
		int[] intersection = new int[intersectionSet.size()];
		int index = 0;
		for (int num : intersectionSet) {
			intersection[index++] = num;
		}
		return intersection;
	}

}
