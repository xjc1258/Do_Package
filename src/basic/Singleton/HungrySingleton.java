package Singleton;

/*
 * 饿汉式的单例
 */
public class HungrySingleton {
	// 类加载的时候就初始化，没有了延迟加载的效果，类从一开始就没有用过，就会造成内存的浪费
	private final static HungrySingleton hungrySingleton;
	// 创建的过程最好放在静态代码块中
	static {
		hungrySingleton = new HungrySingleton();
	}

	private HungrySingleton() {

	}

	public HungrySingleton getInstance() {
		return hungrySingleton;
	}

}
