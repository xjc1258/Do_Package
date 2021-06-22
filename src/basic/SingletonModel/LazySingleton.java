package basic.SingletonModel;

public class LazySingleton {
	// 懒汉式---注重的是延迟加载，线程不安全的
	// 其实在多线程的内部会创建多个实例，只不过最后重新赋值了
	private static LazySingleton lazySingleton = null;

	private LazySingleton() {

	}
	// 如何解决懒汉式的线程不安全
	// 静态方法前加synchronized  同步锁比较消耗内存资源，静态锁，锁的是class,范围较大，对性能有影响
	public synchronized static LazySingleton getInstance() {
		if (lazySingleton == null) {
			lazySingleton = new LazySingleton();
		}
		return lazySingleton;
	}
}
