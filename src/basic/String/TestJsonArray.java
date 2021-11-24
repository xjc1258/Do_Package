package basic.String;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TestJsonArray {
	public static void main(String[] args) throws Exception {
		String sJSON = "[{a:'b'},{a:'c'}]";
	
	
		try {
			JSONArray array = new JSONArray(sJSON);
			for (int i = 0; i < array.length(); i++) {
				JSONObject iObj = array.getJSONObject(i);
				System.out.println(iObj.get("a"));
			}
		} catch (JSONException e) {// 抛错 说明JSON字符不是数组或根本就不是JSON
			try {
				JSONObject object = new JSONObject(sJSON);
				System.out.println(object.get("a"));
			} catch (JSONException e2) {// 抛错 说明JSON字符根本就不是JSON
				System.out.println("非法的JSON字符串");
			}
		}
	}
}