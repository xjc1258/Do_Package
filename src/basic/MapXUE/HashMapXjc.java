package basic.MapXUE;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class HashMapXjc {
	
	@Test
	public void test1(){
		/*键值对----允许null值和null键,key不允许重复，无序，线程不安全
		 * hashmap的扩容操作是非常耗时的，最好给一个初始化默认值，避免进行多次的扩容
		 * 多线程的环境最好使用concurrenthashmap
		 * hashtable------synchronized关键字来确保线程同步，所以hashmap的性能好一些，Hashtable则不允许null作为key
		 * 
		 * HashMap由数组和链表和红黑树来实现对数据的存储
		 * 1.
		 */
		Map<String, String> map = new HashMap<String,String>();
	}
}
