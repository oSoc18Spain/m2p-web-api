package com.m2p.web.api.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="suscription")
public class Suscription implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="datesuscription")
	@Temporal(TemporalType.DATE)
	private Date dateSuscription;
	
	@Column(name="hoursuscription")
	@Temporal(TemporalType.TIME)
	private Date hourSuscription;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getDateSuscription() {
		return dateSuscription;
	}

	public void setDateSuscription(Date dateSuscription) {
		this.dateSuscription = dateSuscription;
	}

	public Date getHourSuscription() {
		return hourSuscription;
	}

	public void setHourSuscription(Date hourSuscription) {
		this.hourSuscription = hourSuscription;
	}

	private static final long serialVersionUID = 1L;
}