package org.arthub.service;

import java.util.List;

import org.arthub.service.data.EventData;

public interface EventService {

	public void createEvent(EventData event);

	public List<EventData> getComingEvents();

	public List<EventData> getCreatedEvents();

	public List<EventData> getInvitedEvents();
}
