package EnumStudy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @author xjc
 * @date 20210-05-19
 * @desc 枚举类的学习和书写
 */

public enum CarType {
	Small(0, "轿车"), Medium(1, "SUV"), Large(2, "MPV"), Smallbar(3, "小巴"), Mediumbar(4, "中巴"), Largebar(5, "大巴");

	CarType(Integer code, String name) {
		this.code = code;
		this.name = name;

	}

	private Integer code;
	private String name;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// 通过code来获得name
	public String getName(Integer code) {
		for (CarType carType : CarType.values()) {
			if (carType.code.equals(code)) {
				String name = carType.name;
				return name;
			}
		}
		return null;
	}

	// 通过name来获得code
	public Integer getCode(String name) {
		for (CarType carType : CarType.values()) {
			if (carType.name.equals(name)) {
				Integer code = carType.code;
				return code;
			}
		}
		return null;
	}

	// 获得整个值map
	public static Map<Integer, String> getMap() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		Arrays.stream(CarType.values()).forEach(ct -> map.put(ct.getCode(), ct.getName()));
		return map;
	}

}
