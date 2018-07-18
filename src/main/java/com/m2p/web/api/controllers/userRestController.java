package com.m2p.web.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.m2p.web.api.customManager.employee;
import com.m2p.web.api.customManager.loginAnswerManager;
import com.m2p.web.api.customManager.loginReceiveManager;
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
	
	 @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	 public ResponseEntity<loginAnswerManager> authenticate(@RequestBody loginReceiveManager loginRM)
	 {
		 System.out.println("Is Working");
		 
		 String idEmployee = loginRM.getId_employee();
		 String password = loginRM.getPassword();
		 
		 System.out.println("JSON Receive: " + idEmployee + " | " + password);
		 
		 loginAnswerManager loginAM; 
		 User userDB;
		 
		 userDB = userService.findById(idEmployee);
		 
		 if(userDB != null)
		 {
			 System.out.println("JSON Send: " + userDB.getId() + " | " +  userDB.getPassword()); 
			 
			 if(password.equals(userDB.getPassword()))
			 {
				 loginAM = new loginAnswerManager(
						 200,
						 new employee(userDB.getId(), userDB.getRoleObj().getName())
						 );
			 }
			 else
			 {
				 loginAM = new loginAnswerManager(
						 400,
						 new employee(idEmployee, "Password Incorrect")
						 ); 
			 }
		 }
		 else
		 {
			 loginAM = new loginAnswerManager(
					 400,
					 new employee(idEmployee, "User not found")
					 ); 
		 }
		 
		 return new ResponseEntity<loginAnswerManager>(loginAM, HttpStatus.OK);
	 }
}
