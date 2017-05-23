package org.arthub.persistence.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "calendar")
public class CalendarModel extends Model {
	
	@Column
	private int day;
	
	@Column
	private int month;
	
	@Column
	private int year;
	
	@OneToMany(mappedBy = "date")
	private List<CalendarResourceModel> calendarResource = new ArrayList<CalendarResourceModel>();

	public List<CalendarResourceModel> getCalendarResource() {
		return calendarResource;
	}

	public void setCalendarResource(List<CalendarResourceModel> calendarResource) {
		this.calendarResource = calendarResource;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
