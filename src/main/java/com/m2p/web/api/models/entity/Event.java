package com.m2p.web.api.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="event")
public class Event implements Serializable {
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
	
	@ManyToOne
	@JoinColumn(name="state_id")
	private State stateObj;
	
	@OneToMany(mappedBy="eventObj")
	private Set<Log> logs;
	
	@ManyToOne
	@JoinColumn(name="machine_id")
	private Machine machineObj;
	
	@ManyToOne
	@JoinColumn(name="useractual_id")
	private User useractualObj;
	
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
	
	public State getStateObj() {
		return stateObj;
	}

	public void setStateObj(State stateObj) {
		this.stateObj = stateObj;
	}
	
	public Set<Log> getLogs() {
		return logs;
	}

	public void setLogs(Set<Log> logs) {
		this.logs = logs;
	}
	
	public Machine getMachineObj() {
		return machineObj;
	}

	public void setMachineObj(Machine machineObj) {
		this.machineObj = machineObj;
	}
	
	public User getUseractualObj() {
		return useractualObj;
	}

	public void setUseractualObj(User useractualObj) {
		this.useractualObj = useractualObj;
	}

	private static final long serialVersionUID = 1L;
}