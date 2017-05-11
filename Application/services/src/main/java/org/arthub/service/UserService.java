package org.arthub.service;

import org.arthub.persistence.model.UserModel;

public interface UserService {

	public void createUser(UserModel user);

	public boolean verify(String userToken);

	public long getUserId();

	public UserModel findById(long id);

	public String getUsername();


}