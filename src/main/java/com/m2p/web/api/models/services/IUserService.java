package com.m2p.web.api.models.services;

import com.m2p.web.api.models.entity.User;

public interface IUserService
{
	public User findUserForId(Long id);
}
