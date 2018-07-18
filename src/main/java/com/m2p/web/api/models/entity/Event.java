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
	
	@Column(name="state_event")
	@NotEmpty
	@NotNull
	private String status; // {pending, in_progress, done}
	
	@Column(name="description")
	@NotEmpty
	@NotNull
	private String title;
	
	@NotEmpty
	@NotNull
	private String type; //{ AUTOMATIC, MANUAL}
	
	@Column(name="date")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.NUMBER)
	private Date timeInSeconds;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="task_id")
	@JsonIgnore
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
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="linechannel_id")
	@JsonIgnore
	private LineChannel linelchannelObj;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="role_id")
	@JsonIgnore
	private Role roleObj;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usercreate_id")
	@JsonIgnore
	private User userCreateObj;
	
	@OneToMany(mappedBy="eventObj", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Notification> notifications;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTimeInSeconds() {
		return timeInSeconds;
	}

	public void setTimeInSeconds(Date timeInSeconds) {
		this.timeInSeconds = timeInSeconds;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
	
	public LineChannel getLinelchannelObj() {
		return linelchannelObj;
	}

	public void setLinelchannelObj(LineChannel linelchannelObj) {
		this.linelchannelObj = linelchannelObj;
	}

	public Role getRoleObj() {
		return roleObj;
	}

	public void setRoleObj(Role roleObj) {
		this.roleObj = roleObj;
	}

	public User getUserCreateObj() {
		return userCreateObj;
	}

	public void setUserCreateObj(User userCreateObj) {
		this.userCreateObj = userCreateObj;
	}

	private static final long serialVersionUID = 1L;
}