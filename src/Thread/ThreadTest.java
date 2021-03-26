package Thread;

import java.util.concurrent.Semaphore;

public class ThreadTest {
	private static Semaphore a = new Semaphore(1);
	private static Semaphore b = new Semaphore(0);
	private static Semaphore c = new Semaphore(0);

	static class ThreadA extends Thread {
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				try {
					a.acquire();
					System.out.println("a");
					b.release();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}

	}

	static class ThreadB extends Thread {
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				try {
					b.acquire();
					System.out.println("b");
					c.release();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		}

	}

	static class ThreadC extends Thread {
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				try {
					c.acquire();
					System.out.println("c");
					a.release();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		new ThreadA().start();
		new ThreadB().start();
		new ThreadC().start();

	}
	//滴滴面试记录
	//ReentrantLock是可重入锁，它持有一个锁计数器，当已持有锁的线程再次获得该锁时，计数器值加1，每调用一次，lock.unlock()时所计数器值减一，查到所计数器值为0，此时线程释放锁
//	voli
	
	//	数据库中的索引问题

}
