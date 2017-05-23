package org.arthub.persistence.repository;

import org.arthub.persistence.model.CalendarResourceModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarResourceRepository extends CrudRepository<CalendarResourceModel, Integer>{

}
