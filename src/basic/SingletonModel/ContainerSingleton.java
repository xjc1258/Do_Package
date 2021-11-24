package basic.SingletonModel;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

//hashmap本来就不是线程安全的
//这种模式是线程不安全的，使用hashmap是一种平衡
public class ContainerSingleton {
	private static Map<String, Object> singlemap = new HashMap<String, Object>();

	// 确保唯一
	public static void putInstance(String key, Object instance) {
		if (StringUtils.isNotBlank(key) && instance != null) {
			if (!singlemap.containsKey(key)) {
				singlemap.put(key, instance);
			}
		}
	}

	public static Object getInstance(String key) {
		return singlemap.get(key);
	}
	private ContainerSingleton() {

	}
}
