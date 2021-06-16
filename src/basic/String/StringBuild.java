package basic.String;

import org.apache.commons.lang3.StringUtils;

public class StringBuild {

	public static String buildSqlForIn(String fieldname, String[] fieldvalue) {
		if (fieldvalue == null || fieldvalue.length == 0) {
			return " (1=2) ";
		}
		StringBuffer sbSQL = new StringBuffer();
		sbSQL.append("(" + fieldname + " IN ( ");
		int len = fieldvalue.length;

		for (int i = 0; i < len; i++) {
			if (StringUtils.isNotBlank(fieldvalue[i])) {
				sbSQL.append("'").append(fieldvalue[i]).append("'");
				if (i != fieldvalue.length - 1) {
					if (i > 0 && (i + 1) % 200 == 0) {

						sbSQL.append(" ) OR ").append(fieldname).append(" IN ( ");
					} else if (i < len - 1 && StringUtils.isNotBlank(fieldvalue[i + 1])) {
						sbSQL.append(",");
					}
				}
			}
		}
		sbSQL.append(" )) ");
		return sbSQL.toString();
	}
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append(buildSqlForIn("initcode", new String[] { "mdm_type" }));
		System.out.println(sb.toString());
	}

}
