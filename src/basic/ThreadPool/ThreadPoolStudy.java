package basic.ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 * @author xjc
 * @date 2021-06-17
 * @desc 线程池的学习
 */
public class ThreadPoolStudy {
	/*
	 * 多线程异步，可以最大化的发挥多核的作用；大量的线程会造成内存资源的浪费并出现outofmemory,回收线程也会造成内存紧张
	 * 最大的作用就是让线程可以复用
	 */
	
	/*
	构造方法:
	public ThreadPoolExecutor(int corePoolSize, //核心线程数量,常驻线程的最大数量
		                      int maximumPoolSize,//最大线程数，包括核心线程和非核心线程
		                      long keepAliveTime, //最大空闲时间
		                      TimeUnit unit,         //时间单位
		                      BlockingQueue<Runnable> workQueue,   //任务队列
		                      ThreadFactory threadFactory,    //线程工厂
		                      RejectedExecutionHandler handler  //饱和处理机制
	) {
	}
	*/
	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
				new ArrayBlockingQueue<Runnable>(5));

		for (int i = 0; i < 15; i++) {
			MyTask myTask = new MyTask(i);
			executor.execute(myTask);
			System.out.println("线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：" + executor.getQueue().size()
					+ "，已执行玩别的任务数目：" + executor.getCompletedTaskCount());
		}
		executor.shutdown();
	}
	
	
	
	

	
	
}
