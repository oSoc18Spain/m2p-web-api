package com.m2p.web.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2p.web.api.models.entity.LineChannel;
import com.m2p.web.api.models.services.ILineChannelService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class LineChannelRestController {
	@Autowired
	private ILineChannelService lineChannelService;
	
	@GetMapping("/lineschannel")
	public List<LineChannel> index(){
		return lineChannelService.findAll();
	}
	
	@GetMapping("/linechannel/{id}")
	public LineChannel getdata(@PathVariable Long id) {
		return lineChannelService.findById(id);
	}
	
	@GetMapping("/mylineschannels/{userId}")
	public List<LineChannel> mysubscriptions(@PathVariable String userId){
		return lineChannelService.findByUser(userId);
	}
}