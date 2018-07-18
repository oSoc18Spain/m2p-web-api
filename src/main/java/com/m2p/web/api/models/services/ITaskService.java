package com.m2p.web.api.models.services;

import java.util.List;

import com.m2p.web.api.models.entity.Task;

public interface ITaskService {
	public List<Task> findAll();
	public Task findById(Long id);
}