package org.arthub.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.arthub.persistence.model.RoleModel;
import org.arthub.persistence.model.UserModel;
import org.arthub.persistence.model.UserTokenModel;
import org.arthub.persistence.repository.RoleRepository;
import org.arthub.persistence.repository.UserRepository;
import org.arthub.persistence.repository.UserTokenRepository;
import org.arthub.service.data.UserData;
import org.arthub.service.data.UserName;
import org.arthub.service.helper.EmailSender;
import org.arthub.service.helper.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository userRoleRepository;

	@Autowired
	private UserTokenRepository userTokenRepository;

	@Autowired
	private EmailSender emailSender;

	@Autowired
	private Generator tokenGenerator;

	public void createUser(UserModel user) {
		String token = tokenGenerator.generateToken();
		RoleModel role = userRoleRepository.findByRole("ROLE_USER");
		user.setRole(role);

		UserTokenModel userToken = new UserTokenModel();
		userToken.setToken(token);
		userToken.setDate(new Date());
		userTokenRepository.save(userToken);

		userToken = userTokenRepository.findByToken(token);
		user.setUserToken(userToken);
		userRepository.save(user);

		// emailSender.sendMail(user.getEmail(), token);
	}

	@Override
	public boolean verify(String userToken) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long getUserId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserModel findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserName getFullName() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserModel user = userRepository.findByUsername(auth.getName());
		UserName userData = new UserName();
		userData.setFirstName(user.getFirstName());
		userData.setLastName(user.getLastName());
		return userData;

	}

	@Override
	public List<UserData> getUsers() {
		List<UserModel> users = userRepository.findAll();
		List<UserData> data = new ArrayList<UserData>();
		for (UserModel user : users) {
			UserData userData = new UserData();
			userData.setEmail(user.getEmail());
			userData.setFirstName(user.getFirstName());
			userData.setLastName(user.getLastName());
			userData.setUsername(user.getUsername());
			userData.setRole(user.getRole().getRole());
			data.add(userData);
		}
		return data;
	}

	public void deleteUser(String username) {
		UserModel user = userRepository.findByUsername(username);
		user.setRole(null);
		user.setUserToken(null);
		userRepository.save(user);
		userRepository.delete(user);
	}

	public void deleteAllUsers() {
		List<UserModel> users = userRepository.findAll();
		for (UserModel user : users) {
			userRepository.delete(user);
		}
	}

	public void updateRole(String username, RoleModel role) {
		UserModel user = userRepository.findByUsername(username);
		user.setRole(role);

	}

}