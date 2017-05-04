package org.arthub.persistence.repository;
import org.arthub.persistence.model.RoleModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<RoleModel, Integer>{

	RoleModel findByRole(String role);

}
