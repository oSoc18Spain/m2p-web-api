package com.m2p.web.api.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="notifyalert")
public class NotifyAlert implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="inidate")
	@Temporal(TemporalType.DATE)
	private Date iniDate;
	
	@Column(name="finaldate")
	@Temporal(TemporalType.DATE)
	private Date finalDate;
	
	@Column(name="inihour")
	@Temporal(TemporalType.TIME)
	private Date iniHour;
	
	@Column(name="finalhour")
	@Temporal(TemporalType.TIME)
	private Date finalHour;
	
	private String description;
	
	private String state;
	
	@OneToOne
	@JoinColumn(name = "rolid")
	private Role rol;
	
	@OneToOne
	@JoinColumn(name = "userate")
	private User userA;
	
	@ManyToOne
	@JoinColumn(name="usergen")
	private User userG;
	
	@ManyToOne
	@JoinColumn(name="maquinaid")
	private Machine maquina;
	
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

	public Date getIniHour() {
		return iniHour;
	}

	public void setIniHour(Date iniHour) {
		this.iniHour = iniHour;
	}

	public Date getFinalHour() {
		return finalHour;
	}

	public void setFinalHour(Date finalHour) {
		this.finalHour = finalHour;
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

	private static final long serialVersionUID = 1L;
}