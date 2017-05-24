package org.arthub.persistence.repository;

import java.util.List;

import org.arthub.persistence.model.CalendarResourceModel;
import org.arthub.persistence.model.ResourceModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarResourceRepository extends CrudRepository<CalendarResourceModel, Integer>{

	List<CalendarResourceModel> findByResourceAndAvailable(ResourceModel resource, boolean available);
}
