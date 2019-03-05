package com.guigu.common.materials.tools.email;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

//模板工具类
//@Component声明为bean的组件
@Component
public class SimpleMailSendTools {
	/**
	 * 
	 * public void simpleMailSend(String To, String Subject, String Text) throws
	 * IOException, MessagingException { // 读取properties文件 Properties
	 * properties_userInfo = new Properties(); InputStream inputStream_userInfo =
	 * SimpleMailSendTools.class.getClassLoader()
	 * .getResourceAsStream("materials/emailUserInfo.properties");
	 * properties_userInfo.load(new InputStreamReader(inputStream_userInfo,
	 * "UTF-8")); // 创建邮箱发送服务器 JavaMailSenderImpl mailSender = new
	 * JavaMailSenderImpl(); // host
	 * mailSender.setHost(properties_userInfo.get("host").toString()); // 用户名
	 * mailSender.setUsername(properties_userInfo.get("username").toString()); //
	 * 授权码 mailSender.setPassword(properties_userInfo.get("Password").toString());
	 * // 添加认证机制 Properties properties = new Properties();
	 * properties.put("mail.smtp.auth", true);
	 * properties.put("mail.smtp.starttls.enable", true);
	 * properties.put("mail.smtp.timeout", 5000);
	 * mailSender.setJavaMailProperties(properties); // 简单条件模板 // SimpleMailMessage
	 * mailMessage = new SimpleMailMessage(); // 复制条件模板 MimeMessage mailMessage =
	 * mailSender.createMimeMessage(); MimeMessageHelper helper = new
	 * MimeMessageHelper(mailMessage, true, "UTF-8");
	 * helper.setFrom(mailSender.getUsername()); helper.setTo(To);
	 * helper.setSubject(Subject); helper.setText(Text, true);
	 * mailSender.send(mailMessage); }
	 */

	// 模板内容
	public String template(String contractNO, String nameOfTheSupplier) {
		// 当前时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		return "<!doctype html>\n" + "<html lang=\"en\">\n" + " <head>\n" + "  <meta charset=\"UTF-8\">\n"
				+ "  <meta name=\"Generator\" content=\"EditPlus®\">\n" + "  <meta name=\"Author\" content=\"\">\n"
				+ "  <meta name=\"Keywords\" content=\"\">\n" + "  <meta name=\"Description\" content=\"\">\n"
				+ "  <title>Document</title>\n" + " </head>\n" + " <body>\n" + "\t<h3>尊敬的硅谷供货商:" + nameOfTheSupplier
				+ "</h3>\n" + "\t<p style='margin-left:40px'>你好！您的报价请求已经通过采购部门的审批，合同编号为：" + contractNO + "<br/>\n"
				+ "\t\t请您尽快处理，您可以点击<a href=\"#\">这里</a>进入系统，本消息由系统自动发送，<br/>\n" + "\t\t请勿回复！\n" + "\t</p>\n"
				+ "\t<h4 style='margin-left:260px'>" + df.format(new Date()) + "</h4>\n"
				+ "\t<h4 style='margin-left:250px'>硅谷高科物资采购管理系统</h4>\n" + " </body>\n" + "</html>\n";
	}
}
