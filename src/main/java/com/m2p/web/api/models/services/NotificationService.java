package com.m2p.web.api.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m2p.web.api.models.dao.INotificationDao;
import com.m2p.web.api.models.entity.Notification;

@Service
public class NotificationService implements INotificationService{
	
	@Autowired
	private INotificationDao notificationDao;
	
	@Override
	public List<Notification> findAll() {
		return (List<Notification>) notificationDao.findAll();
	}

	@Override
	@Transactional
	public void save(Notification notification) {
		notificationDao.save(notification);	
	}

	@Override
	@Transactional(readOnly = true)
	public Notification findById(Long id) {
		return notificationDao.findById(id).orElse(null);
	}	
}