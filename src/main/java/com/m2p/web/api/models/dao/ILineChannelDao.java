package com.m2p.web.api.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.m2p.web.api.models.entity.LineChannel;

public interface ILineChannelDao extends CrudRepository<LineChannel, Long> {
	@Query(value = "select lc.* from linechannel lc join subscription sub on sub.line_channel_id = lc.id where sub.user_id = ?1 and sub.state = 1", nativeQuery = true)
	public List<LineChannel> findByUser(String userId);
}