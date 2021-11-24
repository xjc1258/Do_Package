package basic.String;

import org.junit.Test;

/*
 * @author xjc
 * @date 2021-09-17
 * @desc toString(),String.valueOf(),(String)不推荐使用
 */
public class QiangZhuan {
	// 基本类型是没有toString()的方法的
	// 基本类型转String使用String.valueOf()
	// 基本类型好像是无法强制转换的

	public void test() {
		int a = 0;
		// String b = (String) a;//是无法转换的
		System.out.println(a);
	}

	/*
	 * （String）是标准的类型转换，将Object类型转为String类型，使用(String)强转时，最好使用instanceof做一个类型检查，
	 * 以判断是否可以进行强转，
	 * 否则容易抛出ClassCastException异常。需要注意的是编写的时候，编译器并不会提示有语法错误，所以这个方法要谨慎的使用
	 * 
	 */
	@Test
	public void test2() {
		// 错误的代码示范
		Object a = 0;
		String b = (String) a;
		System.out.println(b);
	}

	@Test
	public void test3() {
		// 错误的代码示范
		Object a = 0;
		/*
		 * if(a instanceOf(String)){
		 * 
		 * }else{
		 * 
		 * }
		 */
		String b = (String) a;
		System.out.println(b);
	}

}
