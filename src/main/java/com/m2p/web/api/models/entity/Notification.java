package com.m2p.web.api.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="notification")
public class Notification implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@NotNull
	private String message;
	
	@NotEmpty
	@NotNull
	private String type; //{ AUTOMATIC, MANUAL}
	
	@Column(name="date")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="dd-MM-yyyy HH:mm:ss")
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
	private Date date;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="machine_id")
	@JsonIgnore
	private Machine machineObj;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="event_id")
	@JsonIgnore
	private Event eventObj;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public Machine getMachineObj() {
		return machineObj;
	}

	public void setMachineObj(Machine machineObj) {
		this.machineObj = machineObj;
	}

	public Event getEventObj() {
		return eventObj;
	}

	public void setEventObj(Event eventObj) {
		this.eventObj = eventObj;
	}

	private static final long serialVersionUID = 1L;
}