package basic.leetcode;

/*
 * @author xjc
 * @date 2021-06-02
 * @desc 字符串有英文字母和空格组成，求最后一个英文单词的长度
 */
public class StringWordLastLength {
	public static void main(String[] args) {
		String xjc = "Hello world xjc";

		char charAt = xjc.charAt(xjc.length() - 1);
		if (charAt == ' ') {
			System.out.println(0);

		} else {
			String[] split = xjc.split(" ");
			System.out.println(split[split.length - 1].length());
		}

	}

	/*
	 * 官方最优解
	 */
	public int lengthOfLastWord(String s) {
		int end = s.length() - 1;
		while (end >= 0 && s.charAt(end) == ' ')
			end--;
		if (end < 0)
			return 0;
		int start = end;
		while (start >= 0 && s.charAt(start) != ' ')
			start--;
		return end - start;
	}

}
