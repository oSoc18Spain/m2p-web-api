package com.m2p.web.api.models.services;

import java.util.List;

import com.m2p.web.api.models.entity.Subscription;

public interface ISubscriptionService {
	public Subscription findByUserLineChannel(String userId, Long lineaId);
	public List<Subscription> findByUser(String userId);
	public Subscription save(Subscription data);
}