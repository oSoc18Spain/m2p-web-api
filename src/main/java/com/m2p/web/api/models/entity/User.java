package com.m2p.web.api.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user")
public class User implements Serializable {
	@Id
	private String id;
	
	@NotEmpty
	@NotNull
	private String password;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="role_id")
	@JsonIgnore
	private Role roleObj;

	@OneToMany(mappedBy="userAssignedObj", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Event> assignedEvents;
	
	@OneToMany(mappedBy="userCreateObj", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Event> createdEvents;
	
	@OneToMany(mappedBy="userRespObj", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Log> logs;
	
	@OneToMany(mappedBy="userObj", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Suscription> suscriptions;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Role getRoleObj() {
		return roleObj;
	}

	public void setRoleObj(Role roleObj) {
		this.roleObj = roleObj;
	}

	public List<Event> getAssignedEvents() {
		return assignedEvents;
	}

	public void setAssignedEvents(List<Event> assignedEvents) {
		this.assignedEvents = assignedEvents;
	}

	public List<Log> getLogs() {
		return logs;
	}

	public void setLogs(List<Log> logs) {
		this.logs = logs;
	}

	public List<Suscription> getSuscriptions() {
		return suscriptions;
	}

	public void setSuscriptions(List<Suscription> suscriptions) {
		this.suscriptions = suscriptions;
	}
	
	private static final long serialVersionUID = 1L;
}