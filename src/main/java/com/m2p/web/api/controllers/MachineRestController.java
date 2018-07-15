package com.m2p.web.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2p.web.api.models.services.IMachineService;
import com.m2p.web.api.models.entity.Machine;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class MachineRestController {
	@Autowired
	private IMachineService machineService;
	
	@GetMapping("/machines")
	public List<Machine> index(){
		return machineService.findAll();
	}
}