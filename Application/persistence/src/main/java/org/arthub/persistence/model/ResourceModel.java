package org.arthub.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "resource")
public class ResourceModel extends Model {
	@Column
	private String name;

	@Column
	private int timeAllocation;

	@Column
	private int roomMember;

	@Column
	private int capacity;

	@Column
	private boolean availability;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTimeAllocation() {
		return timeAllocation;
	}

	public void setTimeAllocation(int timeAllocation) {
		this.timeAllocation = timeAllocation;
	}

	public int getRoomMember() {
		return roomMember;
	}

	public void setRoomMember(int roomMember) {
		this.roomMember = roomMember;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

}
