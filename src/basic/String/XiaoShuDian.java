package basic.String;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.poi.util.ArrayUtil;

public class XiaoShuDian {
	public static void main(String[] args) {
		/*
		 * String a = "129"; String b = "12";
		 */
		/*
		 * BigDecimal a1 = new BigDecimal(a); BigDecimal b1 = new BigDecimal(b);
		 * 
		 * BigDecimal sss = b1.subtract(a1); String result4 = new
		 * DecimalFormat("#.0000").format(sss);
		 */

		/*
		 * BigDecimal subtract = new BigDecimal(a).subtract(new BigDecimal(b));
		 * double parseDouble = Double.parseDouble(new DecimalFormat("##0.00")
		 * .format(subtract)); double abs = Math.abs(parseDouble);
		 * System.out.println(parseDouble); System.out.println(abs);
		 */

		/*
		 * DecimalFormat decimalFormat = new DecimalFormat("0.##"); double l =
		 * 101; String format = decimalFormat.format(l);
		 * System.out.println(format);
		 */

		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(3);
		a.add(1);
		a.add(2);
		boolean contains = a.contains(2);
		System.out.println(contains);

	}

}
