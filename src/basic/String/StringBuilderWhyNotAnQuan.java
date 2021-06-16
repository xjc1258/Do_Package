package String;

public class StringBuilderWhyNotAnQuan {
	/*
	 * 很简单，看实现的代码，里面的append均没有加锁
	 */
	public static void main(String[] args) throws InterruptedException {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < 1000; j++) {
						stringBuilder.append("a");
					}
				}
			}).start();
		}
		Thread.sleep(100);
		System.out.println(stringBuilder.length());
	}
}