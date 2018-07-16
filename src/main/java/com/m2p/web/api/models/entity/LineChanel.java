package com.m2p.web.api.models.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="linechanel")
public class LineChanel implements Serializable {
	
	@EmbeddedId
	private lineChanelId id;

	@OneToMany(mappedBy="linechanelObj", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Machine> machines;
	
	@OneToMany(mappedBy="linechanelObj", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Suscription> suscriptions;
	
	public lineChanelId getId() {
		return id;
	}

	public void setId(lineChanelId id) {
		this.id = id;
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
	
	
	@Embeddable
	public class lineChanelId implements Serializable {
		
		private Long lineChanelId;
		
		private String type;
		
		public lineChanelId() {
		}
		
		public lineChanelId(Long lineChanelId, String type) {
			this.lineChanelId = lineChanelId;
			this.type = type;
		}
		
		public Long getLineChanelId() {
			return lineChanelId;
		}

		public String getType() {
			return type;
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof lineChanelId)) return false;
			lineChanelId that = (lineChanelId) o;
			return Objects.equals(getLineChanelId(), that.getLineChanelId()) &&
					Objects.equals(getType(), that.getType());
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(getLineChanelId(), getType());
	    }
		
		private static final long serialVersionUID = 1L;
	}
}