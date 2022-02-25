package org.java17recipes.chapter14.recipe14_06;


import javax.mail.*;
import java.io.IOException;
import java.util.Properties;

public class Recipe14_6 {

	public static void main(String[] args) {
		Recipe14_6 recipe = new Recipe14_6();
		recipe.start();
	}

	private void start() {
		String username = "username";
		String password = "password";
		String folder = "Inbox";
		String host = "imap.host.com";
		
		Properties properties = new Properties();
		properties.put("mail.imap.host", host); 
		properties.put("mail.imap.ssl.enable", "true");
		properties.put("mail.imap.auth", "true"); 

		try {
			Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});
			session.setDebug(true);	
			Store store = session.getStore("imap");
			store.connect(host,username,password);
			System.out.println(store);
			Folder inbox = store.getFolder(folder);
			inbox.open(Folder.READ_WRITE);
			int messageCount = inbox.getMessageCount();
			int startMessage = messageCount - 10;
			if (startMessage< 1) startMessage =1;
			Message messages[]  = inbox.getMessages(startMessage, messageCount);
			for (Message message : messages) {
				boolean hasBeenRead = false;
				for (Flags.Flag flag : message.getFlags().getSystemFlags()) {
					if (flag == Flags.Flag.SEEN) {
						hasBeenRead = true;
						break;
					}
				}
				message.setFlag(Flags.Flag.SEEN, false);
				System.out.println(message.getSubject() + " "+ (hasBeenRead? "(read)" : "") + message.getContent());

			}
			inbox.close(true);
		} catch (MessagingException | IOException e) {
			e.printStackTrace();
		}
	}
}
