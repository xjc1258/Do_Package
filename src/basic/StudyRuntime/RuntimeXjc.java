package basic.StudyRuntime;

public class RuntimeXjc {
	
	public static void main(String[] args) throws Exception
    {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("total memory:"+runtime.totalMemory()/(1024*1024) + "M");
        System.out.println("max memory:" + runtime.maxMemory()/(1024*1024) + "M");
        System.out.println("free memory:" + runtime.freeMemory()/(1024*1024) + "M");
        System.out.println("Main Done//~~");
        
        
        //用于释放内存的无用空间
        runtime.gc();
        System.out.println("Main Done//~~");
        
        //调用本机的一些可执行程序
        Process process = runtime.exec("notepad");
        Thread.sleep(1000*5);
        process.destroy();
        System.out.println("Main Done//~~");
        
    }


}
