package basic.Prototype;

import java.text.MessageFormat;

public class MailUtil {
	public static void sendMail(Mail mail) {

		String outputContent = "向{0}同学,邮件地址:{1},邮件内容:{2}发送邮件";
		System.out
				.println(MessageFormat.format(outputContent, mail.getName(), mail.getEmailAdress(), mail.getContent()));

	}
	public static void saveOriginMailRecord(Mail mail){
		System.out.println("存储original记录,originalMail:"+mail.getContent());
		
	}

}
