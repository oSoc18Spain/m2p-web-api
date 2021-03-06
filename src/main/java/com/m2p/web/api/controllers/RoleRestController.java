package com.m2p.web.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2p.web.api.models.services.IRoleService;
import com.m2p.web.api.models.entity.Role;

@CrossOrigin()
@RestController
@RequestMapping("/api")
public class RoleRestController {
	@Autowired
	private IRoleService roleService;
	
	@GetMapping("/roles")
	public List<Role> index(){
		return roleService.findAll();
	}
}