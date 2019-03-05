package com.guigu.service.materials;

/**
 * 邮件接口
 * 
 * @author ExcellentLiuYang
 *
 */
public interface IMailService {
	void sendSimpleMail(String to, String subject, String content);// 简单邮件

	void sendHtmlMail(String to, String subject, String content);// html邮件

	void sendAttachmentsMail(String to, String subject, String content, String filePath);// 带附件邮件

	void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);// 带静态资源文件（图片）的邮件
}
