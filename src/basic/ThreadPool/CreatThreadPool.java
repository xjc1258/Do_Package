package basic.ThreadPool;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

/*
 * @author xjc
 * @date 2021-06-17
 * @desc 
 */
public class CreatThreadPool {
	/*
	 * 在java中，我们不推荐直接使用ThreadPoolExecutor， 而是使用Executors类中提供的几个静态方法来创建线程池：
	 */

	// 方式一：
	public static void method_01() throws Exception {
		ExecutorService executor = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			final int index = i;
			Thread.sleep(1000);
			executor.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName() + "  " + index);
				}
			});
		}
	}
	// 不足：这种方式虽然可以根据业务场景自动的扩展线程数来处理我们的业务，但是最多需要多少个线程同时处理缺是我们无法控制的；

	// 优点：如果当第二个任务开始，第一个任务已经执行结束，那么第二个任务会复用第一个任务创建的线程，并不会重新创建新的线程，提高了线程的复用率；

	// 方式二：
	public static void method_02() throws InterruptedException {
		ExecutorService executor = Executors.newFixedThreadPool(1);
		for (int i = 0; i < 10; i++) {
			Thread.sleep(1000);
			final int index = i;
			executor.execute(() -> {
				try {
					Thread.sleep(2 * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "  " + index);
			});
		}
		executor.shutdown();
	}
	// 优点：两个结果综合说明，newFixedThreadPool的线程数是可以进行控制的，因此我们可以通过控制最大线程来使我们的服务器打到最大的使用率，同事又可以保证及时流量突然增大也不会占用服务器过多的资源

	// 方式三：
	// 该线程池支持定时，以及周期性的任务执行，我们可以延迟任务的执行时间，也可以设置一个周期性的时间让任务重复执行。 该线程池中有以下两种延迟的方法。

	public static void method_03_1() {
	    ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
	 
	    executor.scheduleWithFixedDelay(new Runnable() {
	        @Override
	        public void run() {
	            long start = new Date().getTime();
	            System.out.println("scheduleWithFixedDelay 开始执行时间:" +
	                    DateFormat.getTimeInstance().format(new Date()));
	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            long end = new Date().getTime();
	            System.out.println("scheduleWithFixedDelay执行花费时间=" + (end - start) / 1000 + "m");
	            System.out.println("scheduleWithFixedDelay执行完成时间："
	                    + DateFormat.getTimeInstance().format(new Date()));
	            System.out.println("======================================");
	        }
	    }, 1, 2, TimeUnit.SECONDS);
	}
	
	public static void method_03_2() {
	    ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
	 
	    executor.scheduleWithFixedDelay(new Runnable() {
	        @Override
	        public void run() {
	            long start = new Date().getTime();
	            System.out.println("scheduleWithFixedDelay 开始执行时间:" +
	                    DateFormat.getTimeInstance().format(new Date()));
	            try {
	                Thread.sleep(5000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            long end = new Date().getTime();
	            System.out.println("scheduleWithFixedDelay执行花费时间=" + (end - start) / 1000 + "m");
	            System.out.println("scheduleWithFixedDelay执行完成时间："
	                    + DateFormat.getTimeInstance().format(new Date()));
	            System.out.println("======================================");
	        }
	    }, 1, 2, TimeUnit.SECONDS);
	}
	
	
	
	// 方式四：这是个单线程
	@Test
	public static void method_04() {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 5; i++) {
			final int index = i;
			executor.execute(() -> {
				try {
					Thread.sleep(2 * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "   " + index);
			});
		}
		executor.shutdown();
	}

}
