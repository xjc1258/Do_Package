package JVM;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflect {
	public static void foo() {
		System.out.println("foo...");
	}

	public static void main(String[] args)
			throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		Method foo = Reflect.class.getMethod("foo");
		for (int i = 0; i <= 16; i++) {
			foo.invoke(null);
		}
	}
}
