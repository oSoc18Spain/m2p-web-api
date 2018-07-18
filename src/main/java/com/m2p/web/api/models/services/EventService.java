package com.m2p.web.api.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m2p.web.api.models.dao.IEventDao;
import com.m2p.web.api.models.entity.Event;

@Service
public class EventService implements IEventService {
	@Autowired
	private IEventDao eventDao;

	@Override
	@Transactional(readOnly = true)
	public List<Event> findAll() {
		return (List<Event>)eventDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Event> findEventForState(String status) {
		return eventDao.findByStatus(status);
	}

	@Override
	@Transactional(readOnly = true)
	public Event findById(Long id) {
		return eventDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void save(Event event) {
		eventDao.save(event);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Event> findByLinexStatus(Long lineaId, String status) {
		return eventDao.findByLinexStatus(lineaId, status);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Event> findByUser(String userId) {
		return eventDao.findByUser(userId);
	}
}