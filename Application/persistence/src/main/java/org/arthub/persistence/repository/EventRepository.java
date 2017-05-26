package org.arthub.persistence.repository;

import java.util.List;

import org.arthub.persistence.model.EventModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<EventModel, Integer>{

	List<EventModel> findFirst5ByOrderByStartDateAsc();
}
