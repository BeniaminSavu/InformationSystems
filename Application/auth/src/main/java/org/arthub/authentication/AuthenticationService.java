package org.arthub.authentication;

import org.arthub.persistence.model.UserModel;

public interface AuthenticationService {
	
	void createUser(UserModel user);

	String validate(String userToken);
}