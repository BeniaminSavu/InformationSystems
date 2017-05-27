package org.arthub.persistence.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserModel extends Model {

	private String firstName;
	private String lastName;

	@Column(unique = true, nullable = false)
	private String username;

	@Column(unique = true, nullable = false)
	private String email;
	private String password;

	@OneToOne
	@JoinColumn(name = "userTokenId")
	private UserTokenModel userToken;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "roleId")
	private RoleModel role;

	@OneToMany(mappedBy = "ownedByUser", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<EventModel> eventsCreated = new ArrayList<EventModel>();

	@ManyToMany(mappedBy = "users", fetch=FetchType.LAZY)
	private List<EventModel> invites = new ArrayList<EventModel>();

	private int currency;

	public List<EventModel> getInvites() {
		return invites;
	}

	public void setInvites(List<EventModel> invites) {
		this.invites = invites;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserTokenModel getUserToken() {
		return userToken;
	}

	public void setUserToken(UserTokenModel userToken) {
		this.userToken = userToken;
	}

	public RoleModel getRole() {
		return role;
	}

	public void setRole(RoleModel role) {
		this.role = role;
	}

	public List<EventModel> getEventsCreated() {
		return eventsCreated;
	}

	public void setEventsCreated(List<EventModel> eventsCreated) {
		this.eventsCreated = eventsCreated;
	}

	public int getCurrency() {
		return currency;
	}

	public void setCurrency(int currency) {
		this.currency = currency;
	}

}
