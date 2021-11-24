package basic.String;

/*
 * @author xjc
 * @date 2021-05-18
 * @desc 非常经典的一个问题
 */
public class JingDianForString {
	public static void main(String[] args) {
		String st1 = new String("abc");// 指向的是堆的内存地址
		String st2 = "abc";// 常量池中
		System.out.println(st1 == st2);// 对于引用类型比较的是内存地址
		System.out.println(st1.equals(st2));

		/*
		 * 第二个经典的问题
		 */
		String st3 = "a" + "b" + "c";// 字符串常量的拼接后，会在常量池中创建abc的对象
		String st4 = "abc";// 发现已经有了之后，就不在创建，直接指向地址
		System.out.println(st3 == st4);
		System.out.println(st3.equals(st4));

		/*
		 * 第三个问题
		 */
		String st5 = "ab";
		String st6 = "abc";
		String st7 = st5 + "c";//使用了StringBuffer或者StringBuilder的拼接对象
		System.out.println(st6 == st7);//所以导致了内存地址的不一致
		System.out.println(st6.equals(st7));
	}

}
