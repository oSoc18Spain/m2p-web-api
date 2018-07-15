package com.m2p.web.api.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.m2p.web.api.models.entity.User;

public interface IUserDao extends CrudRepository<User, Long> {}