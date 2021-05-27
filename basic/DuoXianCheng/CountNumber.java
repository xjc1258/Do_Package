package DuoXianCheng;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class CountNumber {

	private static int threadTotal = 200;
	private static int clientTotal = 5000;

	private static long count = 0;

	public static void main(String[] args) {
		ExecutorService exe = Executors.newCachedThreadPool();
		final Semaphore semaphore = new Semaphore(threadTotal);
		for (int index = 0; index < clientTotal; index++) {
			exe.execute(() -> {

				try {
					semaphore.acquire();
					add();
					semaphore.release();
				} catch (Exception e) {
					System.out.println(e);
					e.printStackTrace();
				}
			});
		}
		exe.shutdown();
	}

	public static void add() {
		count++;
	}

}
