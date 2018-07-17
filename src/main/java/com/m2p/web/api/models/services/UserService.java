package com.m2p.web.api.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m2p.web.api.models.entity.User;

@Service
public class UserService implements IUserService
{
	@Autowired
	private IUserService userDao;
	
	@Override
	@Transactional(readOnly = true)
	public User findUserById(String id)
	{
		return userDao.findUserById(id);
	}
}
