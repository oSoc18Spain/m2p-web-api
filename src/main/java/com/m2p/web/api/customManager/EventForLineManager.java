package com.m2p.web.api.customManager;

import java.util.List;

import com.m2p.web.api.models.entity.Event;

public class EventForLineManager {
	private int status = 200;
	private List<Event> body;
	
	public EventForLineManager(List<Event> pendientEvents, List<Event> myEvents) {
		body = pendientEvents;
		body.addAll(myEvents);
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<Event> getBody() {
		return body;
	}

	public void setBody(List<Event> body) {
		this.body = body;
	} 
}