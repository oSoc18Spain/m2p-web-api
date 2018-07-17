package com.m2p.web.api.customManager;

import java.util.ArrayList;
import java.util.List;

import com.m2p.web.api.models.entity.Event;

public class EventManager {
	private int status;
	private List<ColumnEvent> columns = new ArrayList<>();
	
	public EventManager(int status, List<Event> pending, List<Event> in_progress, List<Event> done ) 
	{
		this.status = status;
		ColumnEvent _pending = new ColumnEvent();
		_pending.setName("no_assigment");
		_pending.setEvent_list(pending);
		columns.add(_pending);
		
		ColumnEvent _in_progress = new ColumnEvent();
		_in_progress.setName("worker");
		_in_progress.setEvent_list(in_progress);
		columns.add(_in_progress);
		
		ColumnEvent _done = new ColumnEvent();
		_done.setName("done");
		_done.setEvent_list(done);
		columns.add(_done);
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public List<ColumnEvent> getColumns() {
		return columns;
	}
	public void setColumns(List<ColumnEvent> columns) {
		this.columns = columns;
	}
	
	public class ColumnEvent{
		private String name;
		private List<Event> event_list;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public List<Event> getEvent_list() {
			return event_list;
		}
		public void setEvent_list(List<Event> event_list) {
			this.event_list = event_list;
		}
	}
}