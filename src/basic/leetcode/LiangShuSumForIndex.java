package basic.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LiangShuSumForIndex {
	/*
	 * @author xjc
	 * 
	 * @date 2021-05-11 目标值=两数之和，返回下标
	 */

	public static int[] getIndex(int[] nums, int target) {
		//新建需要返回的空的数组，放下标值，length是2
		int[] res = new int[2];
		Map<Integer, Integer> map = new HashMap<>(2);
		for (int i = 0; i < nums.length; ++i) {
			if (map.containsKey(nums[i])) {
				res[0] = map.get(nums[i]);
				res[1] = i;
				return res;
			}
			map.put(target - nums[i], i);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] array = new int[] { 3, 4, 5, 6 };
		int tar = 8;
		System.out.println(getIndex(array, tar)[0]);
		System.out.println(getIndex(array, tar)[1]);
	}
}
