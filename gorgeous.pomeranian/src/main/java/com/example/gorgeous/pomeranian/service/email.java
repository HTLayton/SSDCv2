package com.example.gorgeous.pomeranian.service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class email {
	public static void sendEmail(String sendTo, String subject, String body) {
		
		final String username = "securesoftwaredevelopers123@gmail.com";
		final String password = "password123!@#";
		
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.socketFactory.port", "465");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		
		Session session = Session.getInstance(prop,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});
		
		try {		
			Message message = new MimeMessage(session);
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(sendTo));
			message.setSubject(subject);
			message.setText(body);
			
			Transport.send(message);

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
