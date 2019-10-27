package com.example.gorgeous.pomeranian.service;

import com.example.gorgeous.pomeranian.dto.InventoryDto;
import com.example.gorgeous.pomeranian.dto.PurchaseDto;
import com.example.gorgeous.pomeranian.entities.Inventory;
import com.example.gorgeous.pomeranian.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class email {

	@Autowired
	InventoryRepository inventoryRepository;

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
	public static void sendHTMLEmail(String sendTo, String subject, String content) {

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
			message.setContent(content, "text/html");

			Transport.send(message);

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public String toHTMLString(PurchaseDto transactionDetail){
		InventoryDto[] currentItems = transactionDetail.getItems();
		String temp = "<h1>Thank you for your purchase</h1><table><tr><th>Name</th><th>Quantity</th>";
		for(int i = 0; i < currentItems.length; i++){
			System.out.println("Bouta crash");
			Inventory item = inventoryRepository.findBySku(currentItems[i].getSku());
			System.out.println(item.getInventoryName());
			temp += "<tr><td>" + item.getInventoryName() + "</td><td>" + currentItems[i].getQuantity() + "</td></tr>";
		}
		temp += "</table><h3>Total cost: $" + transactionDetail.getOrderTotal() + "</h3>";
		temp += "<p>Delivery to: " + transactionDetail.getAddress() + " for user: " + transactionDetail.getUsername() + "</p>";
		return temp;
	}
}
