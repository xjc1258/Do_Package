package basic.IntanceOf;

import java.util.ArrayList;
import java.util.List;

import basic.String.Person;

public class InstanceOf {

	public static void main(String[] args) {

		List<Person> list = new ArrayList<Person>();
		// String>>();
		// 这个的意思
		/*
		 * if (list == null || (null != list && list.size() == 0)) {
		 * System.out.println("111111"); }
		 */
		Person p = new Person();

		p.setBanji("@@");
		p.setChushengdi("22");
		p.setCun("3");
		p.setName("4");
		p.setXuexiao("5");

		Person p2 = new Person();

		p2.setBanji("4");
		p2.setChushengdi("4");
		p2.setCun("3");
		p2.setName("4");
		p2.setXuexiao("4");

		Person p3 = new Person();

		p3.setBanji("5");
		p3.setChushengdi("5");
		p3.setCun("5");
		p3.setName("5");
		p3.setXuexiao("5");

		Person[] arrayp = new Person[] { p, p2, p3 };
		for (Person a : arrayp) {
			if ("3" == a.getCun()) {
				continue;
			}
			list.add(a);
		}
		System.out.println(list.size());
		// ||是且的意思
		/*
		 * if (arrayp.length == 0 || arrayp == null) {
		 * 
		 * }
		 */
		int[][] arr = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10 } };
		System.out.println(arr.toString());
	}
}
