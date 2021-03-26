package order;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Stringq {

	public static void main(java.lang.String[] args) {
		Map<String, String> map = new HashMap<String, String>();
	    map.put("1", "2");
	    map.put("2", "2");
	    map.put("3", "2");
	    map.put("4", "2");
	    map.put("5", "2");
	    map.put("6", "2");
	    map.put("7", "2");
	    map.put("8", "2");
	    for(Entry<String, String> entry:map.entrySet()){
	    	System.out.println(entry.getKey()+entry.getValue());
	    }
	    //20210407
	}
}
