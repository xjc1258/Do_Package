package basic.JVM;
//-XX:+PrintCompilation -XX:-DoEscapeAnalysis
public class RunTimeToGood {
	public static void main(String[] args) {
		for (int i = 0; i < 200; i++) {
			long start = System.nanoTime();
			for (int j = 0; j < 1000; j++) {
				new Object();
			}
			long end = System.nanoTime();
			System.out.printf("%d\t%d\n", i, (end - start));
			//逃逸分析
		}

	}
}
