package com.m2p.web.api.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="event")
public class Event implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@NotNull
	private String stateEvent; // {NA, EP, F}
	
	@NotEmpty
	@NotNull
	private String description;
	
	@NotEmpty
	@NotNull
	private String type; //{ AUTOMATIC, MANUAL}
	
	@Column(name="date")
	@Temporal(TemporalType.TIMESTAMP)
	@NotEmpty
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.NUMBER)
	private Date date;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="task_id")
	private Task taskObj;
	
	@OneToMany(mappedBy="eventObj", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Log> logs;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="machine_id")
	@JsonIgnore
	private Machine machineObj;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userassigned_id")
	@JsonIgnore
	private User userAssignedObj;
	
	@OneToMany(mappedBy="eventObj", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Notification> notifications;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStateEvent() {
		return stateEvent;
	}

	public void setStateEvent(String stateEvent) {
		this.stateEvent = stateEvent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Log> getLogs() {
		return logs;
	}

	public void setLogs(List<Log> logs) {
		this.logs = logs;
	}

	public Machine getMachineObj() {
		return machineObj;
	}

	public void setMachineObj(Machine machineObj) {
		this.machineObj = machineObj;
	}
	
	public User getUserAssignedObj() {
		return userAssignedObj;
	}

	public void setUserAssignedObj(User userAssignedObj) {
		this.userAssignedObj = userAssignedObj;
	}

	public Task getTaskObj() {
		return taskObj;
	}

	public void setTaskObj(Task taskObj) {
		this.taskObj = taskObj;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	private static final long serialVersionUID = 1L;
}