package basic.leetcode;

/*
 * @author xjc
 * @date 2021-06-18
 * @desc 去掉数组中的单个数字,也就是找到那个形单影只的那个
 */
public class ArrayQuDanNumber {
	public static void main(String[] args) {
		int[] xjc = new int[] { 1, 2, 2, 3, 3, 4, 4, 5, 5 };

		// 用到异或运算
		// 相同的值异或值是1，不同的值异或值是0
		int result = xjc[0];
		for (int i = 1; i < xjc.length; i++) {
			result ^= xjc[i];
		}
		System.out.println(result);
	}

}
