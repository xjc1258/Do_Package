package basic.Prototype;

public class Test {
	//拒绝在for中new对象
	public static void main(String[] args) throws CloneNotSupportedException {
		Mail mail = new Mail();
		mail.setContent("初始化模板");

		for (int i = 0; i < 10; i++) {
			Mail tempMail =(Mail)mail.clone();//克隆的时候并没有调用mail的构造器
			tempMail.setName("姓名" + i);
			tempMail.setEmailAdress("姓名" + i + "@imulkk.com");
			tempMail.setContent("共享您，此次慕课网中奖了");
			MailUtil.sendMail(tempMail);
		}
		MailUtil.saveOriginMailRecord(mail);
	}
	
	
	
	
	/*
	 * 深克隆和浅克隆
	 * 
	 */

}
