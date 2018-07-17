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
@Table(name="linechannel")
public class LineChannel implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@NotNull
	private Long lineChannelId;
	
	@NotEmpty
	@NotNull
	private String type;

	@OneToMany(mappedBy="linechannelObj", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Machine> machines;
	
	@OneToMany(mappedBy="linechannelObj", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Suscription> suscriptions;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLineChannelId() {
		return lineChannelId;
	}

	public void setLineChannelId(Long lineChannelId) {
		this.lineChannelId = lineChannelId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public List<Machine> getMachines() {
		return machines;
	}

	public void setMachines(List<Machine> machines) {
		this.machines = machines;
	}

	public List<Suscription> getSuscriptions() {
		return suscriptions;
	}

	public void setSuscriptions(List<Suscription> suscriptions) {
		this.suscriptions = suscriptions;
	}

	private static final long serialVersionUID = 1L;
}