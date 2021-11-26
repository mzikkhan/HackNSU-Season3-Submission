package application;

import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;

public class SendingMail {
	static Session mailSession;
	private static String emailID;
	private static String emailPass;
	
	static EmailAccount account;
	
	public static boolean mailLogin() {
		SendingMail.emailID="ritu.codeparina04@gmail.com";
		SendingMail.emailPass="ritucodeparina11";
		account=new EmailAccount(SendingMail.emailID,SendingMail.emailPass);
		
    	Authenticator authenticator=new Authenticator() {
    		@Override
    		protected PasswordAuthentication getPasswordAuthentication() {
    			
    			return new PasswordAuthentication(account.getAddress(),account.getPassword());
    			
    		}
    	};
    	
    	try {
    		
    		mailSession=Session.getInstance(account.getProperties(),authenticator);
    		Store store=mailSession.getStore("imaps");
    		store.connect(account.getProperties().getProperty("incomingHost"),account.getAddress(),account.getPassword());
    		account.setStore(store);
    	
    	}catch (NoSuchProviderException e) {
			
			System.out.println("Network Failed");
			
		}catch (AuthenticationFailedException e) {
			
			System.out.println("Wrong Username or Password!");
			return false;
		}catch (Exception e) {
			
			System.out.println("Unexpected Error Occured");
			return false;
		}
    	
    	return true;
		
		
	}
	public void sendVerification() {
		System.out.println("Sent");
	}
}
