package BingFaBianCheng.ThreadLife;
/*
 * @author xjc
 * @date 2021-05-30
 * @desc线程的生命周期
 */

public class StudyThreadLife implements Runnable {
	public static void main(String[] args) {

	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(i);

		}
	}

}
