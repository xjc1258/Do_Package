package leetcode;
/*
 * @author xjc
 * @date 2021-05-29
 * @desc 两个字符串，A,B,找出A中出现B的第一位置，B是空的，返回0，不存在返回-1；
 */

public class strStr {
	public static void main(String[] args) {
		String A = "hello";
		String B = "";
		System.out.println(strStr(A, B));
		//学会了字符串的charAt方法
		System.out.println(A.charAt(0));

	}

	public static int strStr(String haystack, String needle) {
		if(needle.equals("")) {
			return 0;
		}
		int n = haystack.length(), m = needle.length();
		for (int i = 0; i + m <= n; i++) {
			boolean flag = true;
			for (int j = 0; j < m; j++) {
				if (haystack.charAt(i + j) != needle.charAt(j)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				return i;
			}
		}
		return -1;
	}
	
	
}
