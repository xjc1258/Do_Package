package Thread;

import java.util.concurrent.Semaphore;

public class ThreadTest {
	// 信号量的意思
	/*
	 * Semaphore是一个计数信号量。 从概念上将，Semaphore包含一组许可证
	 * 如果有需要的话，每个acquire()方法都会阻塞，直到获取一个可用的许可证
	 * 每个release()方法都会释放持有许可证的线程，并且归还Semaphore一个可用的许可证
	 * 然而，实际上并没有真实的许可证对象供线程使用，Semaphore只是对可用的数量进行管理维护
	 */
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
					System.out.println("c-------------");
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
	// 滴滴面试记录
	// ReentrantLock是可重入锁，它持有一个锁计数器，当已持有锁的线程再次获得该锁时，计数器值加1，每调用一次，lock.unlock()时所计数器值减一，查到所计数器值为0，此时线程释放锁
	// volitate关键字的使用

	// 数据库中的索引问题

	public void test5() {

		/*
		 * 常见的用法
		 */
		// new Semaphore(permits)：初始化许可证数量的构造函数
		Semaphore semaphore = new Semaphore(5);

		// new Semaphore(permits,fair):初始化许可证数量和是否公平模式的构造函数
		semaphore = new Semaphore(5, true);

		// isFair()：是否公平模式FIFO
		System.out.println("是否公平FIFO：" + semaphore.isFair());

		// availablePermits():获取当前可用的许可证数量
		System.out.println("获取当前可用的许可证数量：开始---" + semaphore.availablePermits());

		// acquire():获取1个许可证
		// ---此线程会一直阻塞，直到获取这个许可证，或者被中断(抛出InterruptedException异常)。
		try {
			semaphore.acquire();
		} catch (InterruptedException e3) {
			e3.printStackTrace();
		}
		System.out.println("获取当前可用的许可证数量：acquire 1 个---" + semaphore.availablePermits());

		// release()：释放1个许可证
		semaphore.release();
		System.out.println("获取当前可用的许可证数量：release 1 个---" + semaphore.availablePermits());

		// acquire(permits):获取n个许可证
		// ---此线程会一直阻塞，直到获取全部n个许可证,或者被中断(抛出InterruptedException异常)。
		try {
			semaphore.acquire(2);
		} catch (InterruptedException e2) {
			e2.printStackTrace();
		}
		System.out.println("获取当前可用的许可证数量：acquire 2 个---" + semaphore.availablePermits());

		// release(permits):释放n个许可证
		semaphore.release(2);
		System.out.println("获取当前可用的许可证数量：release 1 个---" + semaphore.availablePermits());

		// hasQueuedThreads():是否有正在等待许可证的线程
		System.out.println("是否有正在等待许可证的线程：" + semaphore.hasQueuedThreads());

		// getQueueLength():正在等待许可证的队列长度(线程数量)
		System.out.println("正在等待许可证的队列长度(线程数量)：" + semaphore.getQueueLength());

		try {
			Thread.sleep(10);
		} catch (InterruptedException e2) {
			e2.printStackTrace();
		}
		System.out.println();
		// 定义final的信号量
		Semaphore finalSemaphore = semaphore;
		new Thread(() -> {
			// drainPermits():获取剩余的所有的许可证
			int permits = finalSemaphore.drainPermits();
			System.out.println(Thread.currentThread().getName() + "获取了剩余的全部" + permits + "个许可证.");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// 释放所有的许可证
			finalSemaphore.release(permits);
			System.out.println(Thread.currentThread().getName() + "释放了" + permits + "个许可证.");
		}).start();

		try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		new Thread(() -> {
			try {
				// 有一个线程正在等待获取1个许可证
				finalSemaphore.acquire();
				System.out.println(Thread.currentThread().getName() + "获取了1个许可证.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// 释放1个许可证
			finalSemaphore.release();
			System.out.println(Thread.currentThread().getName() + "释放了1个许可证.");

		}).start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println();
		System.out.println("获取当前可用的许可证数量：drain 剩余的---" + finalSemaphore.availablePermits());
		System.out.println("是否有正在等待许可证的线程：" + finalSemaphore.hasQueuedThreads());
		System.out.println("正在等待许可证的队列长度(线程数量)：" + finalSemaphore.getQueueLength());
		System.out.println();

		try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		new Thread(() -> {
			try {
				// 有一个线程正在等待获取2个许可证
				finalSemaphore.acquire(2);
				System.out.println(Thread.currentThread().getName() + "获取了2个许可证.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// 释放两个许可证
			finalSemaphore.release(2);
			System.out.println(Thread.currentThread().getName() + "释放了2个许可证.");
		}).start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("获取当前可用的许可证数量：drain 剩余的---" + finalSemaphore.availablePermits());
		System.out.println("是否有正在等待许可证的线程：" + finalSemaphore.hasQueuedThreads());
		System.out.println("正在等待许可证的队列长度(线程数量)：" + finalSemaphore.getQueueLength());
		System.out.println();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("获取当前可用的许可证数量：---" + finalSemaphore.availablePermits());
		System.out.println("是否有正在等待许可证的线程：" + finalSemaphore.hasQueuedThreads());
		System.out.println("正在等待许可证的队列长度(线程数量)：" + finalSemaphore.getQueueLength());

	}

}
