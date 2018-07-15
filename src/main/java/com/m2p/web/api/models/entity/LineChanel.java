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
@Table(name="linechanel")
public class LineChanel implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@NotNull
	private String type;
	
	@NotEmpty
	@NotNull
	private String name;
	
	@OneToMany(mappedBy="linechanelObj", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Machine> machines;
	
	@OneToMany(mappedBy="linechanelObj", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Suscription> suscriptions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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