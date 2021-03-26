package String;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarE {

	public static void main(String[] args) {
		/*
		 * SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		 * Calendar calendar = Calendar.getInstance();
		 * calendar.add(Calendar.MONTH, -1); String first_day =
		 * format.format(calendar.getTime()); System.out.println(first_day);
		 * String a = "2015-10-11";
		 */

		/*
		 * String a = "2019-10-09"; String bb = a + " 23:59:59";
		 * System.out.println(bb);
		 */
		//获取上个月的第一天
/*		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));

		String format2 = format.format(calendar.getTime());
		System.out.println(format2);*/

		
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		/*Date date = new Date();
		Calendar calendar2 = Calendar.getInstance();
		calendar2.add(Calendar.DATE, -1);
		String yestoday = df.format(calendar2.getTime());
		System.out.println(yestoday);*/
		
		Calendar calendar = Calendar.getInstance();
		String today = df.format(calendar.getTime());
		System.out.println(today);
		
		
		
	}

}
