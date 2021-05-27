package String;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class StudyString {
	/*
	 * 主要是对字符串进行处理
	 */
	public static void writer() throws IOException {
		StringWriter sw = new StringWriter();// 运用了无参数的构造函数
		/* 方法介绍： */
		// write(int c)写入单个字符
		sw.write('a');

		// write(char[w] cbuf, int off, int len)写入字符数组的某一部分，偏移量和写入长度
		char[] c = { 'h', 'e', 'l', 'l', 'o' };
		sw.write(c, 1, 3);

		// write(String str)写入一个字符串
		sw.write("sunny day");

		// write(String str, int off, int len)写入字符串的某一部分，偏移量和写入长度
		String s = "hello world";
		sw.write(s, 0, 3);

		// append(char c)将指定字符添加到此 writer
		sw.append('g');

		// append(CharSequence csq)将指定的字符序列添加到此 writer。
		sw.append("apple");

		// append(CharSequence csq, int start, int end)将指定字符序列的子序列添加到此 writer。
		sw.append("tulun", 0, 3);

		/* 返回当前值：返回类型不同，一个是StringBuffer类型，一个是String类型 */
		// getBuffer()返回该字符串缓冲区本身。
		System.out.println(sw.getBuffer());
		// toString()以字符串的形式返回该缓冲区的当前值。
		System.out.printf(sw.toString());

		// flush() 刷新该流的缓冲。
		sw.flush();
		// close() 关闭 StringWriter 无效。
		sw.close();
	}

	public static void main(String[] args) throws IOException {
		writer();
	}

	@SuppressWarnings("unused")
	private String getStackTraceAsString() {
		try {

		} catch (Exception e) {
			// StringWriter将包含堆栈信息
			StringWriter stringWriter = new StringWriter();
			// 必须将StringWriter封装成PrintWriter对象，
			// 以满足printStackTrace的要求
			PrintWriter printWriter = new PrintWriter(stringWriter);
			// 获取堆栈信息
			e.printStackTrace(printWriter); 
			// 转换成String，并返回该String
			StringBuffer error = stringWriter.getBuffer();
			return error.toString();
		}
		return null;

	}
}
