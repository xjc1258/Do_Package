package basic.Stream;

import java.io.FileReader;
import java.io.IOException;

/*
 * @author xjc
 * @date 2021-07-20
 * @desc 流的一些使用
 */
public class FileInputStream {

	/*
	 * 如果是操作二进制文件，那么最后使用字节流，如果操作的是文笔比文件，那么使用字符流 尽可能的使用处理流，使我们的代码更加灵活，复用性 更好
	 */
	public void StudyFileReader() throws IOException {
		FileReader fis = null;
		try {
			// 创建字节输入流
			fis = new FileReader("E:\\learnproject\\Iotest\\lib\\src\\main\\java\\com\\Test.txt");
			// 创建一个长度为1024的竹筒
			char[] b = new char[1024];
			// 用于保存的实际字节数
			int hasRead = 0;
			// 使用循环来重复取水的过程
			while ((hasRead = fis.read(b)) > 0) {
				// 取出竹筒中的水滴（字节），将字节数组转换成字符串进行输出
				System.out.print(new String(b, 0, hasRead));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			fis.close();
		}
	}
	// NIO采用了内存映射对象的方式来处理输入和输出，NIO将文件或者文件的一块区域映射到内存中，这样就可以像访问内存一样访问文件了
}
