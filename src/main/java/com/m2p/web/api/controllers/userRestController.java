package com.m2p.web.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2p.web.api.models.entity.User;
import com.m2p.web.api.models.services.IUserService;

@CrossOrigin(origins = {"hhtp://localhost:4200"})
@RestController
@RequestMapping("/api")
public class userRestController
{
	 @Autowired
	 private IUserService userService;
	 
	 @GetMapping("/user/{id}")
	 public User getUserById(@PathVariable String id)
	 {
		 System.out.println("-------------------------------"+id);
		 return userService.findById(id);
	 }
}
