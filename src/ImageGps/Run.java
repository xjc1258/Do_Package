package ImageGps;

import java.util.HashMap;

public class Run {

	public static void main(String[] args) {

		String api_key = "";
		String file_path = "D:\\xjc.jpg";
		ReadPicLocation rp1 = new ReadPicLocation();
		HashMap<String, Object> map = rp1.readPicInfo(file_path);
		System.out.println(map);
		String coords = map.get("纬度") + "," + map.get("经度");
	}

}
