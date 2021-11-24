package basic.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @author xjc
 * @date 2021-05-26
 * @desc 两个数组取交集(2)
 */
public class TwoArrayForJiaoJi {
	public static void main(String[] args) {
		int[] nums1 = new int[] { 1, 2, 2, 1 };
		int[] nums2 = new int[] { 2, 2 };
		// 输出必须是[2,2]
		getJiaoJi(nums1, nums2);
	}

	public static int[] getJiaoJi(int[] nums1, int[] nums2) {
		//其实就是一个过滤网
		if (nums1.length > nums2.length) {
			return getJiaoJi(nums2, nums1);
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int num : nums1) {
			// getOrDefault的意思是
			// 获取指定 key 对应对 value，如果找不到 key ，则返回设置的默认值
			int count = map.getOrDefault(num, 0) + 1;
			map.put(num, count);
		}
		int[] intersection = new int[nums1.length];
		int index = 0;
		for (int num : nums2) {
			int count = map.getOrDefault(num, 0);
			if (count > 0) {
				intersection[index++] = num;
				count--;
				if (count > 0) {
					map.put(num, count);
				} else {
					map.remove(num);
				}
			}
		}
		return Arrays.copyOfRange(intersection, 0, index);
	}
	// HashMap containsKey() 方法 来验证是否有这个key

	// 时间复杂度：O(m+n)，其中 mm 和 nn 分别是两个数组的长度。需要遍历两个数组并对哈希表进行操作，哈希表操作的时间复杂度是
	// O(1)，因此总时间复杂度与两个数组的长度和呈线性关系。
	// 空间复杂度：O(min(m,n))，其中 mm 和 nn
	// 分别是两个数组的长度。对较短的数组进行哈希表的操作，哈希表的大小不会超过较短的数组的长度。为返回值创建一个数组
	// intersection，其长度为较短的数组的长度。

}
