package com.m2p.web.api.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m2p.web.api.models.entity.Machine;
import com.m2p.web.api.models.dao.IMachineDao;

@Service
public class MachineService implements IMachineService {
	
	@Autowired
	private IMachineDao machineDao;

	@Override
	@Transactional(readOnly = true)
	public List<Machine> findAll() {
		return (List<Machine>) machineDao.findAll();
	}
}