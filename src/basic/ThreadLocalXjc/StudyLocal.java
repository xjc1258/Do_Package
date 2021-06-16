package ThreadLocalXjc;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class StudyLocal {

	public static void main(String[] args) {
		/*
		 * ThreadLocal<String> local = new ThreadLocal<>(); Random random = new
		 * Random(); IntStream.range(0, 5).forEach(a -> new Thread(() -> {
		 * local.set(a + "" + random.nextInt(10));
		 * System.out.println("线程和local值分别是" + local.get()); try {
		 * TimeUnit.SECONDS.sleep(1); } catch (Exception e) {
		 * e.printStackTrace(); } }).start());
		 */

		String[] names = { "Jon", "Darin", "Bauke", "Hans", "Marc" };
		List<String> list = Arrays.asList(names);
		IntStream.range(0, list.size()).mapToObj(i -> String.format("%d %s", i + 1, list.get(i))).forEach(each -> {
			System.out.println(each);
		});
	}

	public void study() {
		int[] ints = { 1, 5, 9, 2, 5, 63, 4, 8 };
		System.out.println("________分割线① rangeClosed 使用_________");
		IntStream.rangeClosed(0, 5).forEach(System.out::println);

		System.out.println("________分割线② range 使用_________");
		IntStream.range(0, 5).forEach(System.out::println);

		System.out.println("________分割线② sum 使用_________");
		int sum = IntStream.rangeClosed(0, 5).sum();
		System.out.println(sum);

		System.out.println("________分割线② sorted 使用_________");
		IntStream.of(ints).sorted().forEach(System.out::println);

		// ------------------------------>

		System.out.println("---------① rangeClosed-----------------------");
		LongStream.rangeClosed(0, 3).forEach(System.out::print);

		System.out.println("---------② range-----------------------");
		LongStream.range(0, 3).forEach(System.out::print);

		System.out.println("---------③ sum-----------------------");
		long sum1 = LongStream.range(0, 3).sum();
		System.out.println(sum1);

		System.out.println("---------④ sum-----------------------");
		LongStream.of(1L, 9L, 4L, 6L, 3L).sorted().forEach(System.out::print);

		// ========================================================================>

		System.out.println("########一###############");
		DoubleStream.of(2.5, 1.5, 1.2, 5.6).map(each -> each + 2).forEach(each -> {
			System.out.println(each);
		});
		System.out.println("########二average 计算平均值###############");
		double average = DoubleStream.of(2.0, 3.0, 4.0, 5.0).average().getAsDouble();
		System.out.println(average);

		System.out.println("########三 max 查找最大值###############");
		double aDouble = DoubleStream.of(2.0, 3.0, 4.0, 5.0).max().getAsDouble();
		System.out.println(aDouble);

		System.out.println("########四 选出大 x>=3  且  x<=4 的double值###############");
		DoubleStream.of(2.0, 3.0, 4.0, 5.0).filter(each -> each >= 3.0 && each <= 4.0).forEach(System.out::print);

		/*
		 * String[] names = { "Jon", "Darin", "Bauke", "Hans", "Marc" };
		 * List<String> list = Arrays.asList(names);
		 * 
		 * Stream.iterate(0, i -> i + 1).limit(list.size()).forEach(i -> {
		 * String s= list.get(i); System.out.println(s); System.out.println(i);
		 * });
		 */

		String[] names = { "Jon", "Darin", "Bauke", "Hans", "Marc" };
		List<String> list = Arrays.asList(names);
		IntStream.range(0, list.size()).mapToObj(i -> String.format("%d %s", i + 1, list.get(i))).forEach(each -> {
			System.out.println(each);
		});
	}
}
