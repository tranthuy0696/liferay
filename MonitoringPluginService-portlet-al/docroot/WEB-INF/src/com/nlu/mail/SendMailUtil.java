package com.nlu.mail;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.CpuTimer;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.mail.MailMessage;

public class SendMailUtil {
	private static final String MAIL_SERVER = "ngocbaostar787@gmail.com" ;
	
	public static void sendMail( String toAddress,String subject,String content) throws AddressException{
		InternetAddress from = new InternetAddress(MAIL_SERVER);
		InternetAddress dest = new InternetAddress(toAddress);
		MailMessage mailMessage = new MailMessage();
		mailMessage.setTo(dest);
		mailMessage.setFrom(from);
		mailMessage.setSubject(subject);
		mailMessage.setBody(content);
		mailMessage.setHTMLFormat(true);
		MailServiceUtil.sendEmail(mailMessage);
	}
	
	
	

}
