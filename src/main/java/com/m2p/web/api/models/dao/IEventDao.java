package com.m2p.web.api.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.m2p.web.api.models.entity.Event;

public interface IEventDao extends CrudRepository<Event, Long> {}