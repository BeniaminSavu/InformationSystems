package org.arthub.service;

import java.util.List;

import org.arthub.persistence.model.RoleModel;
import org.arthub.persistence.model.UserModel;
import org.arthub.service.data.UserData;
import org.arthub.service.data.UserInfo;
import org.arthub.service.data.UserName;
import org.arthub.service.data.UsernameData;

public interface UserService {

	public void createUser(UserModel user);

	public boolean verify(String userToken);

	public long getUserId();

	public UserModel findById(long id);

	public String getUsername();

	public UserName getFullName();

	public List<UserData> getUsers();

	public void deleteUser(String username);

	public void deleteAllUsers();

	public void updateRole(String username, RoleModel role);
	
	public List<UsernameData> getAllUsersUsername();

	public UserInfo getUserInfo(int id);

	public void updateUser(UserInfo user, int id);
}