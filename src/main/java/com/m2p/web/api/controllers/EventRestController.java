package com.m2p.web.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2p.web.api.models.entity.Event;
import com.m2p.web.api.models.services.IEventService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class EventRestController {
	@Autowired
	private IEventService eventService;
	
	@GetMapping("/events")
	public List<Event> index(){
		return eventService.findAll();
	}
}