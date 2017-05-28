package org.arthub.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.arthub.persistence.model.EventModel;
import org.arthub.persistence.model.RoleModel;
import org.arthub.persistence.model.UserModel;
import org.arthub.persistence.model.UserTokenModel;
import org.arthub.persistence.repository.RoleRepository;
import org.arthub.persistence.repository.UserRepository;
import org.arthub.persistence.repository.UserTokenRepository;
import org.arthub.service.data.IncomeReportData;
import org.arthub.service.data.UserData;
import org.arthub.service.data.UserInfo;
import org.arthub.service.data.UserName;
import org.arthub.service.data.UsernameData;
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
			userData.setBalance(user.getCurrency());
			userData.setId(user.getId());
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

	@Override
	public List<UsernameData> getAllUsersUsername() {
		List<UserModel> models = userRepository.findAll();
		List<UsernameData> data = new ArrayList<UsernameData>();
		for (UserModel model : models) {
			UsernameData username = new UsernameData();
			username.setUsername(model.getUsername());
			data.add(username);
		}
		return data;
	}

	@Override
	public UserInfo getUserInfo(int id) {
		UserModel user = userRepository.findOne(id);
		UserInfo userInfo = new UserInfo();
		userInfo.setEmail(user.getEmail());
		userInfo.setBalance(user.getCurrency());
		userInfo.setFirstName(user.getFirstName());
		userInfo.setLastName(user.getLastName());
		userInfo.setPassword(user.getPassword());
		userInfo.setRole(user.getRole().getRole());
		userInfo.setUsername(user.getUsername());
		
		return userInfo;
	}

	@Override
	public void updateUser(UserInfo userData, int id) {
		UserModel userModel = userRepository.findOne(id);
		if(!userData.getPassword().equals("")){
			userModel.setPassword(userData.getPassword());
		}
		if(userData.getBalance() != 0){
			userModel.setCurrency(userData.getBalance());
		}
		if(!userData.getUsername().equals("")){
			userModel.setUsername(userData.getUsername());
		}
		if(!userData.getFirstName().equals("")){
			userModel.setFirstName(userData.getFirstName());
		}
		if(!userData.getLastName().equals("")){
			userModel.setLastName(userData.getLastName());
		}
		if(!userData.getEmail().equals("")){
			userModel.setEmail(userData.getEmail());
		}
		if(userData.getRole().equals("true")){
			if(userModel.getRole().getRole().equals("ROLE_USER")){
				RoleModel newRole = userRoleRepository.findByRole("ROLE_ADMIN");
				userModel.setRole(newRole);
			} else {
				RoleModel newRole = userRoleRepository.findByRole("ROLE_USER");
				userModel.setRole(newRole);
			}
		}
		userRepository.save(userModel);
	}

	@Override
	public UserInfo getUserInfo() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserModel user = userRepository.findByUsername(auth.getName());
		return getUserInfo(user.getId());
	}

	@Override
	public void updateUser(UserInfo user) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserModel model = userRepository.findByUsername(auth.getName());
		updateUser(user, model.getId());
		
	}

	@Override
	public List<IncomeReportData> getIncomeReport() {
		List<UserModel> models = userRepository.findAll();
		List<IncomeReportData> data = new ArrayList<IncomeReportData>();
		
		for (UserModel model : models) {
			IncomeReportData incomeReport = new IncomeReportData();
			incomeReport.setFirstName(model.getFirstName());
			incomeReport.setLastName(model.getLastName());
			incomeReport.setUsername(model.getUsername());
			int dueAmount = 0;
			for (EventModel event : model.getEventsCreated()) {
				dueAmount += event.getCost();
			}
			incomeReport.setDueAmount(dueAmount);
			data.add(incomeReport);
		}
		
		return data;
	}

}