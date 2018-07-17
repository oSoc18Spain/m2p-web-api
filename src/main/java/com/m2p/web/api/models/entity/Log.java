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

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="log")
public class Log implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="inidate")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="dd-MM-yyyy HH:mm:ss")
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
	private Date iniDate;
	
	@Column(name="finaldate")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="dd-MM-yyyy HH:mm:ss")
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
	private Date finalDate;
	
	private String observation;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_resp_id")
	private User userRespObj;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="event_id")
	private Event eventObj;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getIniDate() {
		return iniDate;
	}

	public void setIniDate(Date iniDate) {
		this.iniDate = iniDate;
	}

	public Date getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public User getUserRespObj() {
		return userRespObj;
	}

	public void setUserRespObj(User userRespObj) {
		this.userRespObj = userRespObj;
	}
	
	public Event getEventObj() {
		return eventObj;
	}

	public void setEventObj(Event eventObj) {
		this.eventObj = eventObj;
	}

	private static final long serialVersionUID = 1L;
}