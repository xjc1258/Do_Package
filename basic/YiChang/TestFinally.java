package YiChang;

//测试finally中出现return
public class TestFinally {
	public static void main(String[] args) {
		int test = test();
		System.out.println(test);
	}

	public static int test() {
		try {
			return 10;
		} catch (Exception e) {
			e.getMessage();
		} finally {
			return 20;
			// 危险操作，当在finally中出现return的话，就会将异常吞掉
		}
	}

	public static int test2() {
		try {
			int i = 1 / 0;
			return 10;
		} finally {
			return 20;
			// 危险操作，当在finally中出现return的话，就会将异常吞掉
		}
	}
}
