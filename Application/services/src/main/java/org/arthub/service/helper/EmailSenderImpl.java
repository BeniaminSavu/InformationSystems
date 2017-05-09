package org.arthub.service.helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;


public class EmailSenderImpl implements EmailSender {

	@Autowired
	private MailSender mailSender;
	
	public void sendMail(String to, String token) {
		SimpleMailMessage message = new SimpleMailMessage();

		message.setTo(to);
		message.setSubject("Email validation");
		message.setText("Please click on the folowing link http://localhost:8080/webapp/signup/validation/" + token);
		mailSender.send(message);
	}

}