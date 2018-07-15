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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="task")
public class Task implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@NotNull
	private String code;
	
	@NotEmpty
	@NotNull
	private String name;
	
	@NotEmpty
	@NotNull
	private String type; // { NOTIFICATION, EVENT } 
	
	@OneToMany(mappedBy="taskObj", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Event> currentEvents;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Event> getCurrentEvents() {
		return currentEvents;
	}

	public void setCurrentEvents(List<Event> currentEvents) {
		this.currentEvents = currentEvents;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	private static final long serialVersionUID = 1L;
}