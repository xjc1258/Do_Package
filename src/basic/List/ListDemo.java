package basic.List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {

	static final int N = 50000;

	static long timeList(List list) {
		long start = System.currentTimeMillis();
		Object o = new Object();
		for (int i = 0; i < N; i++) {
			list.add(0, o);
		}
		return System.currentTimeMillis() - start;
	}

	/*
	 * 增加元素 到list中的性能
	 */
	public static void main(String[] args) {
		System.out.println("ArrayList耗时：" + timeList(new ArrayList()));
		System.out.println("LinkedList耗时：" + timeList(new LinkedList()));
	}

}
