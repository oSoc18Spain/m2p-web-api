package com.m2p.web.api.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.m2p.web.api.models.entity.Subscription;

public interface ISubscriptionDao extends CrudRepository<Subscription, Long> {
	@Query(value = "select * from subscription sub where sub.user_id = ?1 and sub.line_channel_id = ?2 and sub.state = 1", nativeQuery = true)
	public Subscription findByUserLineChannel(String userId, Long lineaId);
	
	@Query(value = "select * from subscription sub where sub.user_id = ?1 and sub.state = 1", nativeQuery = true)
	public List<Subscription> findByUser(String userId);
}