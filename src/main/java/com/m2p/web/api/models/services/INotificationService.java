package com.m2p.web.api.models.services;

import java.util.List;

import com.m2p.web.api.models.entity.Notification;

public interface INotificationService {
	public List<Notification> findAll();
	public void save(Notification notification);
	public Notification findById(Long id);
}
