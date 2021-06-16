package JVM;

public class Load1 {
	public static void main(String[] args) throws Exception {
		LoadHa classload = new LoadHa();
		Class<?> c1 = classload.loadClass("MapImpl1");
		Class<?> c2 = classload.loadClass("MapImpl2");
		System.out.println(c1 == c2);

		LoadHa classload2 = new LoadHa();
		Class<?> c3 = classload2.loadClass("MapImpl1");
		System.out.println(c1 == c3);

		c1.newInstance();//利用反射
	}
}
