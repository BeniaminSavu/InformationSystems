package org.arthub.authentication;
public interface EmailSender {

	void sendMail(String to, String token);
	
}