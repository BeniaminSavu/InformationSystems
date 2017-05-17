package org.arthub.persistence.repository;

import java.util.List;

import org.arthub.persistence.model.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Integer>{
	
	UserModel findByUsername(String username);
	
	List<UserModel> findAll();
}