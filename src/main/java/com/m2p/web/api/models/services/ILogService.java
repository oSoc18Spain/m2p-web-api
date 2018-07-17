package com.m2p.web.api.models.services;

import java.util.List;

import com.m2p.web.api.models.entity.Log;

public interface ILogService {
	public List<Log> findAll();
	public void save(Log log);
}