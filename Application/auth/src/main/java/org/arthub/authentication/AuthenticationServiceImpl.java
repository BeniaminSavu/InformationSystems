package org.arthub.authentication;


import org.arthub.persistence.model.UserModel;
import org.arthub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private UserService userService;

	@Autowired
	private TokenGenerator userTokenGenerator;

	///@Autowired
	//private EmailSender emailSender;

	public void createUser(UserModel user) {
		String token = userTokenGenerator.generateToken();
		userService.createUser(user, token);
		//emailSender.sendMail(user.getEmail(), token);
	}

	public String validate(String userToken) {
		String message = "";
		if (userService.verify(userToken)) {
			message = "Expired";
		} else {
			message = "Not Expired";
		}
		return message;
	}

}