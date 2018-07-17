package com.m2p.web.api.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.m2p.web.api.models.entity.Event;

public interface IEventDao extends CrudRepository<Event, Long> {
	@Query("select ev from Event ev where ev.status like %?1%")
	public List<Event> findByStatus(String status);
}