package org.arthub.persistence.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

	@Column
	private String description;

	@OneToMany(mappedBy = "resource")
	private List<CalendarResourceModel> calendarResource = new ArrayList<CalendarResourceModel>();

	@OneToMany(mappedBy = "resource", cascade = CascadeType.ALL)
	private List<EventModel> events;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

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

	public List<EventModel> getEvents() {
		return events;
	}

	public void setEvents(List<EventModel> events) {
		this.events = events;
	}

}
