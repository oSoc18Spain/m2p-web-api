package com.m2p.web.api.customManager;

import java.util.ArrayList;
import java.util.List;

import com.m2p.web.api.models.entity.Event;

public class EventForLineManager {
	private int status = 200;
	private bodyEvent body = new bodyEvent();
	
	public EventForLineManager(List<Event> pendientEvents, List<Event> myEvents) {
		List<dataEvent> _eventP = new ArrayList<dataEvent>(); 
		for (Event event : pendientEvents) {
			dataEvent _data = new dataEvent();
			_data.setDesciption(event.getTitle());
			_data.setStatus(event.getStatus());
			if(event.getMachineObj() != null) _data.setMachine_id(event.getMachineObj().getId());
			else _data.setMachine_id(0L);
			_eventP.add(_data);
		}
		
		List<dataEvent> _myEvents = new ArrayList<dataEvent>(); 
		for (Event event : myEvents) {
			dataEvent _data = new dataEvent();
			_data.setDesciption(event.getTitle());
			_data.setStatus(event.getStatus());
			if(event.getMachineObj() != null) _data.setMachine_id(event.getMachineObj().getId());
			else _data.setMachine_id(0L);
			_myEvents.add(_data);
		}
		
		body.setNot_assigned(_eventP);
		body.setIn_progress(_myEvents);
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public bodyEvent getBody() {
		return body;
	}

	public void setBody(bodyEvent body) {
		this.body = body;
	}

	public class bodyEvent{
		List<dataEvent> not_assigned;
		List<dataEvent> in_progress;
		
		public void setNot_assigned(List<dataEvent> not_assigned) {
			this.not_assigned = not_assigned;
		}
		
		public void setIn_progress(List<dataEvent> in_progress) {
			this.in_progress = in_progress;
		}

		public List<dataEvent> getNot_assigned() {
			return not_assigned;
		}

		public List<dataEvent> getIn_progress() {
			return in_progress;
		}
	}
	
	public class dataEvent{
		private Long machine_id;
		private String desciption;
		private String status;
		
		public void setMachine_id(Long machine_id) {
			this.machine_id = machine_id;
		}
		
		public void setDesciption(String desciption) {
			this.desciption = desciption;
		}
		
		public void setStatus(String status) {
			this.status = status;
		}

		public Long getMachine_id() {
			return machine_id;
		}

		public String getDesciption() {
			return desciption;
		}

		public String getStatus() {
			return status;
		}
	} 
}