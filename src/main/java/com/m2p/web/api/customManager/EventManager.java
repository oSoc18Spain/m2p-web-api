package com.m2p.web.api.customManager;

import java.util.List;

import com.m2p.web.api.models.entity.Event;

public class EventManager {
	private int status;
	private List<Event> columns;
	
	public EventManager(int status, List<Event> columns) 
	{
		this.status = status;
		this.columns = columns;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public List<Event> getColumns() {
		return columns;
	}
	public void setColumns(List<Event> columns) {
		this.columns = columns;
	}
}