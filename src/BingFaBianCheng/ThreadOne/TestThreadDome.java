package BingFaBianCheng.ThreadOne;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 * @author xjc
 * @date 2021-05-27
 * @desc 四种创建多线程的方式
 */
public class TestThreadDome {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		// 获取当前cpu内核数
		System.out.println(Runtime.getRuntime().availableProcessors());
		// 第一种:继承Thread类
		Dome01 dome01 = new Dome01();
		new Thread(dome01).start();
		// 第二种:实现Runnable接口
		Dome02 dome02 = new Dome02();
		new Thread(dome02).start();
		// 第三种:Callable接口
		FutureTask<Integer> demo03 = new FutureTask<>(new Dome03());
		new Thread(demo03, "demo3").start();
		// 第四种：线程池(本质还是new thread)
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 1L, TimeUnit.SECONDS,
				new LinkedBlockingDeque<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
		threadPoolExecutor.execute(() -> System.out.println("........."));
		threadPoolExecutor.shutdown();
		Integer integer = demo03.get();// 要求获取Callable线程的执行时间，如果没有出现结果就会造成阻塞，所以一般get()方法放在最后
		System.out.println(integer);
	}
}

class Dome01 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {

		}
	}
}

class Dome02 implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
		}
	}
}

class Dome03 implements Callable<Integer> {
	@Override
	public Integer call() throws Exception {
		long start = System.currentTimeMillis();
		TimeUnit.SECONDS.sleep(5);
		long end = System.currentTimeMillis();
		return Math.toIntExact(end - start);
	}
}
