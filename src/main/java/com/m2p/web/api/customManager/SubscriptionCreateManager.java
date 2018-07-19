package com.m2p.web.api.customManager;

import java.util.ArrayList;

public class SubscriptionCreateManager {
	private String user_id;
	private ArrayList<Long> lineschannel_id = new ArrayList<Long>();
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public ArrayList<Long> getLineschannel_id() {
		return lineschannel_id;
	}
	public void setLineschannel_id(ArrayList<Long> lineschannel_id) {
		this.lineschannel_id = lineschannel_id;
	}
}