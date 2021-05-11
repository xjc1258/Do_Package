package String;

public class Change {
	public static void main(String[] args) {

		String a = "我的姓名是1,家庭地址是2，省份是3";
		String replace = a.replace("1", "薛景超").replace("2", "临猗县").replace("3", "山西");
		System.out.println(replace);

	}

}
