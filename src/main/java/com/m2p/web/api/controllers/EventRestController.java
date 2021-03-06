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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.m2p.web.api.customManager.EventCreateManager;
import com.m2p.web.api.customManager.EventForLineManager;
import com.m2p.web.api.customManager.EventManager;
import com.m2p.web.api.models.entity.Event;
import com.m2p.web.api.models.entity.Notification;
import com.m2p.web.api.models.services.IEventService;
import com.m2p.web.api.models.services.ILineChannelService;
import com.m2p.web.api.models.services.IMachineService;
import com.m2p.web.api.models.services.INotificationService;
import com.m2p.web.api.models.services.IRoleService;
import com.m2p.web.api.models.services.ITaskService;
import com.m2p.web.api.models.services.IUserService;

@CrossOrigin()
@RestController
@RequestMapping("/api")
public class EventRestController {
	@Autowired
	private IEventService _eventService;
	
	@Autowired
	private IRoleService _roleService;
	
	@Autowired
	private IUserService _userService;
	
	@Autowired
	private IMachineService _machineService;
	
	@Autowired
	private ITaskService _taskService;
	
	@Autowired
	private ILineChannelService _lineChannelService;
	
	@Autowired
	private INotificationService _notificationService;
	
	@GetMapping("/events")
	public List<Event> index(){
		return _eventService.findAll();
	}
	
	/**
	 * Devuelve toda la información de los eventos, agrupados por su respectivo estado
	 * @return
	 */
	@GetMapping("/dashboard")
	public EventManager dashboard(){
		EventManager _eventManager = new EventManager(200, 
												  	  _eventService.findEventForState("pending"),
													  _eventService.findEventForState("in_progress"),
													  _eventService.findEventForState("done"));
		return _eventManager;
	}
	
	@GetMapping("/event/{id}")
	public Event getdata(@PathVariable Long id) {
		return _eventService.findById(id);
	}
	
	/**
	 * Evento creado por el usuario (Manual). Además tambien guarda la Notificación que genera el evento
	 * @param data
	 * @return
	 */
	@PostMapping("/event/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Event createDataMan(@RequestBody EventCreateManager data ) {
		Event _eventObj = new Event();
		_eventObj.setTitle(data.getDescription());
		_eventObj.setTimeInSeconds(new Date());
		_eventObj.setType("manual");
		_eventObj.setStatus("pending");
		
		if(data.getId_role_assigned() != 0 ) _eventObj.setRoleObj(_roleService.findById(Long.valueOf(data.getId_role_assigned())));
		if( !data.getId_employee_assigned().equalsIgnoreCase("0") ) { 
			_eventObj.setUserAssignedObj(_userService.findById(data.getId_employee_assigned()));
			_eventObj.setStatus("in_progress");
		}
		if(data.getId_machine() != 0 ) _eventObj.setMachineObj(_machineService.findById(Long.valueOf(data.getId_machine())));
		
		_eventObj.setUserCreateObj(_userService.findById(data.getId_employee()));
		_eventObj.setTaskObj(_taskService.findById(Long.valueOf(data.getId_task())));
		_eventObj.setLinelchannelObj(_lineChannelService.findById(Long.valueOf(data.getId_line())));
		
		_eventService.save(_eventObj);
		
		Notification _notificationObj = new Notification();
		_notificationObj.setDate(new Date());
		_notificationObj.setType("manual");
		if(data.getId_machine() != 0 ) _notificationObj.setMachineObj(_machineService.findById(Long.valueOf(data.getId_machine())));
		_notificationObj.setMessage(data.getDescription());
		_notificationObj.setEventObj(_eventObj);
		_notificationService.save(_notificationObj);
		
		return _eventObj;
	}
	
	/**
	 * Función que retorna todos los eventos de la linea: Eventos Pendientes y Eventos Asignados al Usarios
	 * eventxline?userId=XXX&linerchannelId=XXX
	 * @param userId
	 * @param linerchannelId
	 * @return
	 */
	@GetMapping("/eventxline")
	public EventForLineManager getEventeForLine(@RequestParam String userId, @RequestParam Long linerchannelId ) {
		EventForLineManager _data = new EventForLineManager(_eventService.findByLinexStatus(linerchannelId, "pending"),
				_eventService.findByUser(userId, linerchannelId));
		return _data;
	}
}