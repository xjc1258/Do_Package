package basic.Volatile;

/*
 * @author xjc
 * @date 2021-06-30
 * @desc 双重锁校验的单例 
 */
public class Singleton {

	private volatile static Singleton singleton;

	// 私有空参构造
	private Singleton() {
		String a = "aa";
		System.out.println(a);
	}

	public static Singleton getSingleton() {
		if (singleton == null) {
			synchronized (Singleton.class) {
				if (singleton == null) {
					singleton = new Singleton();//当new的时候它会调用空参构造
					System.out.println("双重锁校验的单例新建了");
				}
			}
		}
		return singleton;
	}

	/*
	 * 这是公有空参构造，只有这样的才能new，私有空参构造是不能new的 Singleton() { }
	 */
}
