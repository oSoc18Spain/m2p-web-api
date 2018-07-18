package com.m2p.web.api.models.services;

import java.util.List;

import com.m2p.web.api.models.entity.Machine;

public interface IMachineService {
	public List<Machine> findAll();
	public void save(Machine machine);
	public Machine findById(Long id);
}