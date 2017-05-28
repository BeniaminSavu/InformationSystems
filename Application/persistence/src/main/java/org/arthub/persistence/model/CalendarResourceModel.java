package org.arthub.persistence.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "calendar_resource")
public class CalendarResourceModel extends Model {
	
	@ManyToOne
	@JoinColumn(name="calendarId")
	private CalendarModel date; 
	
	@ManyToOne
	@JoinColumn(name="resourceId")
	private ResourceModel resource;
	
	private boolean available;

	public CalendarModel getDate() {
		return date;
	}

	public void setDate(CalendarModel date) {
		this.date = date;
	}

	public ResourceModel getResource() {
		return resource;
	}

	public void setResource(ResourceModel resource) {
		this.resource = resource;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
}
