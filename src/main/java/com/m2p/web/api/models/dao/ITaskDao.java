package com.m2p.web.api.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.m2p.web.api.models.entity.Task;

public interface ITaskDao extends CrudRepository<Task, Long> {}