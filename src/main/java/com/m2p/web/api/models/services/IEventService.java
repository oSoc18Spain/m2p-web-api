package com.m2p.web.api.models.services;

import java.util.List;

import com.m2p.web.api.models.entity.Event;

public interface IEventService {
	public List<Event> findAll();
}
