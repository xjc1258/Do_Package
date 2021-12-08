package basic.Stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

	// 流生成的方式：
	public void WayGeneStream() {
		// a.通过集合生成
		List<Integer> asList = Arrays.asList(1, 2, 3, 4, 5);
		Stream<Integer> stream = asList.stream();
		// b.通过数组生成
		int[] array = new int[] { 1, 2, 3, 4, 5, 6 };
		IntStream stream2 = Arrays.stream(array);// 生成的流是数值流,IntStream,可以避免计算过程中拆箱装箱
		// Stream api提供了mapToInt,mapToDouble,mapToLong,可以将对象流转换成对应的数值流，boxed提供了数值流转换成对象流
		// c.通过值生成
		Stream<Integer> of = Stream.of(1, 2, 3, 4, 5, 6);
		Stream<Object> empty = Stream.empty(); // 生成一个空流
		
		
		// d.通过文件生成
		try {
			Stream<String> lines = Files.lines(Paths.get("data.txt"),Charset.defaultCharset());
			//得到的每个流是给定文件中的一行
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void ShiYong(){
		//filter 过滤某条件元素
		List<Integer> asList = Arrays.asList(1,2,3,4,5,6);
		Stream<Integer> filter = asList.stream().filter(i->i<3);
		//distinct 去除重复元素
		Stream<Integer> distinct = asList.stream().distinct();
		
		//limit返回指定流个数
		Stream<Integer> limit = asList.stream().limit(3);//limit的参数值必须>=0，否则将会抛出异常
		//skip跳过流中的元素
		Stream<Integer> skip = asList.stream().skip(3);//skip的参数值必须>=0，否则将会抛出异常
		//map流映射
		
		
		
		
		
	}

}
