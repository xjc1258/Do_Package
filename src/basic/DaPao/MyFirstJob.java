package DaPao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyFirstJob implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		String printTime = new SimpleDateFormat("yy-MM-dd HH-mm-ss").format(new Date());
		System.out.println("PrintWordsJob start at:" + printTime + ", prints: Hello Job-" + new Random().nextInt(100));

	}
}
