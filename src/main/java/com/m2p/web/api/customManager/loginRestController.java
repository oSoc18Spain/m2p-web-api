package com.m2p.web.api.customManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class loginRestController {
	@Autowired
	private login loginStatus;
	
	@GetMapping("/login")
	public String answer() {
		loginStatus = new login();
		
		//answer = 666;
		
		return loginStatus.answer();
	}
}
