package org.arthub.service.helper;
public interface EmailSender {

	void sendMail(String to, String token);
	
}