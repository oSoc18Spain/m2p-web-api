package com.m2p.web.api.models.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String password;
	
	@ManyToOne
	@JoinColumn(name="idrol")
	private Role rolId;
	
	@OneToMany(mappedBy="userG")
	private Set<NotifyAlert> notificacionesG;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Role getRolId() {
		return rolId;
	}

	public void setRolId(Role rolId) {
		this.rolId = rolId;
	}

	private static final long serialVersionUID = 1L;
}