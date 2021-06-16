package Queue;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
 * @author xjc
 * @date 2021-05-28
 * @desc 手写阻塞队列(其实jdk1.8是封装阻塞队列  BlockingQueue)
 */
public class BlockingQueueXJC {
	private Object[] tab; // 队列容器
	private int takeIndex;// 出对下标
	private int putIndex;// 入队下标
	private int size;// 元素数量
	private ReentrantLock reentrantLock = new ReentrantLock();
	private Condition notEmpty;// 读条件
	private Condition notFull;// 写条件

	public BlockingQueueXJC(int tabCount) {
		if (tabCount <= 0) {
			new NullPointerException();
		}
		tab = new Object[tabCount];
		notEmpty = reentrantLock.newCondition();
		notFull = reentrantLock.newCondition();
	}

	public boolean offer(Object obj) {
		if (obj == null) {
			throw new NullPointerException();
		}
		try {
			// 获取锁
			reentrantLock.lock();
			// 队列已满
			while (size == tab.length) {
				System.out.println("队列已满");
				// 阻塞
				notFull.await();
			}
			tab[putIndex] = obj;
			if (++putIndex == tab.length) {
				putIndex = 0;
			}
			size++;
			// 唤醒读线程
			notEmpty.signal();
			return true;
		} catch (Exception e) {
			// 唤醒读线程
			notEmpty.signal();
		} finally {
			reentrantLock.unlock();
		}
		return false;
	}

	public Object take() {
		try {
			reentrantLock.lock();
			while (size == 0) {
				System.out.println("队列空了");
				// 堵塞
				notEmpty.await();
			}
			Object obj = tab[takeIndex];
			// 如果到了最后一个，则从头开始
			if (++takeIndex == tab.length) {
				takeIndex = 0;
			}
			size--;
			// 唤醒写线程
			notFull.signal();
			return obj;
		} catch (Exception e) {
			// 唤醒写线程
			notFull.signal();
		} finally {
			reentrantLock.unlock();
		}
		return null;
	}

	public static void main(String[] args) {
		Random random = new Random(100);
		BlockingQueueXJC blockingQueueXJC = new BlockingQueueXJC(5);
		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				blockingQueueXJC.offer(i);
				System.out.println("生产这生产了：" + i);
			}
		});
		Thread thread2 = new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Object take = blockingQueueXJC.take();
				System.out.println("消费者消费了" + take);
			}
		});
		thread1.start();
		thread2.start();
	}

}
