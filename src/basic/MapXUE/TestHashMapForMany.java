package basic.MapXUE;

public class TestHashMapForMany {
	public static void main(String[] args) {
		HashMapThread thread0 = new HashMapThread();
		HashMapThread thread1 = new HashMapThread();
		HashMapThread thread2 = new HashMapThread();
		HashMapThread thread3 = new HashMapThread();
		HashMapThread thread4 = new HashMapThread();
		thread0.start();
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}

}
