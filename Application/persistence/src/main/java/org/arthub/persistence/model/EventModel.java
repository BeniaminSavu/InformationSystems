package org.arthub.persistence.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "event")
public class EventModel extends Model {

	private String name;
	private String description;

	@ManyToOne
	@JoinColumn(name = "resourceId")
	private ResourceModel resource;

	@ManyToOne
	@JoinColumn(name = "userId")
	private UserModel ownedByUser;

	@ManyToMany // (fetch = FetchType.EAGER)
	@JoinTable(name = "user_event", joinColumns = { @JoinColumn(name = "eventId") }, inverseJoinColumns = {
			@JoinColumn(name = "userId") })
	private List<UserModel> users;

	private int cost;
	private Date startDate;
	private int duration;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ResourceModel getResource() {
		return resource;
	}

	public void setResource(ResourceModel resource) {
		this.resource = resource;
	}

	public UserModel getOwnedByUser() {
		return ownedByUser;
	}

	public void setOwnedByUser(UserModel ownedByUser) {
		this.ownedByUser = ownedByUser;
	}

	public List<UserModel> getUsers() {
		return users;
	}

	public void setUsers(List<UserModel> users) {
		this.users = users;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

}
