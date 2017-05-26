package org.arthub.service;

import java.util.List;

import org.arthub.persistence.model.ResourceModel;
import org.arthub.service.data.CalendarData;
import org.arthub.service.data.ResourceData;
import org.arthub.service.data.ResourceDetailsData;

public interface ResourceService {
	
	public void createResource(ResourceModel resource);

	public void deleteResource(int id);

	public List<ResourceData> getAllResources();

	public ResourceDetailsData getResource(int id);

	public List<CalendarData> getResourceAvailability(String resourceName);

	public boolean isResourceAvailable(String resource, String date, int duration);
	
	public void changeResourceAvailable(String resource, String date, int duration);
}