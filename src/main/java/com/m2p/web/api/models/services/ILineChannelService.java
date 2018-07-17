package com.m2p.web.api.models.services;

import java.util.List;

import com.m2p.web.api.models.entity.LineChannel;

public interface ILineChannelService {
	public List<LineChannel> findAll();
	public void save(LineChannel linechannel);
	public LineChannel findById(Long id);
}