package com.m2p.web.api.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m2p.web.api.models.dao.ILineChannelDao;
import com.m2p.web.api.models.entity.LineChannel;

@Service
public class LineChannelService implements ILineChannel {
	
	@Autowired
	private ILineChannelDao linechannelDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<LineChannel> findAll() {
		return (List<LineChannel>) linechannelDao.findAll();
	}
	
	@Override
	@Transactional
	public void save(LineChannel linechannel) {
		linechannelDao.save(linechannel);
	}
}