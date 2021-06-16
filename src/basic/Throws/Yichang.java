package Throws;

public class Yichang {

	/*
	 * 
	 * throws: 跟在方法声明后面，后面跟的是异常类名 throw: 用在方法体内，后面跟的是异常类对象名
	 * 
	 */
	public static void method() throws ArithmeticException {// 跟在方法声明后面，后面跟的是异常类名
		int a = 10;
		int b = 0;
		if (b == 0) {
			throw new ArithmeticException();// 用在方法体内，后面跟的是异常类对象名
		} else {
			System.out.println(a / b);
		}
	}
}
