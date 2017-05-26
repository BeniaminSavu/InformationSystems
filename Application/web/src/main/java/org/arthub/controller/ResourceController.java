package org.arthub.controller;

import java.util.List;

import org.arthub.controller.response.ResourceResponse;
import org.arthub.persistence.model.ResourceModel;
import org.arthub.service.ResourceService;
import org.arthub.service.data.CalendarData;
import org.arthub.service.data.ResourceData;
import org.arthub.service.data.ResourceDetailsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/arthub/resource")
public class ResourceController {

	@Autowired
	private ResourceService resourceService;
	
	@PostMapping("/add")
	public ResourceResponse createResource(@RequestBody ResourceModel newResource){
		resourceService.createResource(newResource);
		ResourceResponse response = new ResourceResponse();
		response.setStatus(200);
		response.setMessage("Resource added");
		return response;
	}
	
	@GetMapping("/available/{resourceName}")
	public List<CalendarData> getResourceAvailable(@PathVariable("resourceName") String resourceName){
		return resourceService.getResourceAvailability(resourceName);	
	}
	
	@GetMapping("/all")
	public List<ResourceData> getAllResources(){
		return resourceService.getAllResources();
		
	}
	
	@GetMapping("/{id}")
	public ResourceDetailsData getResources(@PathVariable("id") int id){
		return resourceService.getResource(id);
		
	}
	
}
