package com.m2p.web.api.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2p.web.api.models.dao.IEventDao;
import com.m2p.web.api.models.entity.Event;

@Service
public class EventService implements IEventService {
	@Autowired
	private IEventDao eventDao;

	@Override
	public List<Event> findAll() {
		return (List<Event>)eventDao.findAll();
	}
}
