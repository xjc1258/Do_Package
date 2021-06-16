package basic.MapXUE;

import java.util.Comparator;

public class MyComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		String param1 = (String) o1;
		String param2 = (String) o2;
		return -param1.compareTo(param2);
	}

}
