package basic.String;

import java.math.BigDecimal;

import org.springframework.util.StringUtils;

public class Yunasaun {

	public static void main(String[] args) {

		BigDecimal num1 = new BigDecimal(0.005);
		BigDecimal num2 = new BigDecimal(1000000);
		BigDecimal num3 = new BigDecimal(-1000000);
		// 尽量用字符串的形式初始化
		BigDecimal num12 = new BigDecimal("0.005");
		BigDecimal num22 = new BigDecimal("1000000");
		BigDecimal num32 = new BigDecimal("-1000000");

		// 减法
		BigDecimal result2 = num1.subtract(num2);
		BigDecimal result22 = num12.subtract(num22);
	}

	public void validate() {
		int[] a = new int[] { '1', '2', '3' };
		if (a != null && a.length > 0) {

		}
		String hbbm = "qqq";
		if (StringUtils.isEmpty(hbbm)) {
			return;
		}
		
		
		//判断数据是否为空        !(ArrayUtils.isEmpty(supfivos))

	}

}
