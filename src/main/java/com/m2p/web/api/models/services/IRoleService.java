package com.m2p.web.api.models.services;

import java.util.List;

import com.m2p.web.api.models.entity.Role;

public interface IRoleService {
	public List<Role> findAll();
	public Role findById(Long id);
}