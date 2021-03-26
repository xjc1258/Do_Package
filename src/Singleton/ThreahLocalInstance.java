package Singleton;

public class ThreahLocalInstance {

	private static final ThreadLocal<ThreahLocalInstance> threadlocal = new ThreadLocal<ThreahLocalInstance>() {
		@Override
		protected ThreahLocalInstance initialValue(){
			return new ThreahLocalInstance();
			
		}
	};

	private ThreahLocalInstance() {

	}
	public static ThreahLocalInstance getInstance(){
		return threadlocal.get();
	}
}
