package com.m2p.web.api.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m2p.web.api.models.dao.ISubscriptionDao;
import com.m2p.web.api.models.entity.Subscription;

@Service
public class SubscriptionService implements ISubscriptionService {
	
	@Autowired
	private ISubscriptionDao subscriptionDao;
	
	@Override
	@Transactional(readOnly = true)
	public Subscription findByUserLineChannel(String userId, Long lineaId) {
		return subscriptionDao.findByUserLineChannel(userId, lineaId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Subscription> findByUser(String userId) {
		return subscriptionDao.findByUser(userId);
	}

	@Override
	@Transactional
	public Subscription save(Subscription data) {
		return subscriptionDao.save(data);
	}
}