package org.arthub.persistence.repository;

import java.util.List;


import org.arthub.persistence.model.UserModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Integer>{
	
	UserModel findByUsername(String username);
	
	List<UserModel> findAll();
	
}