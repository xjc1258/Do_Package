package basic.Thread;

public class SynchronizeHHH {
	public  static  void  main(String[] args){
		Object lock = new Object();
		synchronized(lock) {
			System.out.println("ok");
		}
		System.out.println(lock.hashCode());
	}
}