package org.arthub.controller;

import java.util.List;

import org.arthub.service.EventService;
import org.arthub.service.data.EventData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/arthub/event")
public class EventController {

	@Autowired
	private EventService eventService;
	
	@PostMapping("/add")
	public void createNewEvent(@RequestBody EventData newEvent){
		eventService.createEvent(newEvent);	
	}
	
	@GetMapping("/coming")
	public List<EventData> getComingEvents(){
		return eventService.getComingEvents();
	}
	
}
