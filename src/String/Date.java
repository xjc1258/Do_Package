package String;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Date {

	public static void main(String[] args) {
		String querytaskbegindate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(getCurrentDateTime(3));
		/// System.out.println(querytaskbegindate);
		String[] a = new String[] { "1", "3", "4" };
		String xjc = "a,b,c,d,e";
		String[] mdm_type = null;
		mdm_type = xjc.split(",");
		System.out.println(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	// 获取当前时间前5分钟
	public static java.util.Date getCurrentDateTime(int mins) {
		Calendar beforeTime = Calendar.getInstance();
		beforeTime.add(Calendar.MINUTE, mins);// mins分钟之前或者之后的时间
		java.util.Date time = beforeTime.getTime();
		return time;
	}
}
