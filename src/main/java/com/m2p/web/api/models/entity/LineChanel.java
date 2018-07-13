package com.m2p.web.api.models.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="linechanel")
public class LineChanel implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String typeLineChanel;
	
	private String nameLineChanel;
	
	@OneToMany(mappedBy="linechanelObj")
	private Set<Machine> machines;
	
	@OneToMany(mappedBy="linechanelObj")
	private Set<Suscription> suscriptions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTypeLineChanel() {
		return typeLineChanel;
	}

	public void setTypeLineChanel(String typeLineChanel) {
		this.typeLineChanel = typeLineChanel;
	}

	public String getNameLineChanel() {
		return nameLineChanel;
	}

	public void setNameLineChanel(String nameLineChanel) {
		this.nameLineChanel = nameLineChanel;
	}

	public Set<Machine> getMachines() {
		return machines;
	}

	public void setMachines(Set<Machine> machines) {
		this.machines = machines;
	}

	public Set<Suscription> getSuscriptions() {
		return suscriptions;
	}

	public void setSuscriptions(Set<Suscription> suscriptions) {
		this.suscriptions = suscriptions;
	}

	private static final long serialVersionUID = 1L;
}