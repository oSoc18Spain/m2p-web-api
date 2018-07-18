package com.m2p.web.api.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.m2p.web.api.models.entity.Event;

public interface IEventDao extends CrudRepository<Event, Long> {
	@Query("select ev from Event ev where ev.status like %?1%")
	public List<Event> findByStatus(String status);
	
	@Query(value = "select ev.*, ev.machine_id from event ev join linechannel lc on lc.id = ev.linechannel_id where ev.state_event like %?2% and ev.linechannel_id = ?1", nativeQuery = true)
	public List<Event> findByLinexStatus(Long lineaId, String status);
	
	@Query(value = "select ev.*, ev.machine_id from event ev where ev.userassigned_id = ?1 and ev.linechannel_id = ?2", nativeQuery = true)
	public List<Event> findByUser(String userId, Long lineaId);
}