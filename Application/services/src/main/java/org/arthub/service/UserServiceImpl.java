package org.arthub.service;


import java.util.Date;

import org.arthub.persistence.model.RoleModel;
import org.arthub.persistence.model.UserModel;
import org.arthub.persistence.model.UserTokenModel;
import org.arthub.persistence.repository.RoleRepository;
import org.arthub.persistence.repository.UserRepository;
import org.arthub.persistence.repository.UserTokenRepository;
import org.arthub.service.helper.EmailSender;
import org.arthub.service.helper.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		
		emailSender.sendMail(user.getEmail(), token);
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
}