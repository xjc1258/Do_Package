package leetcode;
/*
 * @author xjc
 * @date 2021-05-14
 * @desc 整数的反转---用的是取模运算
 */

public class ZhengShuReserse {
	public static int reserse(int x) {
		int res = 0;
		while (x != 0) {
			// 每次取末尾数字
			int tmp = x % 10;
			// 判断是否 大于 最大32位整数
			if (res > 214748364 || (res == 214748364 && tmp > 7)) {
				return 0;
			}
			// 判断是否 小于 最小32位整数
			if (res < -214748364 || (res == -214748364 && tmp < -8)) {
				return 0;
			}
			res = res * 10 + tmp;
			//去掉整数的最后一位
			x /= 10;
		}
		return res;
	}

	public static void main(String[] args) {
		int x = 26728676;
		System.out.println(reserse(x));

	}
}
