package com.m2p.web.api.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.m2p.web.api.models.entity.Log;

public interface ILogDao extends CrudRepository<Log, Long> {}