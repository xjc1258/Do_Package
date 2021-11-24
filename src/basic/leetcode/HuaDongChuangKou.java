package basic.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/*
 * @author xjc
 * @date 2021-05-25
 * @desc 滑动窗口
 */
public class HuaDongChuangKou {

	public static int[] maxSlidingWindow(int[] nums, int k) {
		
		if (nums.length == 0 || k == 0)
			return new int[0];
		Deque<Integer> deque = new LinkedList<>();
		int[] res = new int[nums.length - k + 1];
		/*
		 * i是双队列的左指针，j是双队列的右指针
		 */
		for (int j = 0, i = 1 - k; j < nums.length; i++, j++) {
			// 删除 deque 中对应的 nums[i-1]
			if (i > 0 && deque.peekFirst() == nums[i - 1])
				deque.removeFirst();
			// 保持 deque 递减
			while (!deque.isEmpty() && deque.peekLast() < nums[j])
				deque.removeLast();
			deque.addLast(nums[j]);
			// 记录窗口最大值
			if (i >= 0)
				res[i] = deque.peekFirst();
		}
		return res;
	}

	/*
	 * nums = [1,3,-1,-3,5,3,6,7], 和 k = 3 [3,3,5,5,6,7]
	 */
	public static void main(String[] args) {
		int[] nums = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 2;
		int[] maxSlidingWindow = maxSlidingWindow(nums, k);
		// List<int[]> asList = Arrays.asList(maxSlidingWindow);
		for (int i = 0; i < maxSlidingWindow.length; i++) {
			System.out.println(maxSlidingWindow[i]);
		}
	}

	/*
	 * deque双端队列
	 * 
	 * deque容器为一个给定类型的元素进行线性处理，像向量一样，它能够快速地随机访问任一个元素，
	 * 并且能够高效地插入和删除容器的尾部元素。但它又与vector不同，deque支持高效插入和删除容器的头部元素， 因此也叫做双端队列
	 *
	 */

}
