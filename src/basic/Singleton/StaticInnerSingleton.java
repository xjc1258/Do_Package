package basic.Singleton;

public class StaticInnerSingleton {
	//静态内部类有初始化锁
	private static class InnerClass {
		private static StaticInnerSingleton staticInnerSingleton = new StaticInnerSingleton();

	}
	public static StaticInnerSingleton getIntance() {
		return InnerClass.staticInnerSingleton;
	}
	//私有的构造器是必须要有的，要不外面就可以new出来了
	private StaticInnerSingleton(){
	}
}
