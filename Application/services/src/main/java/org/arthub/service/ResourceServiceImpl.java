package org.arthub.service;

import java.util.List;

import org.arthub.persistence.model.ResourceModel;
import org.arthub.persistence.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceServiceImpl implements ResourceService{

	@Autowired
	private ResourceRepository resourceRepository;

	@Override
	public void createResource(ResourceModel resource) {
		resource.setAvailability(false);
		resource.setRoomMember(0);
		resource.setTimeAllocation(0);
		resourceRepository.save(resource);
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
