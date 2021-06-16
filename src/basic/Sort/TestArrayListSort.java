package basic.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import org.junit.Test;

public class TestArrayListSort {
	private HashSet<Integer> hashSet;

	// 对string的排序
	@Test
	public void test17() throws Exception {
		List<String> stringList = new ArrayList<>();
		stringList.add("haha");
		stringList.add("123");
		stringList.add("wq");
		stringList.add("d");
		stringList.add("rt");
		stringList.add("uuk");
		System.out.println("排序前：" + stringList);
		Collections.sort(stringList, new Comparator<String>() {
			@Override
			public int compare(String lhs, String rhs) {
				System.out.println("排序字符串：" + lhs + "," + rhs);

				int i = lhs.compareTo(rhs);
				System.out.println("排序结果" + i);
				if (i > 0) {
					return 1;
				} else {
					return -1;
				}
			}
		});
		System.out.println("排序后：" + stringList);
	}

	// 对integer的排序
	@Test
	public void test18() throws Exception {
		List<Integer> stringList = new ArrayList<>();
		stringList.add(123);
		stringList.add(32);
		stringList.add(0);
		stringList.add(-4);
		stringList.add(5);
		stringList.add(123131);
		System.out.println("排序前：" + stringList);
		Collections.sort(stringList, new Comparator<Integer>() {
			@Override
			public int compare(Integer lhs, Integer rhs) {
				if (lhs > rhs) {
					return 1;
				} else {
					return -1;
				}
			}
		});
		System.out.println("排序后：" + stringList);
	}

	// 对ArrayList 的去重
	@Test
	public void test20() throws Exception {
		List<Integer> list20 = new ArrayList<>();
		list20.add(1);
		list20.add(2);
		list20.add(3);
		list20.add(4);
		list20.add(4);
		list20.add(4);
		list20.add(5);
		list20.add(6);
		Collections.sort(list20, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 > o2) {
					return -1;
				} else {
					return 1;
				}
			}
		});
		System.out.println(list20);
		/*
		 * ArrayList<Integer> newlist = new ArrayList<>(); // 去重，有两种方法
		 * Iterator<Integer> iterator = list20.iterator(); while
		 * (iterator.hasNext()) { Integer next = iterator.next(); if
		 * (!newlist.contains(next)) { newlist.add(next); } }
		 * System.out.println(newlist);//这种方法不能去重自定义的对象，要想需要实现，
		 * 需要在自定义的对象中实现equals方法
		 */
		hashSet = new HashSet<>(list20);
		System.out.println("xjc-------" + hashSet);

	}

	@Test
	public void test21() {
		/*
		 * 我们知道HashSet实现了Set接口，不允许出现重复元素。可以基于这个想法，把List集合所有元素存入HashSet对象，
		 * 接着把List集合元素全部清空，最后把HashSet对象元素全部添加至List集合中，这样就可以保证不出现重复元素。
		 * 而HashSet有一个构造函数，
		 * 在初始化时可以直接添加元素。其中，HashSet不能保证顺序不变，所以此方式不能保证List集合原来的顺序不变
		 */
		ArrayList<String> a = new ArrayList<>();
		a.add("d");
		a.add("e");
		a.add("f");
		a.add("a");
		a.add("b");
		a.add("c");
		a.add("a");
		a.add("b");
		a.add("c");
		System.out.println(a);
		HashSet<String> hashSet2 = new HashSet<>(a);
		a.clear();
		a.addAll(hashSet2);
		System.out.println(a);
	}

	@Test
	public void test22() {
		/*
		 * TreeSet集合也是实现Set接口，是一个有序的，并且无重复元素集合。同理，我们可以根据上面方式二
		 * 的思想进行去重。其中，去重后的List集合可以保证和原来的顺序一致。
		 */
		ArrayList<String> a1 = new ArrayList<>();
		a1.add("d");
		a1.add("e");
		a1.add("f");
		a1.add("a");
		a1.add("b");
		a1.add("c");
		a1.add("a");
		a1.add("b");
		a1.add("c");
		TreeSet<String> treeSet = new TreeSet<String>(a1);
		a1.clear();
		a1.addAll(treeSet);
		System.out.println("kkkk+===============" + treeSet);

	}

	@Test
	public void test24() {
		ArrayList<String> xjc1 = new ArrayList<>();
		xjc1.add("q");
		xjc1.add("q");
		xjc1.add("e");
		xjc1.add("e");
		xjc1.add("t");
		xjc1.add("y");
		xjc1.add("y");
		xjc1.add("u");
		// 错误的写法

		// 一
		// for(int i =0 ;i < xjc1.size();i++){
		// String string = xjc1.get(i);
		// if(string.equals("e")){
		// xjc1.remove(i);
		// }
		// //因为数组倒序遍历时即使发生元素删除也不影响后序元素遍历。
		// }

		// 二
		for (String s : xjc1) {
			if (s.equals("e")) {
				xjc1.remove(s);
			}
		}
		/*
		 * java.util.ConcurrentModificationException
		 */
		System.out.println("eeeeee=--" + xjc1);

		// 三
		/*
		 * 使用迭代器遍历删除时，能够避免方法二中出现的问题。这是因为：在ArrayList中，
		 * modCount是指集合的修改次数，当进行add或者delete时，modCount会+1；
		 * expectedModCount是指集合的迭代器的版本号，初始值是modCount，但是当集合进行add或者delete操作时，
		 * modCount会+1，而expectedModCount不会改变，
		 * 所以方法二中会抛出异常。但是it.remove操作时，会同步expectedModCount的值，
		 * 把modCount的值赋予expectedModCount。所以不会抛出异常
		 */
		Iterator<String> iterator = xjc1.iterator();
		while (iterator.hasNext()) {
			String ww = iterator.next();
			if (ww.equals("e")) {
				iterator.remove();
			}
		}
	}
}
