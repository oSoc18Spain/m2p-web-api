package com.m2p.web.api.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.m2p.web.api.models.entity.Log;
import com.m2p.web.api.models.services.IEventService;
import com.m2p.web.api.models.services.ILogService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class LogRestController {
	@Autowired
	private ILogService logService;
	
	@Autowired
	private IEventService eventService;
	
	@GetMapping("/logs")
	public List<Log> index(){
		return logService.findAll();
	}
	
	/**
	 * Función que registra los log de los eventos
	 * @param log
	 * @param id
	 * @return
	 */
	@PostMapping("/log/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Log create(@RequestBody Log log, @PathVariable Long id) {
		log.setIniDate(new Date());
		log.setEventObj(eventService.findById(id));
		logService.save(log);
		return log;
	}
}