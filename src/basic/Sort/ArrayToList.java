package basic.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ArrayToList {
	/*
	 * list和array的之间的转换
	 */
	@Test
	public void test1(){
		ArrayList<String> list = new ArrayList<>();
		list.add("q");
		list.add("w");
		list.add("qe");
		list.add("qf");
		list.toArray();
		String[] array = new String[]{"sssss","ddddd"}; 
		List<String> asList = Arrays.asList(array);
		System.out.println(list+"====="+asList);
	}
}
