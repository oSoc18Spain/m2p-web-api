package com.m2p.web.api.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.m2p.web.api.customManager.SubscriptionCreateManager;
import com.m2p.web.api.models.entity.LineChannel;
import com.m2p.web.api.models.entity.Subscription;
import com.m2p.web.api.models.entity.User;
import com.m2p.web.api.models.services.ILineChannelService;
import com.m2p.web.api.models.services.ISubscriptionService;
import com.m2p.web.api.models.services.IUserService;

@CrossOrigin()
@RestController
@RequestMapping("/api")
public class SubscriptionRestController {
	@Autowired
	private ISubscriptionService _subscriptionService;
	
	@Autowired
	private ILineChannelService _linechannelService;
	
	@Autowired
	private IUserService _userService;
	
	@PostMapping("/subscriptiononlines")
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody SubscriptionCreateManager subscriptionM) {
		List<Subscription> _mySubscription = _subscriptionService.findByUser(subscriptionM.getUser_id());
		// Elimina las subscriptions a nivel logico, cambiando el estado a -1
		for (Subscription data : _mySubscription) {
			data.setState(-1);
			_subscriptionService.save(data);
		}
		
		// Crea las nuevas subscriptions
		User _userDB = _userService.findById(subscriptionM.getUser_id());
		for (Long lineaID : subscriptionM.getLineschannel_id()) {
			LineChannel _linechannelObj = _linechannelService.findById(lineaID);
			Subscription _subscriptionObj = new Subscription();
			_subscriptionObj.setDateSubscription(new Date());
			_subscriptionObj.setState(1);
			_subscriptionObj.setUserObj(_userDB);
			_subscriptionObj.setLinechannelObj(_linechannelObj);
			_subscriptionService.save(_subscriptionObj);
		}
	}
}