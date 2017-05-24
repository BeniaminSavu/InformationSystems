package org.arthub.service;

import java.util.ArrayList;
import java.util.List;

import org.arthub.persistence.model.CalendarModel;
import org.arthub.persistence.model.CalendarResourceModel;
import org.arthub.persistence.model.ResourceModel;
import org.arthub.persistence.repository.CalendarRepository;
import org.arthub.persistence.repository.CalendarResourceRepository;
import org.arthub.persistence.repository.ResourceRepository;
import org.arthub.service.data.CalendarData;
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
	public List<ResourceModel> getAllResources() {
		return resourceRepository.findAll();
	}

	@Override
	public ResourceModel getResource(int id) {
		return resourceRepository.findById(id);
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
	
}
