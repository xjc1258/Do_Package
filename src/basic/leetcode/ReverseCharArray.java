package leetcode;

/*
 * @author xjc
 * @date 2021-05-25
 * @desc  反转字符数组，复杂度O(1)
 */
public class ReverseCharArray {
	public static void main(String[] args) {
		char[] c = new char[] { 'a', 'b', 'c', 'd', 'e', 'f' };

		// 利用双指针的方法
		int n = c.length;
		for (int left = 0, right = n - 1; left < right; ++left, --right) {
			// 临时变量的交换法则
			char tmp = c[left];
			c[left] = c[right];
			c[right] = tmp;
		}

		for (int i = 0; i < c.length; i++) {
			System.out.println(c[i]);
		}

	}

	// 时间复杂度：O(N)其中 NN 为字符数组的长度,一共执行了 N/2N/2 次的交换
	// 空间复杂度：O(1)只使用了常数空间来存放若干变量

}
