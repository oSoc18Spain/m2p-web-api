package com.m2p.web.api.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m2p.web.api.models.entity.Role;
import com.m2p.web.api.models.dao.IRoleDao;

@Service
public class RoleService implements IRoleService {
	
	@Autowired
	private IRoleDao roleDao;

	@Override
	@Transactional(readOnly = true)
	public List<Role> findAll() {
		return (List<Role>)roleDao.findAll();
	}
}