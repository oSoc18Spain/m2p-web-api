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
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="machine")
public class Machine implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@NotNull
	private String description;
	
	private String state;
	
	private String data;
	
	@Transient
	private int lineChannelID;
	
	@Column(name="change_ultimate")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="dd-MM-yyyy HH:mm:ss")
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
	private Date changeUltimate;
	
	@OneToMany(mappedBy="machineObj", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Event> events;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="line_channel_id")
	@JsonIgnore
	private LineChannel linechannelObj;
	
	@OneToMany(mappedBy="machineObj",fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Notification> notifications;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public LineChannel getLinechannelObj() {
		return linechannelObj;
	}

	public void setLinechannelObj(LineChannel linechannelObj) {
		this.linechannelObj = linechannelObj;
	}
	
	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}
	
	public Date getChangeUltimate() {
		return changeUltimate;
	}

	public void setChangeUltimate(Date changeUltimate) {
		this.changeUltimate = changeUltimate;
	}

	public int getLineChannelID() {
		return lineChannelID;
	}

	public void setLineChannelID(int lineChannelID) {
		this.lineChannelID = lineChannelID;
	}

	private static final long serialVersionUID = 1L;
}