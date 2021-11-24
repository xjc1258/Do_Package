package basic.leetcode;

/*
 * @author xjc
 * @date 2021-05-25
 * @desc 字符串去掉重复的字母
 */
public class StringForChong {
	// 需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）
	public static void main(String[] args) {
		String xjc = "bacabc";
	}
	/*
	 * 我们使用单调栈
	 */
	public String removeDuplicateLetters(String s) {
		boolean[] vis = new boolean[26];
		int[] num = new int[26];
		for (int i = 0; i < s.length(); i++) {
			num[s.charAt(i) - 'a']++;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (!vis[ch - 'a']) {
				while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
					if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
						vis[sb.charAt(sb.length() - 1) - 'a'] = false;
						sb.deleteCharAt(sb.length() - 1);
					} else {
						break;
					}
				}
				vis[ch - 'a'] = true;
				sb.append(ch);
			}
			num[ch - 'a'] -= 1;
		}
		return sb.toString();
	}

	// 时间复杂度：O(N)，其中 NN 为字符串长度。代码中虽然有双重循环，但是每个字符至多只会入栈、出栈各一次。

	// 空间复杂度：O(∣Σ∣)，其中 |Σ| 为字符集合，本题中字符均为小写字母，所以 |Σ|=26。由于栈中的字符不能重复，因此栈中最多只能有
	// ∣Σ∣ 个字符，另外需要维护两个数组，分别记录每个字符是否出现在栈中以及每个字符的剩余数量

}
