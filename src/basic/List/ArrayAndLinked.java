package basic.List;

import java.util.ArrayList;
import java.util.LinkedList;

/*
 * @author xjc
 * @date 2021-08-03
 * @desc ArrayList和linkedList的区别
 */
public class ArrayAndLinked {
	public static void main(String[] args) {

		ArrayList<String> arraylist = new ArrayList<>();
		// ArrayList是基于动态数组的，get方法访问数据的速度要快
		// 对于内存的要求比较高，需要连续的内存空间，会涉及到扩容，new一个新的数组，短的数组复制到新的数组
		LinkedList<String> linklist = new LinkedList<>();
		// linkedlist的get方法是按照顺序从列表的一端检查到另一端，速度会很慢
		//不需要连续的内存，插入快，维护了一个node类
		
		
		
	}

}