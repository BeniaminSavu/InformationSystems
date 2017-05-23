package org.arthub.service;


import java.util.Calendar;
import java.util.Date;

import org.arthub.persistence.model.CalendarModel;
import org.arthub.persistence.repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalendarServiceImpl implements CalendarService {

	@Autowired
	private CalendarRepository calendarRepository;
	
	@Override
	public void generateDates() {
		Date time = new Date();
		Calendar calendar = Calendar.getInstance();
		
		for(int i = 1; i<=365; i++){
			calendar.setTime(time);
			CalendarModel date = new CalendarModel();
			date.setDay(calendar.get(Calendar.DAY_OF_MONTH));
			date.setMonth(calendar.get(Calendar.MONTH) + 1);
			date.setYear(calendar.get(Calendar.YEAR));
			calendarRepository.save(date);
			time.setTime(time.getTime() + 86400000);
		}
	}

}
