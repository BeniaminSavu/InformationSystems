package org.arthub.service;

import java.util.List;

import org.arthub.persistence.model.UserModel;
import org.arthub.service.data.UserData;
import org.arthub.service.data.UserName;

public interface UserService {

	public void createUser(UserModel user);

	public boolean verify(String userToken);

	public long getUserId();

	public UserModel findById(long id);

	public String getUsername();

	public UserName getFullName();

	public List<UserData> getUsers(); 
}