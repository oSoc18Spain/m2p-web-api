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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="suscription")
public class Suscription implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@NotNull
	private int state;
	
	@Column(name="datesuscription")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="dd-MM-yyyy HH:mm:ss")
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
	@NotEmpty
	@NotNull
	private Date dateSuscription;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(
				name="line_channel_id",
				referencedColumnName="lineChannelId"
		),
		@JoinColumn(
				name="line_channel_type",
				referencedColumnName="type"
		)
	})
	@JsonIgnore
	private LineChannel linechannelObj;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	@NotNull
	private User userObj;
	
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

	public LineChannel getLinechannelObj() {
		return linechannelObj;
	}

	public void setLinechannelObj(LineChannel linechannelObj) {
		this.linechannelObj = linechannelObj;
	}

	public User getUserObj() {
		return userObj;
	}

	public void setUserObj(User userObj) {
		this.userObj = userObj;
	}
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	private static final long serialVersionUID = 1L;
}