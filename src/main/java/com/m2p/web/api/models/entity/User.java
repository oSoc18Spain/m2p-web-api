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
@Table(name="user")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String password;
	
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role roleObj;

	@OneToMany(mappedBy="useractualObj")
	private Set<Event> eventos;
	
	@OneToMany(mappedBy="userRespObj")
	private Set<Log> logs;
	
	@OneToMany(mappedBy="userObj")
	private Set<Suscription> suscriptions;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Role getRoleObj() {
		return roleObj;
	}

	public void setRoleObj(Role roleObj) {
		this.roleObj = roleObj;
	}

	public Set<Event> getEventos() {
		return eventos;
	}

	public void setEventos(Set<Event> eventos) {
		this.eventos = eventos;
	}

	public Set<Log> getLogs() {
		return logs;
	}

	public void setLogs(Set<Log> logs) {
		this.logs = logs;
	}

	public Set<Suscription> getSuscriptions() {
		return suscriptions;
	}

	public void setSuscriptions(Set<Suscription> suscriptions) {
		this.suscriptions = suscriptions;
	}
	
	private static final long serialVersionUID = 1L;
}