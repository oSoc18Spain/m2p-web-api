package com.m2p.web.api.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m2p.web.api.models.dao.IUserDao;
import com.m2p.web.api.models.entity.User;

@Service
public class UserService implements IUserService
{
	@Autowired
	private IUserDao userDao;
	
	@Override
	@Transactional(readOnly = true)
	public User findById(String id)
	{
		return userDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public User findUserForLogin(String id, String password)
	{
		return (User)userDao;
	}
}
