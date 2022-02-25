package org.java17recipes.chapter14.recipe14_02;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Recipe14_2 {

	public static void main(String[] args) {
		Recipe14_2 recipe = new Recipe14_2();
		recipe.start();
	}

	private void start() {
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.somewhere.com");
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("username", "password");
			}
		});
		
		session.setDebug(true);
		
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress("someone@somewhere.com"));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress("someone@somewhere.com"));
			message.setSubject("Subject");
			message.setContent("This is a test message", "text/plain");
			System.out.println("sending message...");
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}

