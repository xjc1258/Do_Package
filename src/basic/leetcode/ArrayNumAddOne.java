package basic.leetcode;
/*@author xjc
 * @date 2021-05-31
 * @desc 数组组成的数字加1
 */

public class ArrayNumAddOne {

	public static void main(String[] args) {
		int[] xjc = new int[] { 1, 2, 3, 4, 5, 6 };
		

	}

	public int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			digits[i]++;
			digits[i] = digits[i] % 10;
			if (digits[i] != 0)
				return digits;
		}
		digits = new int[digits.length + 1];
		digits[0] = 1;
		return digits;
	}

}
