package org.java17recipes.chapter14.recipe14_04;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Recipe14_4 {

	public static void main(String[] args) {
		Recipe14_4 recipe = new Recipe14_4();
		recipe.start();
	}

	private void start() {
		String host = "smtp.gmail.com";
		String username = "mymailusername";
		String password = "mygmailpassword";
		String from = "mygmailusername@gmail.com";
		String to = "someuser@somewhere.com";

		Properties properties = new Properties(); 
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.ssl.enable", "true");


		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		session.setDebug(true);	

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Subject Test");

			// Create Mime Content
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			String html = "<H1>Important Message</H1>" +
					"<b>This is an important message...</b>"+
					"<br/><br/>" +
					"<i>Be sure to code your Java today!</i>" +
					"<H2>It is the right thing to do!</H2>";
			messageBodyPart.setContent(html, "text/html; charset=utf-8");

			MimeBodyPart fileBodyPart = new MimeBodyPart();
			fileBodyPart.attachFile(System.getProperty("user.dir")+ File.separator +"attach.txt");

			MimeBodyPart fileBodyPart2 = new MimeBodyPart();
			fileBodyPart2.attachFile(System.getProperty("user.dir")+ File.separator +"attach2.txt");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			multipart.addBodyPart(fileBodyPart);
			//add another body part to supply another attachment
			multipart.addBodyPart(fileBodyPart2);
			message.setContent(multipart);
			System.out.println("sending message...");
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException | IOException e) {
			e.printStackTrace();
		}
	}
}

