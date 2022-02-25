package org.java17recipes.chapter14.recipe14_02;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Recipe14_02_example {

	public static void main(String[] args) {
		Recipe14_02_example recipe = new Recipe14_02_example();
		recipe.start();
	}

	private void start() {          	
		Properties properties = new Properties();
		//send an email from gmails smtp
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("user", "pass");
			}
		});

		session.setDebug(true);

		try {
			Message message = new MimeMessage(session);            
			message.setFrom(new InternetAddress("emailFrom"));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress("emailFrom"));
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

