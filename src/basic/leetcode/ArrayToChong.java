package basic.leetcode;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/*
 * @author xjc
 * @date 2021-05-19
 * @desc 去掉数组中的重复数字(有序)
 */
public class ArrayToChong {
	/*
	 * 只是去掉重复的元素()
	 */
	public static int RemoveChong(int[] nums) {
		int length = nums.length;
		if (length == 0) {
			return 0;
		}
		int t = 0;
		// ||是或的意思
		for (int i = 0; i < nums.length; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				nums[t++] = nums[i];
			}
		}
		return t;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 1, 2, 2, 3, 4, 5, 6 };
		System.out.println(RemoveChong(nums));

	}

	/*
	 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素
	 * 
	 * @study 异或运算
	 * 
	 * @desc 只出现一次的数字 使用异或运算 ，其中 nn 是数组长度。只需要对数组遍历一次。 时间复杂度：O(n) 空间复杂度：O(1)。
	 */
	@Test
	public void ForChuXianOne() {
		int[] nums = new int[] { 2, 1, 2, 1, 3, 4, 6, 4, 6 };
		int single = 0;
		for (int num : nums) {
			single ^= num;
		}
		System.out.println(single);

	}

	/*
	 * 利用hash的方法找只出现一次的数据
	 * 
	 * @desc Time: O(n) Space: O(n)
	 */
	@Test
	public void singleNumber() {
		int[] nums = new int[] { 2, 1, 2, 1, 3, 4, 6, 4, 6 };
		Map<Integer, Integer> map = new HashMap<>();
		for (Integer i : nums) {
			Integer count = map.get(i);
			count = count == null ? 1 : ++count;
			map.put(i, count);
		}
		for (Integer i : map.keySet()) {
			Integer count = map.get(i);
			if (count == 1) {
				System.out.println(i);
			}
		}
		System.out.println(-1);  // can't find it.
	}

}
