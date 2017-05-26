package org.arthub.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.arthub.persistence.model.CalendarModel;
import org.arthub.persistence.model.CalendarResourceModel;
import org.arthub.persistence.model.ResourceModel;
import org.arthub.persistence.repository.CalendarRepository;
import org.arthub.persistence.repository.CalendarResourceRepository;
import org.arthub.persistence.repository.ResourceRepository;
import org.arthub.service.data.CalendarData;
import org.arthub.service.data.ResourceData;
import org.arthub.service.data.ResourceDetailsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceServiceImpl implements ResourceService{

	@Autowired
	private ResourceRepository resourceRepository;

	@Autowired
	private CalendarRepository  calendarRepository;
	
	@Autowired
	private CalendarResourceRepository calendarResourceRepository;
	
	@Override
	public void createResource(ResourceModel resource) {
		List<CalendarModel> dates = calendarRepository.findAll();
		resourceRepository.save(resource);
		
		for (CalendarModel date : dates) {
			CalendarResourceModel cr = new CalendarResourceModel();
			cr.setResource(resource);
			cr.setDate(date);
			cr.setAvailable(true);
			calendarResourceRepository.save(cr);
		}
		
	}

	@Override
	public void deleteResource(int id) {
		resourceRepository.delete(id);
	}

	@Override
	public List<ResourceData> getAllResources() {
		List<ResourceModel> resourceModels = resourceRepository.findAll();
		List<ResourceData> resourceData = new ArrayList<ResourceData>();
		for (ResourceModel model : resourceModels) {
			ResourceData data = new ResourceData();
			data.setId(model.getId());
			data.setCapacity(model.getCapacity());
			data.setName(model.getName());
			data.setPrice(model.getPrice());
			resourceData.add(data);
		}
		return resourceData;
	}

	@Override
	public ResourceDetailsData getResource(int id) {
		ResourceModel model = resourceRepository.findById(id);
		ResourceDetailsData data = new ResourceDetailsData();
		data.setId(model.getId());
		data.setCapacity(model.getCapacity());
		data.setDescription(model.getDescription());
		data.setName(model.getName());
		data.setPrice(model.getPrice());
		return data;
	}

	@Override
	public List<CalendarData> getResourceAvailability(String resourceName) {
		ResourceModel resource = resourceRepository.findByName(resourceName);
		CalendarResourceModel c = calendarResourceRepository.findOne(10);
		c.setAvailable(false);
		calendarResourceRepository.save(c);
		c = calendarResourceRepository.findOne(11);
		c.setAvailable(false);
		calendarResourceRepository.save(c);
		List<CalendarResourceModel> unavailableResources = calendarResourceRepository.findByResourceAndAvailable(resource, false);
		List<CalendarData> dates = new ArrayList<CalendarData>();
		for (CalendarResourceModel unavailableResource : unavailableResources) {
			CalendarData date = new CalendarData();
			date.setDay(unavailableResource.getDate().getDay());
			date.setMonth(unavailableResource.getDate().getMonth());
			date.setYear(unavailableResource.getDate().getYear());
			dates.add(date);
		}
		return dates;
	}

	@Override
	public boolean isResourceAvailable(String resourceName, String startDate, int duration) {
		ResourceModel resource = resourceRepository.findByName(resourceName);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Calendar calendar = Calendar.getInstance();
		try {
			Date time = formatter.parse(startDate);
			long timeInMs = time.getTime();
			for(int i=-1; i<duration + 1; i++){
				time.setTime( timeInMs + (i*1000*60*60*24));
				calendar.setTime(time);
				int day = calendar.get(Calendar.DAY_OF_MONTH);
				int month = calendar.get(Calendar.MONTH) + 1;
				int year = calendar.get(Calendar.YEAR);
				CalendarModel date = calendarRepository.findByDayAndMonthAndYear(day, month, year);
				CalendarResourceModel available = calendarResourceRepository.findByDateAndResource(date, resource);
				if(!available.isAvailable()){
					return false;
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public void changeResourceAvailable(String resourceName, String startDate, int duration){
		ResourceModel resource = resourceRepository.findByName(resourceName);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Calendar calendar = Calendar.getInstance();
		try {
			Date time = formatter.parse(startDate);
			long timeInMs = time.getTime();
			for(int i=-1; i<duration + 1; i++){
				time.setTime(timeInMs +( i *1000*60*60*24));
				calendar.setTime(time);
				CalendarModel date = calendarRepository.findByDayAndMonthAndYear(calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR));
				CalendarResourceModel available = calendarResourceRepository.findByDateAndResource(date, resource);
				available.setAvailable(false);
				calendarResourceRepository.save(available);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
}
