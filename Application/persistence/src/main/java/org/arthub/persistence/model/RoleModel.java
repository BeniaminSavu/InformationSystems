package org.arthub.persistence.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "role")
public class RoleModel extends Model {

	private String role;

	@OneToMany(mappedBy = "role", cascade=CascadeType.REMOVE, fetch=FetchType.EAGER,  orphanRemoval = true)
	private List<UserModel> users = new ArrayList<UserModel>();

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<UserModel> getUsers() {
		return users;
	}

	public void setUsers(List<UserModel> users) {
		this.users = users;
	}

	
}
