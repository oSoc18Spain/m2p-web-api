package com.m2p.web.api.repository;

import com.m2p.web.api.models.entity.Event;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface IEventRepository extends Repository<Event, Long> {
	//@Query("SELECT * FROM Todo t where t.state_event = :status")
	//List<Event> findByTitle(String status);
}
