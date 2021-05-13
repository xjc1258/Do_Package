package leetcode;

import java.util.Arrays;

/*
 * @author xjc
 * @date 2021-05-13
 * @desc 合并两个有序数组
 */
public class HeBingTwoArrayForSort {
	/*
	 * 方法一：直接合并后排序
	 * ++i和i++的区别
	 */
	public static void mergeOne(int[] nums1, int m, int[] nums2, int n) {
		for (int i = 0; i != n; ++i) {
			nums1[m + i] = nums2[i];
		}
		Arrays.sort(nums1);
		System.out.println(nums1.toString());
	}

	/*
	 * 方法二:双指针的方法进行排序--- 两个数组看作队列，每次从两个数组头部取出比较小的数字放到结果中
	 */
	public void mergeTwo(int[] nums1, int m, int[] nums2, int n) {
		int p1 = 0, p2 = 0;
		int[] sorted = new int[m + n];
		int cur;
		while (p1 < m || p2 < n) {
			if (p1 == m) {
				cur = nums2[p2++];
			} else if (p2 == n) {
				cur = nums1[p1++];
			} else if (nums1[p1] < nums2[p2]) {
				cur = nums1[p1++];
			} else {
				cur = nums2[p2++];
			}
			sorted[p1 + p2 - 1] = cur;
		}
		for (int i = 0; i != m + n; ++i) {
			nums1[i] = sorted[i];
		}
	}

	public static void main(String[] args) {
		int[] nums1 = new int[] { 1, 2, 3, 0, 0, 0 };
		int m = 3;
		int[] nums2 = new int[] { 2, 5, 6 };
		int n = 3;
		mergeOne(nums1, m, nums2, n);
	}

}
