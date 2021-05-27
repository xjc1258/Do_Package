package learn;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Print {

	    public static void main(String[] args) {
	        File file = new File("h://ccc.txt");
	        System.out.println(file.exists());//输出为false，因为本地没有ccc.txt
	        PrintWriter pw = null;
	        try {
	            pw = new PrintWriter(file);//先创建ccc.txt（若存在，则不会创建）
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	        pw.print("Hello World");
	        for(int i= 0;i<1000;i++){
	            pw.print(i+"\r\n");
	        }
	        pw.close();
	    }

		//	（1）print(String str)：向文件写入一个字符串。
		//
		//	（2）print(char[] ch)：向文件写入一个字符数组。
		//
		//	（3）print(char c)：向文件写入一个字符。
		//
		//	（4）print(int i)：向文件写入一个int型值。
		//
		//	（5）print(long l)：向文件写入一个long型值。
		//
		//	（6）print(float f)：向文件写入一个float型值。
		//
		//	（7）print(double d)：向文件写入一个double型值。
		//
		//	（8）print(boolean b)：向文件写入一个boolean型值

}
