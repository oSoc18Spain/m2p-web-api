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
@Table(name="linechannel")
public class LineChannel implements Serializable {
	
	@EmbeddedId
	private lineChannelId id;

	@OneToMany(mappedBy="linechannelObj", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Machine> machines;
	
	@OneToMany(mappedBy="linechannelObj", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Suscription> suscriptions;
	
	public lineChannelId getId() {
		return id;
	}

	public void setId(lineChannelId id) {
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
	public class lineChannelId implements Serializable {
		
		private Long lineChannelId;
		
		private String type;
		
		public lineChannelId() {
		}
		
		public lineChannelId(Long lineChannelId, String type) {
			this.lineChannelId = lineChannelId;
			this.type = type;
		}
		
		public Long getLineChannelId() {
			return lineChannelId;
		}

		public String getType() {
			return type;
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof lineChannelId)) return false;
			lineChannelId that = (lineChannelId) o;
			return Objects.equals(getLineChannelId(), that.getLineChannelId()) &&
					Objects.equals(getType(), that.getType());
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(getLineChannelId(), getType());
	    }
		
		private static final long serialVersionUID = 1L;
	}
}