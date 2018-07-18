package com.m2p.web.api.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m2p.web.api.models.dao.ITaskDao;
import com.m2p.web.api.models.entity.Task;

@Service
public class TaskService implements ITaskService {
	@Autowired
	private ITaskDao taskDao;

	@Override
	@Transactional(readOnly = true)
	public List<Task> findAll() {
		return (List<Task>)taskDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Task findById(Long id) {
		return taskDao.findById(id).orElse(null);
	}
}