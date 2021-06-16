package basic.String;

public class FirstWordToBig {

	private static String getMethodName(String fildeName) throws Exception {
		byte[] items = fildeName.getBytes();
		for (int i = 0; i < items.length; i++) {
			//这个是将所有的字符串变大写,俗称效率很高
			items[i] = (byte) ((char) items[i] - 'a' + 'A');
		}
		return new String(items);
	}

	public static void main(String[] args) throws Exception {
		System.out.println(getMethodName("ughogahgooa"));
	}

}
