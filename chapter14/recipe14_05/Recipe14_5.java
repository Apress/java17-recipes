package org.java17recipes.chapter14.recipe14_05;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Recipe14_5 {
	public static void main(String[] args) {
		Recipe14_5 recipe = new Recipe14_5();
		recipe.start();
	}

	private void start() {

		List<String> emails = getEmails();

		String host = "smtp.gmail.com";
		String username = "mymailusername";
		String password = "mygmailpassword";
		String from = "mygmailusername@gmail.com"; 

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
			message.setRecipients(Message.RecipientType.BCC, getRecipients(emails));
			message.setSubject("Subject");
			message.setContent("This is a test message", "text/plain");
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	private Address[] getRecipients(List<String> emails) throws AddressException {
		Address[] addresses = new Address[emails.size()];
		for (int i =0;i < emails.size();i++) {
			addresses[i] = new InternetAddress(emails.get(i));
		}
		return addresses;
	}

	public List<String> getEmails() {
		ArrayList<String> emails = new ArrayList<>();
		emails.add("jack@hill.com");
		emails.add("jill@hill.com");
		emails.add("water@hill.com");
		return emails;
	}

}

