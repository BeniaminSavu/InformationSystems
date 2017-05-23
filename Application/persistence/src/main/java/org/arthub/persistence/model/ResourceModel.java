package org.arthub.persistence.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "resource")
public class ResourceModel extends Model {
	@Column
	private String name;

	@Column
	private int price;

	@Column
	private int capacity;

	@OneToMany(mappedBy = "resource")
	private List<CalendarResourceModel> calendarResource = new ArrayList<CalendarResourceModel>();
	
	public List<CalendarResourceModel> getCalendarResource() {
		return calendarResource;
	}

	public void setCalendarResource(List<CalendarResourceModel> calendarResource) {
		this.calendarResource = calendarResource;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
