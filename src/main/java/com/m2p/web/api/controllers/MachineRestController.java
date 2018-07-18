package com.m2p.web.api.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

//import com.m2p.web.api.models.services.ILineChannelService;
import com.m2p.web.api.models.services.IMachineService;
import com.m2p.web.api.models.entity.Machine;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class MachineRestController {
	@Autowired
	private IMachineService machineService;
	
	//@Autowired
	//private ILineChannelService lineChannelService;
	
	@GetMapping("/machines")
	public List<Machine> index(){
		return machineService.findAll();
	}
	
	@PostMapping("/machines")
	@ResponseStatus(HttpStatus.CREATED)
	public Machine create(@RequestBody Machine machine) {
		//System.out.println("Fecha del sistema: " + new Date());
		//System.out.println("Linea: " + machine.getLineChannelID());
		machine.setChangeUltimate(new Date());
		//machine.setLinechannelObj(lineChannelService.findById( Long.valueOf(machine.getLineChannelID())));
		machineService.save(machine);
		return machine;
	}
}