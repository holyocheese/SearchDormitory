package org.searching.service.impl;
 
import java.util.Date;
import java.util.Properties;
 
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
import org.junit.Test;
 
public class SendSimpleMail {
 
	// 初始化参数
	private static Properties props;
	// 发件人地址
	private static InternetAddress sendMan = null;
	// 发件人的邮箱地址
	private static String userName = "543296676@qq.com";
	// 发件人的密码
	private static String password = "bpzdtgqupkdjbfch"; 
 
	static {
		props = new Properties();
		// 指定协议
		props.put("mail.transport.protocol", "smtp");
		// 主机 smtp.qq.com
		props.put("mail.smtp.host", "smtp.qq.com");
		// 端口
		props.put("mail.smtp.port", 465);
		// 用户密码认证
		props.put("mail.smtp.auth", "true");
		// 调试模式
		//props.put("mail.debug", "true");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
 
		try {
			//创建地址对象
			sendMan = new InternetAddress(userName);
		} catch (AddressException e) {
			throw new RuntimeException(e);
		}
	}
 
	public static void sendMail(String title,String text) throws AddressException, MessagingException {
		// 创建邮件会话
		Session session = Session.getInstance(props);
		// 创建邮件对象
		MimeMessage msg = new MimeMessage(session);
		// 设置发件人
		msg.setFrom(sendMan);
		// 设置邮件收件人
		msg.setRecipients(Message.RecipientType.TO, "543296676@qq.com");
		// 标题
		msg.setSubject(title);
		// 发送时间
		msg.setSentDate(new Date());
		// 发送内容
		msg.setText(text);
		// 5. 发送
		Transport trans = session.getTransport();
		trans.connect(userName, password);
		trans.sendMessage(msg, msg.getAllRecipients());
		trans.close();
	}
 
}
