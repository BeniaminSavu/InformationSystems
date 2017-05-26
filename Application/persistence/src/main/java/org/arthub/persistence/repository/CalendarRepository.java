package org.arthub.persistence.repository;

import java.util.List;

import org.arthub.persistence.model.CalendarModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarRepository extends CrudRepository<CalendarModel, Integer>{

	List<CalendarModel> findAll();

	CalendarModel findByDayAndMonthAndYear(int day, int month, int year);
}
