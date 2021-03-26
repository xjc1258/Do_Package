package String;

import java.util.ArrayList;
import java.util.HashMap;

public class Map {

	public static void main(String[] args) {
		ArrayList<String> perlist = new ArrayList<String>();
		for (int i = 0; i < 4; i++) {
			java.util.Map<String, Object> customermap = new HashMap<String, Object>();
			Person p = new Person();
			customermap.put("1", "2");
			customermap.put("2", "2");
			customermap.put("3", "2");
			customermap.put("4", "2");
			customermap.put("5", "2");
			customermap.put("6", "2");
			customermap.put("7", "2");
			
			perlist.add(customermap.toString());
		}
		//对string求长度
		String s ="a,b,c,d";
		String w ="200";
		System.out.println(s.length());
		System.out.println(w.length());
	}

}
