package org.arthub.controller;

import org.arthub.controller.response.ResourceResponse;
import org.arthub.persistence.model.ResourceModel;
import org.arthub.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
}
