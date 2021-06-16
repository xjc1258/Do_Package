package DengDengAndEquals;

public class DDAndEquals {

	public static void main(String[] args) {
		// 对象的equals的本质就是==
		Cat c1 = new Cat("王磊");
		int hashCode = c1.hashCode();
		System.out.println(hashCode);
		Cat c2 = new Cat("王磊");
		System.out.println(c2.hashCode());
		System.out.println(c1.equals(c2)); // false
		// String重写了object的equals的方法，把引用比较变成值比较
		String s1 = new String("老王");
		System.out.println(s1.hashCode());
		String s2 = new String("老王");
		System.out.println(s2.hashCode());
		System.out.println(s1.equals(s2));

		//Integer也重写了equals
		Integer i1 = new Integer(2);
		Integer i2 = new Integer(2);
		System.out.println(i1.equals(i2));
		
		
		/*
		 * 注意：hashcode是为了获得散列码，哈希码的作用是确定该对象在哈希表中的索引位置。
		 * 散列码----->散列表中的位置
		 * 散列表的本质是通过数组实现的，
		 * 两个不同的键值对，哈希码相等，这就是哈希冲突
		 */

	}

}
