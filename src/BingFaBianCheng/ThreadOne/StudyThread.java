package BingFaBianCheng.ThreadOne;

/*
 * @author xjc
 * @date 2021-05-27
 * @desc 同时使用两种方式实现线程
 */
public class StudyThread {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("我来自runnable");
				//这个runnable传进去了，但是方法被重写了，所以不能得到实行
			}
		}) {
			@Override
			public void run() {
				System.out.println("我来自thread");
				//最终只有这行会运行
			}
		}.start();
	}

}
