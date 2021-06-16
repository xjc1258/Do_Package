package basic.Singleton;

public class Test {

	public static void main(String[] args) {
		Thread t1 = new Thread(new T());
		Thread t2 = new Thread(new T());
		t1.start();
		t2.start();
	}

	
	
	
	
	@org.junit.Test
	public void test(){
		Thread t3 = new Thread(new T());
		Thread t4 = new Thread(new T());
		t3.start();
		t4.start();
	}
}
