package com.m2p.web.api.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.m2p.web.api.models.services.IEventService;

@Entity
@Table(name="linechannel")
public class LineChannel implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@NotNull
	private Long lineChannelId;
	
	@NotEmpty
	@NotNull
	private String type;

	@OneToMany(mappedBy="linechannelObj", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Machine> machines;
	
	@OneToMany(mappedBy="linechannelObj", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Subscription> suscriptions;
	
	@OneToMany(mappedBy="linelchannelObj", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Event> events;
	
	@Transient
	private int n_alerts = 0;
	
	@Autowired
	@Transient
	IEventService _eventService;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLineChannelId() {
		return lineChannelId;
	}

	public void setLineChannelId(Long lineChannelId) {
		this.lineChannelId = lineChannelId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public List<Machine> getMachines() {
		return machines;
	}

	public void setMachines(List<Machine> machines) {
		this.machines = machines;
	}

	public List<Subscription> getSuscriptions() {
		return suscriptions;
	}

	public void setSuscriptions(List<Subscription> suscriptions) {
		this.suscriptions = suscriptions;
	}
	
	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public int getN_alerts() {
		for (Event event : this.events) if(event.getStatus().equalsIgnoreCase("pending")) n_alerts++;
		return n_alerts;
	}

	public void setN_alerts(int n_alerts) {
		this.n_alerts = n_alerts;
	}

	private static final long serialVersionUID = 1L;
}