package com.m2p.web.api.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m2p.web.api.models.dao.ILogDao;
import com.m2p.web.api.models.entity.Log;

@Service
public class LogService implements ILogService {
	
	@Autowired
	private ILogDao logDao;

	@Override
	@Transactional(readOnly = true)
	public List<Log> findAll() {
		return (List<Log>) logDao.findAll();
	}

	@Override
	@Transactional
	public void save(Log log) {
		logDao.save(log);
	}
}