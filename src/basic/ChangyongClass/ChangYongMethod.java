package basic.ChangyongClass;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import com.mysql.fabric.xmlrpc.base.Array;

import basic.Object.Dog;
import net.sf.ehcache.hibernate.management.impl.BeanUtils;

/*
 *@author xjc
 *@date 2021-10-20
 *@desc java必须学的工具库
 */
public class ChangYongMethod {
	// list拼接成以逗号分隔的字符串
	public void Method1() {
		List<String> list = Arrays.asList("a", "b", "c");
		// 第一种方法，可以用stream流
		String join = list.stream().collect(Collectors.joining(","));
		System.out.println(join); // 输出 a,b,c
		// 第二种方法，其实String也有join方法可以实现这个功能
		String join1 = String.join(",", list);
		System.out.println(join1); // 输出 a,b,c
	}

	// 比较两个字符串是否相等，忽略大小写
	public void Method2() {
		String a = "qwe";
		String b = "QWE";
		if (a.equalsIgnoreCase(b)) {
			System.out.println("相等");
		}
	}

	// 比较两个对象是否相等
	public void Method3() {
		// 这个就是比较两个对象是否相等
		// Objects.equals(a, b);
		// (a == b) || (a != null && a.equals(b));其实内部是实现这个
	}

	// 取两个list的交集
	public void Method4() {
		List<String> l = new ArrayList<String>();
		l.add("a");
		l.add("b");
		l.add("c");
		List<String> s = new ArrayList<>();
		s.add("a");
		s.add("c");
		s.add("d");
		l.retainAll(s);// 求交集
		System.out.println(l);

	}

	// 首字母转换成大写
	public void Method5() {
		String a = "abcdef";
		String capitalize = StringUtils.capitalize(a);
		System.out.println(capitalize);
	}

	// 重复拼接字符串
	@Test
	public void Method6() {
		String repeat = StringUtils.repeat("ad", 3);
		System.out.println(repeat);
	}

	// 格式化日期
	@Test
	public void Method7() {
		// Date转String类型
		String format = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
		System.out.println(format);

		// String 转date类型
		try {
			DateUtils.parseDate("2021-05-01 01:01:01", "yyyy-MM-dd HH:mm:ss");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// 计算一个小时后的日期
		Date addDays = DateUtils.addDays(new Date(), 1);
		System.out.println(addDays);
	}

	//
	@Test
	public void Method8() {
		List<String> listA = new ArrayList<String>();
		listA.add("a");
		listA.add("b");
		listA.add("c");
		List<String> listB = new ArrayList<>();
		listB.add("a");
		listB.add("c");
		listB.add("d");
		// 两个集合取交集
		Collection<String> collection = CollectionUtils.retainAll(listA, listB);
		// 两个集合取并集
		Collection<String> collection1 = CollectionUtils.union(listA, listB);
		// 两个集合取差集
		Collection<String> collection2 = CollectionUtils.subtract(listA, listB);
	}

	// map和对象的互转
	public void Method9() {
		Dog dog = new Dog();
		// 对象转map
		// Map<String, String> map = BeanUtils.describe(dog);
		// System.out.println(map); // 输出 {"id":"1","name":"yideng"}
		// map转对象
		// User newUser = new User();
		// BeanUtils.populate(newUser, map);
		// System.out.println(newUser); // 输出 {"id":1,"name":"yideng"}
	}
	//
	//

}
