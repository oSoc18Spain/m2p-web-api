package com.m2p.web.api.models.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="machine")
public class Machine implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	
	private String state;
	
	private String data;
	
	@OneToMany(mappedBy="machineObj")
	private Set<Event> events;
	
	@ManyToOne
	@JoinColumn(name="linechanel_id")
	private LineChanel linechanelObj;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

	public LineChanel getLinechanelObj() {
		return linechanelObj;
	}

	public void setLinechanelObj(LineChanel linechanelObj) {
		this.linechanelObj = linechanelObj;
	}
	
	private static final long serialVersionUID = 1L;
}
