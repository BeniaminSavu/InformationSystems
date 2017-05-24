package org.arthub.service;

import java.util.List;

import org.arthub.persistence.model.ResourceModel;
import org.arthub.service.data.CalendarData;

public interface ResourceService {
	
	public void createResource(ResourceModel resource);

	public void deleteResource(int id);

	public List<ResourceModel> getAllResources();

	public ResourceModel getResource(int id);

	public List<CalendarData> getResourceAvailability(String resourceName);
}