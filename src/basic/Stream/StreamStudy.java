package basic.Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

/*
 * @author xjc
 * @date 2021-06-21
 * @desc java1.8新特性
 */
public class StreamStudy {

	@Test
	public void listDistinctByStreamDistinct() {
		List<String> l = new ArrayList<String>();
		l.add("A");
		l.add("B");
		l.add("B");
		l.add("A");
		l.add("B");
		l.add("B");
		l.add("A");
		l.add("C");
		List<String> collect = l.stream().distinct().collect(Collectors.toList());
		for (String s : collect) {
			System.out.println(s);
		}
	}

}
