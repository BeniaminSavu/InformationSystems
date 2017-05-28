package org.arthub.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.arthub.persistence.model.EventModel;
import org.arthub.persistence.model.ResourceModel;
import org.arthub.persistence.model.UserModel;
import org.arthub.persistence.repository.EventRepository;
import org.arthub.persistence.repository.ResourceRepository;
import org.arthub.persistence.repository.UserRepository;
import org.arthub.service.data.EventData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService{

	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private ResourceRepository resourceRepository;
	
	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private ResourceService resourceServie;
	
	@Override
	public void createEvent(EventData event) {
		EventModel newEvent = new EventModel();
		ResourceModel resource = resourceRepository.findByName(event.getResource());
		newEvent.setResource(resource);
		
		if(!resourceServie.isResourceAvailable(event.getResource(), event.getDate(), event.getDuration())){
			return;
		}
		
		List<UserModel> participants = new ArrayList<UserModel>();
		UserModel owner = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		newEvent.setOwnedByUser(owner);
		for(String username : event.getParticipants()){
			UserModel participant = userRepository.findByUsername(username);
			participants.add(participant);
		}
		participants.add(owner);
		newEvent.setUsers(participants);
		newEvent.setDescription(event.getDescription());
		newEvent.setDuration(event.getDuration());
		newEvent.setName(event.getName());
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date date = formatter.parse(event.getDate());
			newEvent.setStartDate(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		newEvent.setCost(resource.getPrice() * event.getDuration());
		if(owner.getCurrency() < newEvent.getCost()){
			return;
		}
		resourceServie.changeResourceAvailable(event.getResource(), event.getDate(), event.getDuration());
		eventRepository.save(newEvent);
	}

	@Override
	public List<EventData> getComingEvents() {
		List<EventModel> models =eventRepository.findFirst5ByOrderByStartDateAsc();
		List<EventData> data = new ArrayList<EventData>();
		for (EventModel model : models) {
			EventData event = new EventData();
			event.setDescription(model.getDescription());
			event.setName(model.getName());
			event.setResource(model.getResource().getName());
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(model.getStartDate());
			event.setDate(""+calendar.get(Calendar.DAY_OF_MONTH) +"-"+(calendar.get(Calendar.MONTH)+1) +"-"+calendar.get(Calendar.YEAR));
			data.add(event);
		}
		
		return data;
	}

	@Override
	public List<EventData> getCreatedEvents() {
		UserModel user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		List<EventModel> models = eventRepository.findByOwnedByUser(user);
		List<EventData> data = new ArrayList<EventData>();
		for (EventModel model : models) {
			EventData event = new EventData();
			event.setDescription(model.getDescription());
			event.setName(model.getName());
			event.setResource(model.getResource().getName());
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(model.getStartDate());
			event.setDate(""+calendar.get(Calendar.DAY_OF_MONTH) +"-"+(calendar.get(Calendar.MONTH)+1) +"-"+calendar.get(Calendar.YEAR));
			data.add(event);
		}
		
		return data;
	}

	@Override
	@Transactional
	public List<EventData> getInvitedEvents() {
		UserModel user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		List<EventModel> models = user.getInvites();
		List<EventData> data = new ArrayList<EventData>();
		for (EventModel model : models) {
			EventData event = new EventData();
			event.setDescription(model.getDescription());
			event.setName(model.getName());
			event.setResource(model.getResource().getName());
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(model.getStartDate());
			event.setDate(""+calendar.get(Calendar.DAY_OF_MONTH) +"-"+(calendar.get(Calendar.MONTH)+1) +"-"+calendar.get(Calendar.YEAR));
			data.add(event);
		}
		
		return data;
	}
	
	
}
