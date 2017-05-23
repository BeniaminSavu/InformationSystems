package org.arthub.service;

import java.util.List;

import org.arthub.persistence.model.CalendarModel;
import org.arthub.persistence.model.CalendarResourceModel;
import org.arthub.persistence.model.ResourceModel;
import org.arthub.persistence.repository.CalendarRepository;
import org.arthub.persistence.repository.CalendarResourceRepository;
import org.arthub.persistence.repository.ResourceRepository;
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
	
}
